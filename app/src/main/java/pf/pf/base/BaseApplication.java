package pf.pf.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by AXTing on 2016/4/7.
 */
public class BaseApplication extends Application {
    private static final OkHttpClient client = new OkHttpClient.Builder()
            //设置超时，不设置可能会报异常
            .connectTimeout(1000, TimeUnit.MINUTES)
            .readTimeout(1000, TimeUnit.MINUTES)
            .writeTimeout(1000, TimeUnit.MINUTES)
            .build();
    private static BaseApplication mMainContext;
    private static Handler mMainThreadHandler;
    private static Looper mMainThreadLooper;
    private static int mMainThreadId;
    private static Thread mMainThead;
    private static BaseApplication instance;
    private List<Activity> mList = new LinkedList<Activity>();

    public static int getLanguage() {
        return language;
    }

    public static void setLanguage() {
//         ACache aCache = ACache.get(getApplication());
//        String lan = aCache.getAsString("language");
//        lan=  lan==""?"":lan;
//        BaseApplication.language =  Integer.parseInt(lan);
    }

    private static int language;

    public static BaseApplication getApplication() {
        return mMainContext;
    }

    public static OkHttpClient getClient() {
        return client;
    }

    public static Response getResponse(String url) {
        try {
            final Request request = new Request.Builder()
                    .url(url)
                    .build();
            return client.newCall(request).execute();
        } catch (Exception e) {

        }
        return null;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    public static Looper getMainThreadLooper() {
        return mMainThreadLooper;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Thread getMainThread() {
        return mMainThead;
    }

    //实例化一次
    public synchronized static BaseApplication getInstance() {
        if (null == instance) {
            instance = new BaseApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        BaseApplication.mMainContext = this;
        BaseApplication.mMainThreadHandler = new Handler();
        BaseApplication.mMainThreadLooper = getMainLooper();
        BaseApplication.mMainThreadId = android.os.Process.myTid();
        BaseApplication.mMainThead = Thread.currentThread();

//        Fresco.initialize(this);

        initImageLoader(getApplicationContext());//image
    }


    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
//        config.denyCacheImageMultipleSizesInMemory();//不会在内存中缓存多个大小的图片
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());//为了保证图片名称唯一
//        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        //内存缓存大小默认是：app可用内存的1/8
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }


    // add Activity
    public void addActivity(Activity activity) {
        mList.add(activity);
    }

    public void finish() {
        try {
            for (Activity activity : mList) {
                if (activity != null){
//                    Utils.e("BaseApplication 执行【"+activity.getClass().getName()+"】  finish");
                    activity.finish();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    //杀进程
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

}
