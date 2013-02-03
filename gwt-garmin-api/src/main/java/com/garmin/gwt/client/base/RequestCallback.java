package com.garmin.gwt.client.base;

/**
 * General asynchronous callbacks for a plugin request
 * 
 * @author Joseph Lust
 * 
 * @param <T>
 */
public interface RequestCallback<T> {

	/**
	 * Called on successful completion of the request with the payload
	 * @param result
	 */
	void onSuccess(T result);

	/**
	 * Called if the request is cancelled
	 */
	void onCancel();

	/**
	 * Method will be called every 200ms until cancelled or complete
	 * 
	 * @param progress
	 */
	void onProgress(TransferProgress progress);
}
