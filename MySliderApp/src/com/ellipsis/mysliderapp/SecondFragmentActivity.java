package com.ellipsis.mysliderapp;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragmentActivity extends SherlockFragment {

	private int mContent;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View firstView;
		if (savedInstanceState != null) {
			mContent = savedInstanceState.getInt("mContent");
			firstView = (View) getView().findViewById(mContent);
		} else {
			firstView = inflater.inflate(R.layout.activity_second_fragment,
					container, false);
		}
		return firstView;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("mContent", mContent);
	}

}
