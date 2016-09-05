package pf.pf.ui.mainUI;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pf.pf.R;


public class ThreeFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.e("wzk", "ThreeFragment onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e("wzk", "ThreeFragment onCreateView");
		return inflater.inflate(R.layout.three, container, false);
	}

	@Override
	public void onPause() {
		Log.e("wzk", "ThreeFragment  onPause");
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onResume() {
		Log.e("wzk", "ThreeFragment  onResume");
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onDestroy() {
		Log.e("wzk", "ThreeFragment  onDestroy");
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		Log.e("wzk", "ThreeFragment  onDestroyView");
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void onStop() {
		Log.e("wzk", "ThreeFragment  onStop");
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	public void onStart() {
		Log.e("wzk", "ThreeFragment  onStart");
		// TODO Auto-generated method stub
		super.onStart();
	}

}
