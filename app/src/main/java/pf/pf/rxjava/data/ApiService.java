package pf.pf.rxjava.data;




import okhttp3.RequestBody;
import pf.pf.rxjava.data.modle.ApkInfo;
import pf.pf.rxjava.data.modle.BUser;
import pf.pf.rxjava.data.modle.Major;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 *
 */
public interface ApiService {

    @GET("putData/{str}")
    Call<ApkInfo> getSoft(@Path("str") String user);

    @GET("putData/{str}")
    Observable<ApkInfo>  getSoft2(@Path("str") String user);

    @GET("http://182.92.129.16/xiaomi/index.php/wangjian/url")
    Observable<Major>  getDefMajor();

    @POST("http://115.28.82.165/putData/login")
    Observable<BUser>  login(@Body RequestBody user);

}
