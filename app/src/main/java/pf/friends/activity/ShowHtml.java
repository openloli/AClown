package pf.friends.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import pf.friends.adapter.IndexAdapter;
import pf.friends.bean.ListsBean;
import pf.friends.callback.PullCallback;
import pf.friends.rxjava.RxListIndex1;
import pf.friends.rxjava.RxListIndex2;
import pf.friends.view.CustomGridView;
import pf.friends.view.myrecyclerview.DividerItemDecoration;
import pf.friends.view.myrecyclerview.PullToLoadView;
import pf.pf.R;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Bingo on 2016/9/2.
 */
public class ShowHtml extends AppCompatActivity {

    private PullToLoadView mPullToLoadView;
    private ImageView iv_default;
    private RecyclerView mRecyclerView;
    private IndexAdapter mAdapter;
    private ArrayList<ListsBean> mEvaluataions;

    private int pageNo = 1;
    private int mPageCount;
    public CustomGridView gv_image;
    private boolean isLoading = false;//是否是加载中
    private boolean isHasLoadedAll = false;//是否一次加载全部
    private boolean mIsRefresh = false;//是否是刷新
    List<ListsBean> mEaluationBean = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_news);


        initView();

    }

    private void initView() {
        mPullToLoadView = (PullToLoadView) findViewById(R.id.comments_html);
        iv_default = (ImageView) findViewById(R.id.iv_default_html);
        mRecyclerView = mPullToLoadView.getRecyclerView();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
//        添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mPullToLoadView.isLoadMoreEnabled(true);
        mPullToLoadView.setPullCallback(setPullCallback());


        Log.e("QT", "系统当前时间1--->" +  SystemClock.currentThreadTimeMillis());

        initTask00(pageNo);
    }

    /**
     * RecyclerView的事件回调
     *
     * @return
     */
    private PullCallback setPullCallback() {
        return new PullCallback() {
            @Override
            public void onLoadMore() {

//                这里其实我写的不严谨，不过这不是重点
                if (50 == mPageCount) {
                    initTask00(++pageNo);
                } else {
                    isLoading = false;
                    if (mPullToLoadView != null) {
                        mPullToLoadView.setComplete();
                    }
                }
            }

            @Override
            public void onRefresh() {
                isHasLoadedAll = false;
                mIsRefresh = true;
                initTask00(pageNo = 1);
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return isHasLoadedAll;
            }
        };
    }


    private void initview1(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Connection conn = Jsoup.connect(url);
                    Document doc = conn.timeout(10000).get();

                    Element contentEle = doc.getElementById("NewsContentLabel");
//                        String strs = contentEle.getElementById("NewsContentLabel").text();//这样会丢失标签
                    String strs = contentEle.getElementById("NewsContentLabel").toString();//保留标签
                    Log.e("QT", "新闻主体内容文字--->" + strs);


                    Elements images = contentEle.getElementsByTag("img");
                    String[] imageUrls = new String[images.size()];
                    for (int i = 0; i < imageUrls.length; i++) {
                        imageUrls[i] = images.get(i).attr("src");
                    }

                    for (String str : imageUrls) {
                        Log.e("QT", "图片地址--->" + str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("QT", "新闻主体内容--->Exception" + e.toString());
                }
            }
        }).start();


//        Element articleEle = doc.getElementById("CBArticle");
//// 标题
//        Element titleEle = articleEle.getElementById("article_title");
//        String titleStr = titleEle.text();

        //// 新闻主体内容
////        document.getElementById('xxx').innerHTML
//        Element contentEle = doc.getElementById("NewsContentLabel").innerHTML();
//        String contentStr = contentEle.toString();
//        Log.e("QT", "新闻主体内容--->" + contentStr);
    }

    public static String doGet(String urlStr) throws Exception {
        URL url;
        String html = "";
        try {
            url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();
                html = inToStringByByte(in);
            } else {
                Log.e("QT", "--->新闻服务器返回值为" + connection.getResponseCode());
                throw new Exception("新闻服务器返回值不为200");
            }
        } catch (Exception e) {
            Log.e("QT", "get请求失败" + e.toString());
            throw new Exception("get请求失败");
        }
        return html;
    }


    public static String inToStringByByte(InputStream in) throws Exception {
        ByteArrayOutputStream outStr = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        StringBuilder content = new StringBuilder();
        while ((len = in.read(buffer)) != -1) {
            content.append(new String(buffer, 0, len, "UTF-8"));
        }
        outStr.close();
        return content.toString();
    }


    private Subscription subscription;

    private void initTask00(int page) {

        subscription = new RxListIndex1("index" + page + ".html")
                .getGistObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ListsBean>>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("QT", "onError：" + e.toString());
                    }

                    @Override
                    public void onNext(List<ListsBean> gist) {
//
//                        for (ListsBean b : beans) {
//                            Log.e("QT", "- - - - - - - - - - - - - - - --->");
//                            Log.e("QT", "时间--->" + b.getUrl());
//                            Log.e("QT", "时间--->" + b.getTitle());
//                            Log.e("QT", "时间--->" + b.getTime());
//                        }
//
////                        initview1(gist.get(0).getUrl());
                        Log.e("QT", "系统当前时间2--->" +  SystemClock.currentThreadTimeMillis());
                        initData(gist);
                    }
                });
    }

    private void initData(List<ListsBean> indesBean) {

        if (mAdapter == null) {
            mAdapter = new IndexAdapter(this);
            mAdapter.addEaluationDataAll((ArrayList) indesBean);
            mRecyclerView.setAdapter(mAdapter);
            mIsRefresh = false;
        } else {
            if (mIsRefresh) {
                mAdapter.clearAdapter();
                mIsRefresh = false;
            }
            //延时1秒，让客户看到
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    mPullToLoadView.setSwipeRefreshing(false);
                    mPullToLoadView.setComplete();
                }
            }, 3000);
            mAdapter.addEaluationDataAllNotifyData(mEvaluataions);
        }


    }

    private void initTask01(String url) {

        subscription = new RxListIndex2(url)
                .getGistObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ListsBean>>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("QT", "onError：" + e.toString());
                    }

                    @Override
                    public void onNext(List<ListsBean> gist) {

//                        for (ListsBean b : beans) {
//                            Log.e("QT", "- - - - - - - - - - - - - - - --->");
//                            Log.e("QT", "时间--->" + b.getUrl());
//                            Log.e("QT", "时间--->" + b.getTitle());
//                            Log.e("QT", "时间--->" + b.getTime());
//                        }
//
//                        initview1(gist.get(0).getUrl());
                    }
                });
    }



}
