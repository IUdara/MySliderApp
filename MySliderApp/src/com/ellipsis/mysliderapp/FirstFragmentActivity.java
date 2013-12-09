package com.ellipsis.mysliderapp;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FirstFragmentActivity extends SherlockFragment {

	private int mContent;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View firstView;
		if (savedInstanceState != null) {
			mContent = savedInstanceState.getInt("mContent");
			firstView = (View) getView().findViewById(mContent);
		} else {
			firstView = inflater.inflate(R.layout.activity_first_fragment,
					container, false);
		}

		return firstView;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("mContent", mContent);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.first, menu);
		super.onCreateOptionsMenu(menu, inflater);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.save:
			Toast.makeText(getActivity(), "Item Saved", Toast.LENGTH_SHORT)
					.show();

			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
