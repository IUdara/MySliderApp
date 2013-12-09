package com.ellipsis.mysliderapp;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

public class MobiID {

	// public static boolean isTablet(Context activityContext) {
	// // Verifies if the Generalized Size of the device is XLARGE to be
	// // considered a Tablet
	// boolean xlarge =
	// ((activityContext.getResources().getConfiguration().screenLayout &
	// Configuration.SCREENLAYOUT_SIZE_MASK) ==
	// Configuration.SCREENLAYOUT_SIZE_XLARGE);
	//
	// // If XLarge, checks if the Generalized Density is at least MDPI
	// // (160dpi)
	// if (xlarge) {
	// DisplayMetrics metrics = new DisplayMetrics();
	// Activity activity = (Activity) activityContext;
	// activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
	//
	// // MDPI=160, DEFAULT=160, DENSITY_HIGH=240, DENSITY_MEDIUM=160,
	// // DENSITY_TV=213, DENSITY_XHIGH=320
	// if (metrics.densityDpi == DisplayMetrics.DENSITY_DEFAULT
	// || metrics.densityDpi == DisplayMetrics.DENSITY_HIGH
	// || metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM
	// || metrics.densityDpi == DisplayMetrics.DENSITY_TV
	// || metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH) {
	//
	// // Yes, this is a tablet!
	// return true;
	// }
	// }
	// // No, this is not a tablet!
	// return false;
	// }

	private static final String TAG_LOG = "MobiID";

	public static boolean isTablet(Context activityContext) {
		try {

			// Compute screen size
			DisplayMetrics dm = activityContext.getResources()
					.getDisplayMetrics();
			float screenWidth = dm.widthPixels / dm.xdpi;
			float screenHeight = dm.heightPixels / dm.ydpi;
			double size = Math.sqrt(Math.pow(screenWidth, 2)
					+ Math.pow(screenHeight, 2));

			// Tablet devices should have a screen size greater than 6 inches
			return size >= 6;
		} catch (Throwable t) {
			Log.v(TAG_LOG, "Failed to compute screen size", t);
			return false;
		}
	}

	public static int getWidth(Context activityContext) {
		try {

			// Compute screen size
			DisplayMetrics dm = activityContext.getResources()
					.getDisplayMetrics();

			// Tablet devices should have a screen size greater than 6 inches
			return (int) dm.widthPixels;
		} catch (Throwable t) {
			Log.v(TAG_LOG, "Failed to get screen width", t);
			return 0;
		}
	}

}
