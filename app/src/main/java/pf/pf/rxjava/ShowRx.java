package pf.pf.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import pf.pf.R;
import pf.pf.rxjava.data.api.ApkInfoDemo;
import pf.pf.rxjava.data.api.LoginDemo;
import pf.pf.rxjava.data.api.MajorDemo;


/**
 * Created by Bingo on 2016/6/21.
 */
public class ShowRx extends AppCompatActivity {

    //    private static final String ENDPOINT = "http://ip.taobao.com";
//    http://115.28.82.165/putData/getSoft
    private static final String ENDPOINT = "http://115.28.82.165";
    private static final String ENDPOINT2 = "http://115.28.82.165/putData/";
    private TextView tv_01;
    private Button btn_01, btn_02,btn_03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.rx_main);
        initView();
    }

    private void initView() {
        tv_01 = (TextView) findViewById(R.id.tv_01);
        btn_01 = (Button) findViewById(R.id.btn_01);
        btn_02 = (Button) findViewById(R.id.btn_02);
        btn_03 = (Button) findViewById(R.id.btn_03);

        btn_01.setText("【GET】获取专业地址");
        btn_02.setText("【GET】获取apk更新信息");
        btn_03.setText("【POST】获取登陆信息");

        btnOnclick();
    }

    private void btnOnclick() {
        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**【微知库】获取默认专业的地址*/
                new MajorDemo().useRx(tv_01, ENDPOINT);
            }
        });
        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**【请托】获取apk更新信息*/
                new ApkInfoDemo().useRx(tv_01, ENDPOINT);
            }
        });

        btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**【请托】post  login*/
                new LoginDemo().useRx(tv_01, ENDPOINT);
            }
        });
    }

}
