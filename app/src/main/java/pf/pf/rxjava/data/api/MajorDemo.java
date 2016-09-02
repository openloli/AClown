package pf.pf.rxjava.data.api;

import android.util.Log;
import android.widget.TextView;

import pf.pf.rxjava.data.modle.Major;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Bingo on 2016/6/13.
 */
public class MajorDemo  extends  BaseRxjava{
    /**
     * 【获取默认的学校专业信息】
     * 写成每个类，是为了后面好直接拿来用
     * 全写在一个类的容易混乱。
     * url是通用部分， 如果具体url有变化，可以在apiservie 直接修改。
     * 该类没有把 new Retrofit 部分抽离
     */

    String str = "";
    public void useRx(final TextView tv, String url) {
        apiService.getDefMajor()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Major>() {
                    @Override
                    public void onCompleted() {
//                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
//                        mProgressBar.setVisibility(View.GONE);
                        tv.setText(e.getMessage());
                        Log.i("QT","onError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(Major r) {
                        str=str+r.code+"\n";
                        str=str+r.info.size()+"\n";
                        str=str+r.info.get(0).mj_name+"\n";
                        str=str+r.info.get(1).mj_name+"\n";
                        str=str+r.info.get(2).mj_name+"\n";
                        str=str+r.info.get(3).mj_name+"\n";
                        str=str+r.info.get(4).mj_name+"\n";
                        str=str+r.info.get(5).mj_name+"\n";


                        tv.setText(str);
                    }
                });
    }

}
