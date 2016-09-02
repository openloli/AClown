package pf.pf.fresco;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Random;

import pf.pf.R;
import pf.pf.ui.API;

public class SexImages extends AppCompatActivity {
    private SimpleDraweeView draweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        initImage();
    }

    private void initImage() {
        draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(new API().apis[new Random().nextInt(new API().apis.length)]);//随机一个url
                draweeView.setImageURI(uri);
            }
        });
    }
}
