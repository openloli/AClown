package pf.pf.rxjava.data.api;

import android.util.Log;
import android.widget.TextView;


import pf.pf.rxjava.data.modle.ApkInfo;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Bingo on 2016/6/13.
 */
public class ApkInfoDemo extends  BaseRxjava{
    /**
     * 【获取apk更新信息】
     * 写成每个类，是为了后面好直接拿来用
     * 全写在一个类的容易混乱。
     * url是通用部分， 如果具体url有变化，可以在apiservie 直接修改。
     * 该类没有把 new Retrofit 部分抽离
     */

    String str = "";
    public void useRx(final TextView tv, String url) {
        Log.e("QT","22222");
        apiService.getSoft2("getSoft")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ApkInfo>() {
                    @Override
                    public void onCompleted() {
//                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        tv.setText(e.getMessage());
                        Log.i("QT", "onError:" + e.getMessage());
                    }

                    @Override
                    public void onNext(ApkInfo r) {
                        str = str + r.code + "\n";
                        str = str + r.message + "\n";
                        str = str + r.data.code + "\n";
                        str = str + r.data.des + "\n";
                        str = str + r.data.name + "\n";
                        str = str + r.data.url + "\n";

                        tv.setText(str);
                    }
                });
    }

}
