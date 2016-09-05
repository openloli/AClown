package pf.friends.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pf.friends.activity.LookBigPicActivity;
import pf.friends.activity.ShowHtml;
import pf.friends.bean.ListsBean;
import pf.pf.R;

/**
 * Created by mabeijianxi on 2016/1/3.
 */
public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.EaluationHolder> {
    /**
     * 当高分辨率的时候服务器的图片显得太小，这里优化下显示比例
     */
    private Float fTimes;
    private Context mContext;
    private boolean mIsLoadImage = true;
    private ArrayList<ListsBean> mEaluationList;


    public ArrayList<ListsBean> getmEaluationList() {
        return mEaluationList;
    }


    public IndexAdapter(Context context) {
        this.mContext = context;
        mEaluationList = new ArrayList<>();
    }

    public void clearAdapterNotifyData() {
        mEaluationList.clear();
        notifyDataSetChanged();
    }

    public void clearAdapter() {
        mEaluationList.clear();
    }

    public void addEaluationDataAllNotifyData(ArrayList<ListsBean> data) {
        if (data != null) {
            mEaluationList.addAll(data);
            notifyDataSetChanged();
        }

    }

    public void addEaluationDataAll(ArrayList<ListsBean> data) {
        if (data != null) {
            mEaluationList.addAll(data);
        }

    }

    public void addEaluationData(ListsBean data) {
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news_index, parent, false);
        return new EaluationHolder(view);
    }

    ListsBean indexBean;
    @Override
    public void onBindViewHolder(EaluationHolder holder, int position) {
          indexBean = mEaluationList.get(position);

        holder.tv_text.setText(indexBean.title);
        holder.tv_date.setText(indexBean.time);
//        setIconClick(holder, holder.llayout, attachments.get(0).smallImageUrl, attachments.get(0).imageUrl);

    }

    private void setIconClick(final EaluationHolder holder,LinearLayout layout) {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LookBigPicActivity.class);

            }
        });
    }
    private void startActivityAnim() {
        ((ShowHtml) mContext).overridePendingTransition(0, 0);
    }

    static class EaluationHolder extends RecyclerView.ViewHolder {
        public TextView tv_text;
        public TextView tv_date;
        public LinearLayout llayout;

        public EaluationHolder(View itemView) {
            super(itemView);

            llayout = (LinearLayout) itemView.findViewById(R.id.llayout);
            tv_text = (TextView) itemView.findViewById(R.id.tv_news_text);
            tv_date = (TextView) itemView.findViewById(R.id.tv_news_time);


        }
    }

}
