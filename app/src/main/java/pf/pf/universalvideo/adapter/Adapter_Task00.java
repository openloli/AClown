package pf.pf.universalvideo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import pf.pf.R;
import pf.pf.universalvideo.VideoMain;
import pf.pf.universalvideo.bean.User;

/**
 * Created by AXTing on 2016/4/17.
 */
public class Adapter_Task00 extends RecyclerView.Adapter<Adapter_Task00.ViewHolder> {

    private List<User> applications;
    private int rowLayout;
    private VideoMain mAct;

    public Adapter_Task00(List<User> applications, int rowLayout, VideoMain act) {
        this.applications = applications;
        this.rowLayout = rowLayout;
        this.mAct = act;
    }


    public void clearApplications() {
        int size = this.applications.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                applications.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }

    public void addApplications(List<User> applications) {
        this.applications.addAll(applications);
        this.notifyItemRangeInserted(0, applications.size() - 1);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final User user = applications.get(i);
        viewHolder.task_name.setText(user.getName());
//
//        Typeface typeface = Typeface.create("宋体", Typeface.NORMAL);//后面一个是粗体参数.
//        viewHolder.task_des.setTypeface(typeface);//来设置
        viewHolder.llyout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAct.onItemClick(user, v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return applications == null ? 0 : applications.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView task_name;
        public  LinearLayout llyout_item;
        public ViewHolder(View itemView) {
            super(itemView);
            task_name = (TextView) itemView.findViewById(R.id.tv);
            llyout_item = (LinearLayout) itemView.findViewById(R.id.llyout_item);


        }

    }
}
