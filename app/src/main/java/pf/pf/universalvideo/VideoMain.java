package pf.pf.universalvideo;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pf.pf.R;
import pf.pf.universalvideo.adapter.Adapter_Task00;
import pf.pf.universalvideo.bean.User;

/**
 * Created by Bingo on 2016/8/13.
 */
public class VideoMain extends AppCompatActivity implements UniversalVideoView.VideoViewCallback {

    private String TAG = "MainActivity";
    private String SEEK_POSITION_KEY = "SEEK_POSITION_KEY";
    private String VIDEO_URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

    UniversalVideoView mVideoView;
    UniversalMediaController mMediaController;

    View mBottomLayout;
    View mVideoLayout;
    TextView mStart;

    private int mSeekPosition;
    private int cachedHeight;
    private boolean isFullscreen;

    RecyclerView mRecyclerView;
    Adapter_Task00 mAdapter;
    private List<User> applicationList = new ArrayList<User>();
    ImageView img_text;
//    GifImageView gif_view;
    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        super.onPanelClosed(featureId, menu);
    }

    //    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.uvv_main);

        mVideoLayout = findViewById(R.id.video_layout);
        mBottomLayout = findViewById(R.id.bottom_layout);
        mVideoView = (UniversalVideoView) findViewById(R.id.videoView);
        mMediaController = (UniversalMediaController) findViewById(R.id.media_controller);
        mVideoView.setMediaController(mMediaController);
        setVideoAreaSize("");
        mVideoView.setVideoViewCallback(this);
        mStart = (TextView) findViewById(R.id.start);
        img_text = (ImageView) findViewById(R.id.img_text);

//        gif_view = (GifImageView) findViewById(R.id.gif_view);




        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSeekPosition > 0) {
                    mVideoView.seekTo(mSeekPosition);
                }
                mVideoView.start();
                mMediaController.setTitle("Big Buck Bunny");
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d(TAG, "onCompletion ");
            }
        });
        initRV();

    }

    private void initRV() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//      mRecyclerView.setItemAnimator(new CustomItemAnimator());
        mAdapter = new Adapter_Task00(applicationList, R.layout.uvv_item_video, VideoMain.this);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setVisibility(View.GONE);
//        mProgressBar.setVisibility(View.VISIBLE);


        new InitializeApplicationsTask().execute();
    }

    public void onItemClick(User u, View v) {
        show();
        setImg(false);
        if (mVideoView != null && mVideoView.isPlaying()) {
            mSeekPosition = mVideoView.getCurrentPosition();
            Log.d(TAG, "onPause mSeekPosition=" + mSeekPosition);
            mVideoView.pause();
            mVideoView.resume();
//            mVideoView.release(true);
        }

        mStart.setText("" + u.getDes());
        setVideoAreaSize(u.getDes());
//        if (mSeekPosition > 0) {
//            mVideoView.seekTo(0);
//        }
        //TODO 设置名称
        // TODO 设置名称
        // TODO 设置名称
        // TODO 设置名称
        // TODO 设置名称
        mVideoView.start();
        mMediaController.setTitle(u.getName());
        ;

        if (mVideoView.isPlaying()) {
            Log.e(TAG, "开始播放了。。。。");
        } else {
            Log.e(TAG, "还没有开始播放");
        }
//        mMediaController.reset();
//        mMediaController.showBar();

//        //TODO 测试呼叫 转圈
//        if(loadingLayout!=null){
//            loadingLayout.setVisibility(View.VISIBLE);
//        }
    }

    public class InitializeApplicationsTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            mAdapter.clearApplications();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            applicationList.clear();
            applicationList = GetDatas.getVideoInfo();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //handle visibility
            mRecyclerView.setVisibility(View.VISIBLE);
//            mProgressBar.setVisibility(View.GONE);

            //set data for list
            mAdapter.addApplications(applicationList);
//            mSwipeRefreshLayout.setRefreshing(false);

            super.onPostExecute(result);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause ");
        if (mVideoView != null && mVideoView.isPlaying()) {
            mSeekPosition = mVideoView.getCurrentPosition();
            Log.d(TAG, "onPause mSeekPosition=" + mSeekPosition);
            mVideoView.pause();
        }
    }

    /**
     * 置视频区域大小
     */
    private void setVideoAreaSize(final String url) {
        mVideoLayout.post(new Runnable() {
            @Override
            public void run() {
                int width = mVideoLayout.getWidth();
                cachedHeight = (int) (width * 405f / 720f);
//                cachedHeight = (int) (width * 3f / 4f);
//                cachedHeight = (int) (width * 9f / 16f);
                ViewGroup.LayoutParams videoLayoutParams = mVideoLayout.getLayoutParams();
                videoLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                videoLayoutParams.height = cachedHeight;
                mVideoLayout.setLayoutParams(videoLayoutParams);
                mVideoView.setVideoPath(url);
                mVideoView.requestFocus();
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState Position=" + mVideoView.getCurrentPosition());
        outState.putInt(SEEK_POSITION_KEY, mSeekPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        mSeekPosition = outState.getInt(SEEK_POSITION_KEY);
        Log.d(TAG, "onRestoreInstanceState Position=" + mSeekPosition);
    }


    @Override
    public void onScaleChange(boolean isFullscreen) {
        this.isFullscreen = isFullscreen;
        if (isFullscreen) {
            ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            mVideoLayout.setLayoutParams(layoutParams);
            mBottomLayout.setVisibility(View.GONE);

        } else {
            ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            layoutParams.height = this.cachedHeight;
            mVideoLayout.setLayoutParams(layoutParams);
            mBottomLayout.setVisibility(View.VISIBLE);
        }

        switchTitleBar(!isFullscreen);
    }

    private void switchTitleBar(boolean show) {
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (show) {
                supportActionBar.show();
            } else {
                supportActionBar.hide();
            }
        }
    }


//    @Override
//    public void onReStart(boolean isOnReStart) {
//        Log.d(TAG, "onReStart---000-->" + isOnReStart);
//    }

    @Override
    public void onPause(MediaPlayer mediaPlayer) {
        gone(mediaPlayer.isPlaying());
        Log.d(TAG, "onPause UniversalVideoView callback---1111-->" + mediaPlayer.isPlaying());
    }

    @Override
    public void onStart(MediaPlayer mediaPlayer) {
        Log.d(TAG, "onStart UniversalVideoView callback--2222--->");
        Log.d(TAG, "onStart UniversalVideoView callback---2222-->" + mediaPlayer.isPlaying());
        Log.d(TAG, "onStart UniversalVideoView callback--2222--->" + mediaPlayer.getCurrentPosition());
        Log.d(TAG, "onStart UniversalVideoView mMediaController--2222--->" + mMediaController.getContentDescription());
        gone(mediaPlayer.isPlaying());

    }

    @Override
    public void onBufferingStart(MediaPlayer mediaPlayer) {
        Log.d(TAG, "onBufferingStart UniversalVideoView callback--3333--->");

        gone(mediaPlayer.isPlaying());
        Log.d(TAG, "onBufferingStart UniversalVideoView callback==3333===>" + mediaPlayer.isPlaying());
    }

    private void gone(boolean b) {
        if (b) {
            img_text.setVisibility(View.GONE);
//            gif_view.setVisibility(View.GONE);
        }
    }

    private void show() {
        img_text.setVisibility(View.VISIBLE);

    }

    private void setImg(boolean b) {
        if (b) {
            img_text.setImageResource(R.mipmap.coursepic);
        } else {
//            img_text.setImageResource(R.mipmap.loading);
//            gif_view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBufferingEnd(MediaPlayer mediaPlayer) {
        Log.d(TAG, "onBufferingEnd UniversalVideoView callback---44444-->" + mediaPlayer.isPlaying());
    }
//    ViewGroup loadingLayout;
//    @Override
//    public void onOpen(ViewGroup loadingLayout) {
//        this.loadingLayout =loadingLayout;
////        loadingLayout.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void onClose(ViewGroup loadingLayout) {
//        loadingLayout.setVisibility(View.GONE);
//    }


    @Override
    public void onBackPressed() {
        if (this.isFullscreen) {
            mVideoView.setFullscreen(false);
        } else {
            super.onBackPressed();
        }
    }

}

