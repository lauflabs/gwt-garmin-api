package com.garmin.gwt.communicator.client.request;

/*
 * #%L
 * GWT Garmin API - Core API
 * %%
 * Copyright (C) 2012 - 2013 GWT Garmin API
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.garmin.gwt.communicator.client.plugin.DevicePlugin;
import com.google.gwt.user.client.Timer;

/**
 * Generic plugin request lifecylce handler
 * 
 * @author Joseph Lust
 * 
 */
public abstract class AbstractPluginRequest<T> {

	private DevicePlugin plugin;

	private boolean isRunning;

	public final static int POLLING_INTERVAL_MS = 200;

	private RequestCallback<T> callback;

	private final Timer timer = new Timer() {

		@Override
		public void run() {

			if (finishRequest()) {
				this.cancel();
				plugin.getDevices();
				callback.onSuccess(getRequestResult());
			}
		}
	};

	/**
	 * Get timer used to poll for finish
	 * 
	 * @return timer object in use
	 */
	public final Timer getTimer() {
		return timer;
	}

	/**
	 * Set callback used on success or failure
	 * 
	 * @param callback
	 */
	protected final void setCallback(RequestCallback<T> callback) {
		this.callback = callback;
	}

	/**
	 * Set the plugin for the request
	 * 
	 * @param plugin
	 */
	protected final void setPlugin(DevicePlugin plugin) {
		this.plugin = plugin;
	}

	/**
	 * Get plugin instance in use
	 * 
	 * @return plugin
	 */
	protected final DevicePlugin getPlugin() {
		return plugin;
	}

	protected abstract void startRequest();

	public abstract void cancelRequest();

	protected abstract T getRequestResult();

	protected abstract boolean finishRequest();

	/**
	 * @return the isRunning
	 */
	protected final boolean isRunning() {
		return isRunning;
	}

	/**
	 * @param isRunning the isRunning to set
	 */
	protected final void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}


}
