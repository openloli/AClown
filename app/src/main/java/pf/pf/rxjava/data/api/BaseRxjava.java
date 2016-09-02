package pf.pf.rxjava.data.api;


import pf.pf.rxjava.data.ApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Bingo on 2016/6/13.
 */
public class BaseRxjava {
    protected String url = "http://115.28.82.165";//默认通用url部分
    protected ApiService apiService;

    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

}
