package pf.pf.switchfragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

import pf.pf.R;


public class MainActivity extends FragmentActivity implements OnClickListener {

	ViewPager mViewPager;
	List<Fragment> fragmentList;
	private TextView tv_01, tv_02, tv_03, tv_04;
	private FragmentPagerAdapter mAdapter;
	int h = 0xff999999;// 0xff23fc4f
	int b = 0xffffffff;// 红色


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.act_learning);
		initView();
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return fragmentList.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return fragmentList.get(arg0);
			}
		};

		mViewPager.setAdapter(mAdapter);
		mViewPager.setPageTransformer(true, new DepthPageTransformer());

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			private int currentIndex;

			@Override
			public void onPageSelected(int position) {
				switch (position) {
					case 0:
						setTextColor(tv_01);
						break;
					case 1:
						setTextColor(tv_02);
						break;
					case 2:
						setTextColor(tv_03);
						break;
					case 3:
						setTextColor(tv_04);
						break;
				}
				currentIndex = position;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		setTextColor(tv_01);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.tv_01:
				changeView(0);
				setTextColor(tv_01);
				break;
			case R.id.tv_02:
				changeView(1);
				setTextColor(tv_02);
				break;
			case R.id.tv_03:
				changeView(2);
				setTextColor(tv_03);
				break;
			case R.id.tv_04:
				changeView(3);
				setTextColor(tv_04);
				break;
			default:
				break;
		}
	}

	private void setTextColor(TextView v) {
		tv_01.setTextColor(h);
		tv_02.setTextColor(h);
		tv_03.setTextColor(h);
		tv_04.setTextColor(h);
		v.setTextColor(b);

	}

	// 手动设置ViewPager要显示的视图
	private void changeView(int desTab) {
		mViewPager.setCurrentItem(desTab, true);
	}

	private void initView() {
		tv_01 = (TextView) findViewById(R.id.tv_01);
		tv_02 = (TextView) findViewById(R.id.tv_02);
		tv_03 = (TextView) findViewById(R.id.tv_03);
		tv_04 = (TextView) findViewById(R.id.tv_04);

		tv_01.setOnClickListener(this);
		tv_02.setOnClickListener(this);
		tv_03.setOnClickListener(this);
		tv_04.setOnClickListener(this);

		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		fragmentList = new ArrayList<Fragment>();
		OneFragment oneFragment = new OneFragment();
		TwoFragment twoFragment = new TwoFragment();
		ThreeFragment threeFragment = new ThreeFragment();
		Pager04 fourFragment = new Pager04();

		fragmentList.add(oneFragment);
		fragmentList.add(twoFragment);
		fragmentList.add(threeFragment);
		fragmentList.add(fourFragment);
	}


}
