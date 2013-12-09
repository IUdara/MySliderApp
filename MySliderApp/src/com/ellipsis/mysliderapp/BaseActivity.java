package com.ellipsis.mysliderapp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.KeyEvent;

import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class BaseActivity extends SlidingFragmentActivity {

	private int mTitleRes;
	protected ListFragment mFrag;

	public BaseActivity(int titleRes) {
		mTitleRes = titleRes;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle(mTitleRes);

		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager()
					.beginTransaction();
			mFrag = new MenuListFragment();
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else {
			mFrag = (ListFragment) this.getSupportFragmentManager()
					.findFragmentById(R.id.menu_frame);
		}

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();

		if (MobiID.isTablet(getBaseContext())) {
			sm.setShadowWidthRes(R.dimen.shadow_width_tab);
			sm.setShadowDrawable(R.drawable.shadow);
			sm.setBehindOffset(MobiID.getWidth(getBaseContext()) * 5 / 6);
			sm.setFadeDegree(0.05f);
			sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
			sm.setSlidingEnabled(false);
			getSupportActionBar().setDisplayHomeAsUpEnabled(false);
			setSlidingActionBarEnabled(false);

		} else {
			sm.setShadowWidthRes(R.dimen.shadow_width);
			sm.setShadowDrawable(R.drawable.shadow);
			sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
			sm.setFadeDegree(0.35f);
			sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
			sm.setSlidingEnabled(true);

			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			getSupportActionBar().setIcon(
					R.drawable.abs__ic_menu_moreoverflow_normal_holo_dark);
			getSupportActionBar().setDisplayShowTitleEnabled(false);
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		if (savedInstanceState == null && MobiID.isTablet(getBaseContext())) {
			savedInstanceState = new Bundle();
			savedInstanceState.putBoolean("SlidingActivityHelper.open", true);
		}
		super.onPostCreate(savedInstanceState);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK && MobiID
				.isTablet(getBaseContext()))) {
			finish();
			return false;
		} else {
			return super.onKeyUp(keyCode, event);
		}
	}
}
