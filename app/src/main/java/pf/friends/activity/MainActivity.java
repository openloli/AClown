package pf.friends.activity;


import android.support.v7.app.AppCompatActivity;


/**
 * Created by mabeijianxi on 2016/1/15.
 */
public class MainActivity extends AppCompatActivity {}
//        implements View.OnClickListener, NetWorkCallback {
//    /**
//     * 本接口不一定长期有效，如果不能正常请求的话可以自定义实现数据
//     */
//    private static final String URL = "http://123.57.162.168:8081/mall/app/goods/evaluation/list.json";
//    private PullToLoadView mPullToLoadView;
//    private ImageView iv_default;
//    private RecyclerView mRecyclerView;
//    private EaluationAdapter mAdapter;
//    private ArrayList<EaluationListBean> mEvaluataions;
//    /**
//     * 得到的json串
//     */
//    private String mDataString;
//    /**
//     * 是否是刷新
//     */
//    private boolean mIsRefresh = false;
//    /**
//     * 是否是加载中
//     */
//    private boolean isLoading = false;
//    /**
//     * 是否是第一次加载
//     */
//    private boolean mHasLoadedOnce = false;
//    /**
//     * 是否一次加载全部
//     */
//    private boolean isHasLoadedAll = false;
//    /**
//     * 页面号
//     */
//    private int pageNo = 1;
//    private int mPageCount;
//    private OkRequestCallBack okRequestCallBack;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initView();
//        initeven();
//        parseLocal();
//        startNetworkLoad();
//    }
//
//    /**
//     * 开始网络请求
//     */
//    private void startNetworkLoad() {
//        if (!mHasLoadedOnce && mPullToLoadView != null) {
//            mPullToLoadView.initNetLoad(this);
//        }
//    }
//
//    /**
//     * 本地数据加载（如果有缓存）
//
//     */
//
//    String str9="{\\\"now\\\":1472522569212,\\\"data\\\":{\\\"goodsId\\\":98573,\\\"pageCount\\\":1,\\\"goodCount\\\":2,\\\"evaluataions\\\":[{\\\"anonymous\\\":0,\\\"content\\\":\\\"评价\\\",\\\"sid\\\":98573,\\\"evaluationId\\\":80,\\\"gradePercent\\\":\\\"80%\\\",\\\"evaluatereplys\\\":[{\\\"erContent\\\":\\\"啦啦啦\\\",\\\"erReplytime\\\":\\\"2016-04-15 19:59:46\\\",\\\"erid\\\":15,\\\"erReplyuser\\\":\\\"winter_jyo2o\\\"}],\\\"userName\\\":\\\"Xrg\\\",\\\"grade\\\":4,\\\"creatTime\\\":\\\"2016-01-29 15:12:04\\\",\\\"orderId\\\":\\\"238211\\\"},{\\\"anonymous\\\":1,\\\"content\\\":\\\"同感vv帮不帮\\\",\\\"sid\\\":98573,\\\"evaluationId\\\":79,\\\"gradePercent\\\":\\\"20%\\\",\\\"userName\\\":\\\"X****\\\",\\\"grade\\\":1,\\\"attachments\\\":[{\\\"imageId\\\":\\\"56a9eec30cf239b75fc5f37d\\\",\\\"attachmentId\\\":77,\\\"imageUrl\\\":\\\"http://123.57.255.1:8068/group1/M00/02/B9/ezn_AVap8DmADopDAAGtRCAjGyg590.jpg\\\",\\\"smallImageUrl\\\":\\\"http://123.57.255.1:8068/group1/M00/02/B9/ezn_AVap8DmAL311AAAPHa33rQk099.jpg\\\"},{\\\"imageId\\\":\\\"56a9eec40cf239b75fc5f37e\\\",\\\"attachmentId\\\":78,\\\"imageUrl\\\":\\\"http://123.57.255.1:8068/group1/M00/02/B9/ezn_AVap8DqAGZaMAAIph8Hbkkc704.jpg\\\",\\\"smallImageUrl\\\":\\\"http://123.57.255.1:8068/group1/M00/02/B9/ezn_AVap8DqAAYFGAAAS3i4eSTw000.jpg\\\"},{\\\"imageId\\\":\\\"56a9eec50cf239b75fc5f37f\\\",\\\"attachmentId\\\":79,\\\"imageUrl\\\":\\\"http://123.57.255.1:8068/group1/M00/02/B9/ezn_AVap8DuASuCAAAGk2SC_0Hg778.jpg\\\",\\\"smallImageUrl\\\":\\\"http://123.57.255.1:8068/group1/M00/02/B9/ezn_AVap8DqAeFORAAAO4_IGtJg194.jpg\\\"}],\\\"creatTime\\\":\\\"2016-01-28 18:34:42\\\",\\\"orderId\\\":\\\"238212\\\"}]}}" ;
//         private void parseLocal() {
//
////        mDataString = SharedPreferencesUtil.getStringData(this, URL + pageNo + getId(), null);
////        if (!TextUtils.isEmpty(mDataString)) {// 解析数据
//////            Log.e("QT", "获取的数据：" + mDataString);
////            Log.i("QT", "数据的长度：" + mDataString.length());
////
//////            show(mDataString);
////
////
////        }
////             parseData(str9);
//    }
//
//    public static void show(String str) {
//        String str1 = str.substring(0,3200);
//        String str2 = str.substring(3200,6400);
//        String str3 = str.substring(6400,9600);
//        String str4 = str.substring(9600,12800);
//        String str5 = str.substring(12800,str.length());
//
//
////        Log.i("QT", "1获得的长度：" + str1); Log.i("QT", "1获得的长度：" + str1.length());
////        Log.i("QT", "2获得的长度：" + str2); Log.i("QT", "1获得的长度：" + str2.length());
////        Log.i("QT", "3获得的长度：" + str3); Log.i("QT", "1获得的长度：" + str3.length());
////        Log.i("QT", "4获得的长度：" + str4); Log.i("QT", "1获得的长度：" + str4.length());
////        Log.i("QT", "4获得的长度：" + str5); Log.i("QT", "1获得的长度：" + str5.length());
//    }
//
//
//    /**
//     * 初始化事件
//     */
//    private void initeven() {
//        okRequestCallBack = new OkRequestCallBack();
////        注册网络请求回调
//        okRequestCallBack.setNetWorkCallback(this);
//        iv_default.setOnClickListener(this);
//        addScrollListener();
//        mPullToLoadView.setPullCallback(setPullCallback());
//    }
//
//    /**
//     * 添加RecyclerView的滑动事件监听，主要是ListView的优化（快滑处理）
//     */
//    private void addScrollListener() {
//        mRecyclerView.addOnScrollListener(
//                new RecyclerView.OnScrollListener() {
//                    @Override
//                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                        super.onScrollStateChanged(recyclerView, newState);
//                        EaluationAdapter adapter = (EaluationAdapter) recyclerView.getAdapter();
//                        if (adapter != null) {
//                            switch (newState) {
////                                拖拽的时候
//                                case RecyclerView.SCROLL_STATE_DRAGGING:
//                                    adapter.setLoadImage(false);
////                                    adapter.notifyDataSetChanged();
//                                    break;
////                                静止的时候
//                                case RecyclerView.SCROLL_STATE_IDLE:
//                                    adapter.setLoadImage(true);
//                                    adapter.notifyDataSetChanged();
//                                    break;
////                                惯性快滑
//                                case RecyclerView.SCROLL_STATE_SETTLING:
//                                    adapter.setLoadImage(false);
//                                    break;
//                            }
//                        }
//                    }
//                });
//    }
//
//    /**
//     * RecyclerView的事件回调
//     *
//     * @return
//     */
//    private PullCallback setPullCallback() {
//        return new PullCallback() {
//            @Override
//            public void onLoadMore() {
////                这里其实我写的不严谨，不过这不是重点
//                if (20 == mPageCount) {
//                    loadData(++pageNo);
//                } else {
//                    isLoading = false;
//                    if (mPullToLoadView != null) {
//                        mPullToLoadView.setComplete();
//                    }
//
//                }
//            }
//
//            @Override
//            public void onRefresh() {
//                isHasLoadedAll = false;
//                mIsRefresh = true;
//                loadData(pageNo = 1);
//            }
//
//            @Override
//            public boolean isLoading() {
//                return isLoading;
//            }
//
//            @Override
//            public boolean hasLoadedAllItems() {
//                return isHasLoadedAll;
//            }
//        };
//    }
//
//    /**
//     * 初始化view
//     */
//    public void initView() {
//        mPullToLoadView = (PullToLoadView) findViewById(R.id.comments);
//        iv_default = (ImageView) findViewById(R.id.iv_default_two);
//        mRecyclerView = mPullToLoadView.getRecyclerView();
//        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        mRecyclerView.setLayoutManager(manager);
////        添加分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(
//                this, DividerItemDecoration.VERTICAL_LIST));
////        mPullToLoadView.setLoadMoreOffset
//        mPullToLoadView.isLoadMoreEnabled(true);
//
//    }
//
//    /**
//     * 准备网络加载
//     *
//     * @param pageNo
//     */
//    private void loadData(int pageNo) {
//        isLoading = true;
////        当有网络的时候
//        if (CommonUtils.isNetworkConnected(this)) {
//            mPullToLoadView.setVisibility(View.VISIBLE);
//            iv_default.setVisibility(View.GONE);
//            if (getId() != -1) {
//                requestData(pageNo);
//            } else {
//                Toast.makeText(this, "数据错误", Toast.LENGTH_SHORT);
//            }
//        } else if (!CommonUtils.isNetworkConnected(this) && TextUtils.isEmpty(mDataString)) {
//            //没网且没有缓存数据
//            mPullToLoadView.setVisibility(View.GONE);
//            iv_default.setVisibility(View.VISIBLE);
//            Toast.makeText(this, "网络未连接或不可用", Toast.LENGTH_SHORT);
//            if (mPullToLoadView != null) {
//                mPullToLoadView.setSwipeRefreshing(false);
//            }
//        } else {
//            mPullToLoadView.setVisibility(View.VISIBLE);
//            iv_default.setVisibility(View.GONE);
//            //没网但是有缓存
//            Toast.makeText(this, "网络未连接或不可用", Toast.LENGTH_SHORT);
//            parseLocal();
//            if (mPullToLoadView != null) {
//                mPullToLoadView.setComplete();
//            }
//        }
//    }
//
//    /**
//     * 发起网络请求，这里用hongyang封装好的okhttp,比较要用，okhttp的优缺点可以自己查询
//     * 这里必须带入请求的字段是goodsId，页数是为了分页需要
//     *
//     * @param pageNo
//     */
//    private void requestData(int pageNo) {
//
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("goodsId", String.valueOf(getId()));
//        hashMap.put("pageNo", String.valueOf(pageNo));
////        OkHttpUtils.post().params(hashMap).url(URL).build().execute(okRequestCallBack);
//
////        initTask00();
//    }
//
//
//    /**
//     * 得到物品id以便网络请求带上，当然只是本服务器接口需要而已
//     *
//     * @return
//     */
//    public int getId() {
//
//        return 98573;
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
////            加载失败，点击刷新
//            case R.id.iv_default_two:
//                if (mPullToLoadView != null) {
//                    mPullToLoadView.initNetLoad(this);
//                }
//                break;
//        }
//    }
//
//
//    @Override
//    public void onBefore() {
//
//    }
//
//    @Override
//    public void onLoading(float progress) {
//
//    }
//
//    @Override
//    public void onSuccess(String responseInfo) {
//        mHasLoadedOnce = true;
//        isLoading = false;
////        缓存处理
//        SharedPreferencesUtil.saveStringData(this, URL + pageNo + getId(), responseInfo);
//        mDataString = responseInfo;
//        parseData(responseInfo);
//
//        if (mPullToLoadView != null) {
//            mPullToLoadView.setComplete();
//        }
//    }
//
//    @Override
//    public void onFailure(Exception error, String msg) {
//        isLoading = false;
//        parseLocal();
//        if (mPullToLoadView != null) {
//            mPullToLoadView.setComplete();
//        }
//        CommonUtils.errorNetMes(this);
//    }
//
//    /**
//     * 数据解析
//     *
//     * @param mdatatring
//     */
//    private EaluationBean mEaluationBean = null;
//
//    private void parseData(String mdatatring) {
//        try {
//            BaseDataBean<EaluationBean> json = JsonUtil.parseDataObject(mdatatring, EaluationBean.class);
//            if (json.code == 100) {
//                if (json.data != null) {
//                    mEaluationBean = json.data;
//                    mEvaluataions = mEaluationBean.evaluataions;
//                    mPageCount = mEaluationBean.pageCount;
//                }
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
//                    mAdapter.addEaluationDataAllNotifyData(mEvaluataions);
//                }
//            }
//
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//
//    private Subscription subscription;
//    private void initTask00() {
//
//        subscription = new RxLogin("98573","1")
//                .getGistObservable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<String>() {
//
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e){
//                        Log.i("QT", "onError：" + e.toString());
//                    }
//
//                    @Override
//                    public void onNext(String gist) {
//
//                        Log.i("QT", "onNext：" + gist);
//                    }
//                });
//    }
//}
