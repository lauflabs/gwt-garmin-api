package com.garmin.gwt.client.base;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * General handler for callbacks to the device
 * 
 * @author Joseph Lust
 * 
 */
public interface DeviceAsyncCallback<T> extends AsyncCallback<T> {

	/**
	 * Called when the event was cancelled
	 */
	void onCancel();

	/**
	 * called every 500ms while running
	 */
	ProgressDetail onProgress();
}
