package pf.pf.ui.mainUI;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pf.pf.R;


public class Pager04 extends Fragment {
//	private SimpleDraweeView draweeView;
	private FragmentActivity mActivity;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.e("wzk", "FourFragment onCreateView");
		return inflater.inflate(R.layout.four, container, false);
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mActivity = getActivity();
		initView();
	}
	private void initView() {
//		draweeView = (SimpleDraweeView) mActivity.findViewById(R.id.my_image_view);
//		draweeView.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Uri uri = Uri.parse(new API().apis[new Random().nextInt(new API().apis.length)]);//随机一个url
//				draweeView.setImageURI(uri);
//			}
//		});
	}
}
