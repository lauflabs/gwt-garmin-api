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

import com.garmin.gwt.communicator.client.base.Device;
import com.garmin.gwt.communicator.client.base.FinishStatusType;
import com.garmin.gwt.communicator.client.plugin.DevicePlugin;

/**
 * Fetch the fitness data from the device<br>
 * <b>NOTE:</b> Once created, the request will start.
 * 
 * @author Joseph Lust
 * 
 */
public final class FitnessDataPluginRequest extends
AbstractPluginRequest<String> {

	Device targetDevice;
	String fitnessDataType;

	/**
	 * Fetch fitness data from the Communicator Plugin.<br>
	 * <b>Note:</b> Depending on how much data is on the user device, it may
	 * take a while to download it all.
	 * 
	 * @param plugin DevicePlugin instance in use
	 * @param targetDevice from {@link DevicePlugin}
	 * @param fitnessDataType
	 * @param callback
	 */
	public FitnessDataPluginRequest(DevicePlugin plugin, Device targetDevice,
			String fitnessDataType, RequestCallback<String> callback) {
		super();
		this.targetDevice = targetDevice;
		setPlugin(plugin);
		setCallback(callback);
		startRequest(); // DON'T override...
	}

	@Override
	protected void startRequest() {
		setRunning(true);
		// TODO: catch error if user has since removed this device?
		getPlugin().startReadFitnessData(targetDevice, fitnessDataType);
		getTimer().scheduleRepeating(POLLING_INTERVAL_MS);
	}

	@Override
	protected boolean finishRequest() {
		FinishStatusType status = getPlugin().finishReadFitnessData();
		return FinishStatusType.FINISHED.equals(status);
	}

	@Override
	public void cancelRequest() {
		if (isRunning()) {
			getPlugin().cancelReadFromGps();
			getTimer().cancel();
		}
	}

	@Override
	protected String getRequestResult() {
		setRunning(false);
		return getPlugin().getTcdXml();
	}
}
