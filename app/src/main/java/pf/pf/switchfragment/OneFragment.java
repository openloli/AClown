package pf.pf.switchfragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.Arrays;
import java.util.List;

import pf.pf.R;
import pf.pf.ui.adapter.AdapterMain;

public class OneFragment extends Fragment {
	private FragmentActivity mActivity;
	private XRecyclerView mXRView;
	private AdapterMain mAdapter;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.one, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		 mActivity = getActivity();
		initView();
	}

	private void initView() {
		mXRView = (XRecyclerView) mActivity.findViewById(R.id.xrv_main);
		LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		mXRView.setLayoutManager(layoutManager);

		mXRView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
		mXRView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
		mXRView.setArrowImageView(R.mipmap.iconfont_downgrey);

		mXRView.setLoadingListener(new XRecyclerView.LoadingListener() {
			@Override
			public void onRefresh() {
				toRefresh();
			}

			@Override
			public void onLoadMore() {
				toLoadMore();
			}
		});
		mXRView.setRefreshing(true);
	}

	private void toLoadMore() {
		toHandler();
	}

	private void toHandler(final int start, final int end) {
		new Handler().postDelayed(new Runnable() {
			public void run() {
				for (int i = start; i < end; i++) {
//                    listData.add(allgist.get(i));
				}
				mAdapter.notifyDataSetChanged();
				mXRView.loadMoreComplete();
			}
		}, 1000);
	}

	private void toHandler() {
		new Handler().postDelayed(new Runnable() {
			public void run() {
				mAdapter.notifyDataSetChanged();
				mXRView.loadMoreComplete();
			}
		}, 1000);
	}

	private void toRefresh() {
		useData();
	}

	private void useData() {
		String[] sData = getResources().getStringArray(R.array.main);
		List<String> mData = Arrays.asList(sData);
		mAdapter = new AdapterMain(mData, OneFragment.this);
		mXRView.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
		mXRView.refreshComplete();
	}


	public void onClickItem(String str) {
//		switch (str.substring(1, 2)) {
//			case "1":
//				intent = new Intent(MainActivity.this, FirstActivity.class);
//				break;
//			case "2":
//				intent = new Intent(MainActivity.this, ShowRx.class);
//				break;
//			case "3":
//				intent = new Intent(MainActivity.this, ShowLine.class);
//				break;
//			case "4":
//				intent = new Intent(MainActivity.this, ShowFMFrame.class);
//				break;
//			case "5":
//				intent = new Intent(MainActivity.this, ShowFriends.class);
//				break;
//			case "6":
//				intent = new Intent(MainActivity.this, NoteActivity.class);
//				break;
//		}
//		startActivity(intent);
	}
}
