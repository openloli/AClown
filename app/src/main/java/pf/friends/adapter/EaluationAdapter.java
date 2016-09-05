package pf.friends.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pf.friends.activity.LookBigPicActivity;
import pf.friends.bean.EaluationListBean;
import pf.friends.bean.EvaluatereplysBean;
import pf.friends.utils.CommonUtils;
import pf.friends.view.CircularImage;
import pf.friends.view.CustomGridView;
import pf.pf.R;
import pf.pf.ui.mainUI.TwoFragment;


/**
 * Created by mabeijianxi on 2016/1/3.
 */
public class EaluationAdapter extends RecyclerView.Adapter<EaluationAdapter.EaluationHolder> {
    /**
     * 当高分辨率的时候服务器的图片显得太小，这里优化下显示比例
     */
    private Float fTimes;
//    private Context mContext;
    private boolean mIsLoadImage = true;
    private ArrayList<EaluationListBean> mEaluationList;
    private EaluationGvPicAdaper mEaluationGvPicAdaper;
    private ImageLoader mImageLoader = ImageLoader.getInstance();
    private DisplayImageOptions mConfig = new DisplayImageOptions.Builder()
            .showImageForEmptyUri(R.drawable.home_youpin)
            .showImageOnFail(R.drawable.home_youpin)
            .cacheInMemory(true)// 在内存中会缓存该图片
            .cacheOnDisk(true)// 在硬盘中会缓存该图片
            .considerExifParams(true)// 会识别图片的方向信息
            .resetViewBeforeLoading(true)// 重设图片
            .build();


    public ArrayList<EaluationListBean> getmEaluationList() {
        return mEaluationList;
    }

    /**
     * 是否加载图片
     *
     * @param isLoadImage
     */
    public void setLoadImage(boolean isLoadImage) {
        this.mIsLoadImage = isLoadImage;
    }
    TwoFragment mContext;

    public EaluationAdapter(TwoFragment context) {
//        this.mContext = context;
        mContext = (TwoFragment)context;
        mEaluationList = new ArrayList<>();
//        适配单图放大比例
        String sTimes = mContext.getResources().getString(R.string.times);
        fTimes = Float.valueOf(sTimes);
    }

    public void clearAdapterNotifyData() {
        mEaluationList.clear();
        notifyDataSetChanged();
    }

    public void clearAdapter() {
        mEaluationList.clear();
    }

    public void addEaluationDataAllNotifyData(ArrayList<EaluationListBean> data) {
        if (data != null) {
            mEaluationList.addAll(data);
            notifyDataSetChanged();
        }

    }

    public void addEaluationDataAll(ArrayList<EaluationListBean> data) {
        if (data != null) {
            mEaluationList.addAll(data);
        }

    }

    public void addEaluationData(EaluationListBean data) {
        if (data != null) {
            mEaluationList.add(data);
            notifyDataSetChanged();
        }

    }

    @Override
    public int getItemCount() {
        return mEaluationList.size();
    }

    @Override
    public EaluationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext.getContext()).inflate(R.layout.item_comments, parent, false);
        return new EaluationHolder(view);
    }

    @Override
    public void onBindViewHolder(EaluationHolder holder, int position) {
        EaluationListBean ealuationListBean = mEaluationList.get(position);
        List<EaluationListBean.EaluationPicBean> attachments = ealuationListBean.attachments;
        if (ealuationListBean.avatar != null) {
            mImageLoader.displayImage(ealuationListBean.avatar.smallPicUrl, holder.icon, mConfig);
            setIconClick(holder, holder.icon, ealuationListBean.avatar.smallPicUrl, ealuationListBean.avatar.picUrl);
        } else {
            holder.icon.setImageResource(R.drawable.home_youpin);
            setIconClick(holder, holder.icon, "null", "null");
        }
        holder.tv_nickname.setText(ealuationListBean.userName);
        //这几行代码完全是为了假数据好看
        if(ealuationListBean.content.length()==2){
            holder.tv_text.setText("我嫂子要了二胎，全家都心疼！只要小家伙一哭，全家人立马抢着抱在怀里，然后拿个奶嘴让他含着。这一招被侄女学会了，只要我哥睡觉打呼噜，侄女都会拿个奶嘴放我哥嘴里！别说还真见效。。。");
        }else if(ealuationListBean.content.length()==7){
            holder.tv_text.setText("昨天跟一朋友在大排档喝酒，朋友喝多了，买单时抓住老板娘的手不松，好劝歹劝半小时，旁边的老板真诚的说：“兄弟，她可以让给你，但是不能后悔！老板也是有故事的人啊！" );
        }else if(ealuationListBean.content.length()==4){
            holder.tv_text.setText("男友第一次去我家吃饭，因为我晚点所以让他先去。老爸喜欢喝酒，我到家时，他们俩已经喝好一会儿了。我故意说：“老爸，这帅哥是谁啊？”老爸说：“不是你对象吗？”我说：“不是啊，他还没回来呢！”结果老爸高兴地说：“这小伙子不错，把你对象甩了跟他好吧！");
        }else{
            holder.tv_text.setText(ealuationListBean.content);
        }
//去掉上面时展开这里
//        holder.tv_text.setText(ealuationListBean.content);
        holder.tv_date.setText(ealuationListBean.creatTime);
//        holder.rb_stars.setRating(ealuationListBean.grade);
        setUpImage(holder, attachments, position);
        setUpTereplys(holder, ealuationListBean.evaluatereplys);
    }

    /**
     * 设置回复内容规则
     *这里用的是自定义的LinearLayout，这样比listview消耗要小一些
     * @param holder
     * @param evaluatereplysList
     */
    private void setUpTereplys(EaluationHolder holder, List<EvaluatereplysBean> evaluatereplysList) {
//        if (evaluatereplysList != null && evaluatereplysList.size() > 0) {
//            holder.lv_comments_details.setVisibility(View.VISIBLE);
//            EvaluatereplysAdapter evaluatereplysAdapter = new EvaluatereplysAdapter(mContext, evaluatereplysList);
//            holder.lv_comments_details.setAdapter(evaluatereplysAdapter);
//        } else {
//            holder.lv_comments_details.setVisibility(View.GONE);
//        }
    }

    /**
     * 设置图片显示规则
     *
     * @param holder
     * @param attachments
     * @param position
     */
    private void setUpImage(EaluationHolder holder, List<EaluationListBean.EaluationPicBean> attachments, int position) {
        holder.fl_image.setVisibility(View.GONE);
        if (attachments != null) {
            if (attachments.size() == 0) {
                holder.fl_image.setVisibility(View.GONE);
            } else if (attachments.size() == 1) {
//                setSingleImage(attachments, holder, position);
//  我添加的开始
                holder.gv_image.setVisibility(View.GONE);
                holder.iv_image.setVisibility(View.VISIBLE);
                holder.fl_image.setVisibility(View.VISIBLE);
//
//
//
//                if (mIsLoadImage) {
//                    holder.gv_image.setVisibility(View.GONE);
//                    mImageLoader.displayImage(attachments.get(0).imageUrl, holder.iv_image, mConfig);
//                } else {
//                    Bitmap bitmap = ImageUtils.getBitmapFromCache(attachments.get(0).imageUrl, mImageLoader);
//                    if (bitmap != null) {
//                        holder.iv_image.setImageBitmap(bitmap);
//                    }
//                }


//                if (attachments.get(0).imageUrl != null||) {
                    mImageLoader.displayImage(attachments.get(0).smallImageUrl, holder.iv_image, mConfig);
                    setIconClick(holder, holder.iv_image, attachments.get(0).smallImageUrl, attachments.get(0).imageUrl);
//                } else {
//                    holder.iv_image.setImageResource(R.drawable.home_youpin);
//                    setIconClick(holder, "null", "null");
//                }


                //  我添加的 结束
                //
            } else {
                holder.iv_image.setVisibility(View.GONE);
                holder.gv_image.setVisibility(View.VISIBLE);
                holder.fl_image.setVisibility(View.VISIBLE);
                setManyImage(attachments, holder, position);
            }
        } else {
            holder.fl_image.setVisibility(View.GONE);
        }
    }

    /**
     * 设置头像的点击看大图事件，这里为了方便直接把bean类进行了转换传递
     * @param holder
     * @param miniPicUrl
     * @param picUrl
     */
    private void setIconClick(final EaluationHolder holder,final ImageView imageView, final String miniPicUrl, final String picUrl) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext.getContext(), LookBigPicActivity.class);
                Bundle bundle = new Bundle();
                List<EaluationListBean.EaluationPicBean> attachments = new ArrayList<EaluationListBean.EaluationPicBean>();
                EaluationListBean.EaluationPicBean ealuationPicBean = new EaluationListBean().new EaluationPicBean();

                int height = imageView.getHeight();
                int width = imageView.getWidth();
                int[] points=new int[2];
                imageView.getLocationInWindow(points);
                ealuationPicBean.height=height;
                ealuationPicBean.width=width;
                ealuationPicBean.x=points[0];
                ealuationPicBean.y=points[1]- CommonUtils.getStatusBarHeight(imageView);
                ealuationPicBean.imageUrl = picUrl;
                ealuationPicBean.smallImageUrl = miniPicUrl;
                attachments.add(ealuationPicBean);

                bundle.putSerializable(LookBigPicActivity.PICDATALIST, (Serializable) attachments);
                intent.putExtras(bundle);
                intent.putExtra(LookBigPicActivity.CURRENTITEM, 0);
                mContext.startActivity(intent);
//                动画处理
                startActivityAnim();
            }
        });
    }

    /**
     * 设置多图
     *
     * @param attachments
     * @param holder
     * @param position
     */
    private void setManyImage(List<EaluationListBean.EaluationPicBean> attachments, EaluationHolder holder, int position) {
//         mEaluationGvPicAdaper = (EaluationGvPicAdaper) holder.gv_image.getTag(position);
//        if(mEaluationGvPicAdaper==null){

//        mIsLoadImage
        EaluationGvPicAdaper mEaluationGvPicAdaper = new EaluationGvPicAdaper(mContext, attachments, mIsLoadImage);
//            holder.gv_image.setTag(position,mEaluationGvPicAdaper);
        holder.gv_image.setAdapter(mEaluationGvPicAdaper);
//        }
    }

    /**
     * 设置单图
     *
     * @param attachments
     * @param holder
     */
    private void setSingleImage(final List<EaluationListBean.EaluationPicBean> attachments, final EaluationHolder holder, final int position) {

//可更具请求选择是否设置是否对单图快滑处理
//        if (mIsLoadImage) {
        mImageLoader.displayImage(attachments.get(0).smallImageUrl, holder.iv_image, mConfig, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                优化显示比例
                if (fTimes != 1) {
                    int height = loadedImage.getHeight();
                    int width = loadedImage.getWidth();
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) (width * fTimes), (int) (height * fTimes));
                    holder.iv_image.setLayoutParams(params);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
        holder.iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                            点击查看大图的操作
                Intent intent = new Intent(mContext.getContext(), LookBigPicActivity.class);
                Bundle bundle = new Bundle();
                int height = holder.iv_image.getHeight();
                int width = holder.iv_image.getWidth();
                int[] points=new int[2];
                holder.iv_image.getLocationInWindow(points);
                attachments.get(0).height=height;
                attachments.get(0).width=width;
                attachments.get(0).x=points[0];
                attachments.get(0).y=points[1]- CommonUtils.getStatusBarHeight(holder.iv_image);
                bundle.putSerializable(LookBigPicActivity.PICDATALIST, (Serializable) attachments);
                intent.putExtras(bundle);
                intent.putExtra(LookBigPicActivity.CURRENTITEM, 0);
                mContext.startActivity(intent);
                startActivityAnim();

            }
        });
//        }
//        优化快滑时的图片加载
       /* else {
            Bitmap bitmap = mImageLoader.getMemoryCache().get(attachments.get(0).smallImageUrl);
            if (bitmap != null) {
                holder.iv_image.setImageBitmap(bitmap);
            }
        }*/
    }

    /**
     * 开始跳转动画
     *
     */
    private void startActivityAnim() {
        ( mContext.getActivity()).overridePendingTransition(0, 0);
    }

    static class EaluationHolder extends RecyclerView.ViewHolder {
        public CircularImage icon;
        public ImageView iv_image;
        public TextView tv_nickname;
        public TextView tv_text;
        //        可更具情况设置为emoji表情
        public TextView tv_date;
//        public RatingBar rb_stars;
        public CustomGridView gv_image;
//        public LinearListView lv_comments_details;
        public FrameLayout fl_image;

        public EaluationHolder(View itemView) {
            super(itemView);
            icon = (CircularImage) itemView.findViewById(R.id.icon);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
            tv_nickname = (TextView) itemView.findViewById(R.id.tv_nickname);
            tv_text = (TextView) itemView.findViewById(R.id.tv_text);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
//            rb_stars = (RatingBar) itemView.findViewById(R.id.rb_stars);
            gv_image = (CustomGridView) itemView.findViewById(R.id.gv_image);
//            lv_comments_details = (LinearListView) itemView.findViewById(R.id.lv_comments_details);
            fl_image = (FrameLayout) itemView.findViewById(R.id.fl_image);

        }
    }

}
