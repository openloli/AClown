package pf.pf.rxjava.data.api;

import android.util.Log;
import android.widget.TextView;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import pf.pf.rxjava.data.modle.BUser;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 【获取apk更新信息】
 * 写成每个类，是为了后面好直接拿来用
 * 全写在一个类的容易混乱。
 * url是通用部分， 如果具体url有变化，可以在apiservie 直接修改。
 * 该类没有把 new Retrofit 部分抽离
 */
public class LoginDemo extends  BaseRxjava{


    String str = "";
    public void useRx(final TextView tv, String url) {
        RequestBody user = new FormBody.Builder()
                .add("username", "15053217560")
                .add("password", "12345").build();


        apiService.login(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BUser>() {
                    @Override
                    public void onCompleted() {
//                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
//                        mProgressBar.setVisibility(View.GONE);
                        tv.setText("error::"+e.getMessage());
                        Log.i("QT","onError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(BUser r) {
                        str=str+r.getCode()+"\n";
                        str=str+"json:"+r.getMessage()+"\n";

                        str=str+r.getData().getName()+"\n";
                        str=str+r.getData().getImage()+"\n";
                        str=str+r.getData().getLearn_id()+"\n";
                        str=str+r.getData().getTalent()+"\n";
                        str=str+r.getData().getUid()+"\n";
                        str=str+r.getData().getUsertype()+"\n";


                        tv.setText(str);
                    }
                });
    }

}
