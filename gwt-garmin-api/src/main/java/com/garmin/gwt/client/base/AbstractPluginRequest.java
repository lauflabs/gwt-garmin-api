package com.garmin.gwt.client.base;

import com.garmin.gwt.client.DevicePlugin;
import com.google.gwt.user.client.Timer;

/**
 * 
 * @author Joseph Lust
 *
 */
public abstract class AbstractPluginRequest<T> {

	DevicePlugin plugin;

	final static int POLLING_INTERVAL_MS = 200;

	private RequestCallback<T> callback;

	private final Timer timer = new Timer() {

		@Override
		public void run() {

			if(finishRequest()) {
				this.cancel();
				plugin.getDevices();
				callback.onSuccess(getRequestResult());
			}
		}
	};

	/**
	 * Get timer used to poll for finish
	 * @return
	 */
	public final Timer getTimer() {
		return timer;
	}

	/**
	 * Set callback used on success or failure
	 * @param callback
	 */
	public final void setCallback(RequestCallback<T> callback) {
		this.callback = callback;
	}

	/**
	 * Set the plugin for the request
	 * @param plugin
	 */
	public final void setPlugin(DevicePlugin plugin) {
		this.plugin = plugin;
	}

	/**
	 * Get plugin instance in use
	 * @return
	 */
	public final DevicePlugin getPlugin() {
		return plugin;
	}

	public abstract void startRequest();

	public abstract void cancelRequest();

	public abstract T getRequestResult();

	public abstract boolean finishRequest();
}
