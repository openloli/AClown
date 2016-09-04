package pf.friends.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

import pf.friends.adapter.EaluationAdapter;
import pf.friends.bean.BaseDataBean;
import pf.friends.bean.EaluationBean;
import pf.friends.bean.EaluationListBean;
import pf.friends.callback.PullCallback;
import pf.friends.rxjava.RxLogin;
import pf.friends.utils.JsonUtil;
import pf.friends.view.CustomGridView;
import pf.friends.view.myrecyclerview.DividerItemDecoration;
import pf.friends.view.myrecyclerview.PullToLoadView;
import pf.pf.R;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Bingo on 2016/8/29.
 */
public class ShowText  extends AppCompatActivity {


    private static final String URL = "http://123.57.162.168:8081/mall/app/goods/evaluation/list.json";
    private PullToLoadView mPullToLoadView;
    private ImageView iv_default;
    private RecyclerView mRecyclerView;
    private EaluationAdapter mAdapter;
    private ArrayList<EaluationListBean> mEvaluataions;
    private EaluationBean mEaluationBean = null;
    private int pageNo = 1;
    private int mPageCount;
    public CustomGridView gv_image;
    private boolean isLoading = false;//是否是加载中
    private boolean isHasLoadedAll = false;//是否一次加载全部
    private boolean mIsRefresh = false;//是否是刷新
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview1();
    }

    private void initview1() {
        mPullToLoadView = (PullToLoadView) findViewById(R.id.comments);
        iv_default = (ImageView) findViewById(R.id.iv_default_two);
        mRecyclerView = mPullToLoadView.getRecyclerView();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
//        添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mPullToLoadView.isLoadMoreEnabled(true);
        mPullToLoadView.setPullCallback(setPullCallback());

        initTask00(1);
    }


    private void initData(String str) {
        try {
            BaseDataBean<EaluationBean> json = JsonUtil.parseDataObject(str, EaluationBean.class);
            Log.e("QT", "json.code--->" + json.code);
            if (json.code == 100) {
                if (json.data != null) {
                    mEaluationBean = json.data;
                    mEvaluataions = mEaluationBean.evaluataions;
                    mPageCount = mEaluationBean.pageCount;
                }
//                if (mAdapter == null) {
//                    mAdapter = new EaluationAdapter(this);
//                    mAdapter.addEaluationDataAll(mEvaluataions);
//                    mRecyclerView.setAdapter(mAdapter);
//                    mIsRefresh = false;
//                } else {
//                    if (mIsRefresh) {
//                        mAdapter.clearAdapter();
//                        mIsRefresh = false;
//                    }
//                    //延时1秒，让客户看到
//                    new Handler().postDelayed(new Runnable(){
//                        public void run() {
//                            mPullToLoadView.setSwipeRefreshing(false);
//                            mPullToLoadView.setComplete();
//                        }
//                    }, 3000);
//                    mAdapter.addEaluationDataAllNotifyData(mEvaluataions);
//                }
            }

        } catch (Exception e) {
        }
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
                if (20 == mPageCount) {
//                    loadData(++pageNo);
//                    initData(data2);
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
//                loadData(pageNo = 1);
//                initData(data1);
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


    private Subscription subscription;
    private void initTask00(int pageNo) {

        subscription = new RxLogin("98573",pageNo+"")
                .getGistObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e){
                        Log.i("QT", "onError：" + e.toString());
                    }

                    @Override
                    public void onNext(String gist) {

                        Log.i("QT", "onNext：" + gist);
                        initData(gist);
                    }
                });
    }

}
