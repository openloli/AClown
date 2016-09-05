package pf.friends.rxjava;


import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Func0;


/**
 * 单个子任务详情+指标项列表
 */
public class RxLogin {
    private  final String URL = "http://123.57.162.168:8081/mall/app/goods/evaluation/list.json";
    private String str1, str2;
    public   RxLogin (String str1,String str2){
        this.str1 = str1;
        this.str2 = str2;
    }

    public String getGist() throws IOException {

        OkHttpClient client = new OkHttpClient();
        //get
//        final Request request = new Request.Builder()
//                .url(url)
//                .build();
//        Response response = client.newCall(request).execute();

        //post
        RequestBody formBody = new FormBody.Builder()// new FormEncodingBuilder()//ok2和3的区别
                .add("goodsId", "98573")
                .add("pageNo", str2).build();

        Request request = new Request.Builder().url(URL).post(formBody).build();
        Response response = client.newCall(request).execute();

        if (response.code() == 200) {
            String htmlStr = response.body().string();
            Log.i("QT", "htmlStr" + htmlStr);
            return htmlStr;
        }
        Log.i("QT", "htmlStr!=200" );
        return null;
    }
    public Observable<String> getGistObservable() {
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                try {
                    return Observable.just(getGist());
                } catch (IOException e) {
                    return Observable.error(e);
                }
            }
        });

    }
}