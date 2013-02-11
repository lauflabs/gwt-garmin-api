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


import java.util.Date;

import com.garmin.gwt.communicator.client.base.Device;
import com.garmin.gwt.communicator.client.base.FinishStatusType;
import com.garmin.gwt.communicator.client.gpx.Gpx;
import com.garmin.gwt.communicator.client.gpx.GpxParserFactory;
import com.garmin.gwt.communicator.client.plugin.DevicePlugin;
import com.google.gwt.core.shared.GWT;


/**
 * Fetch the GPS data from the device<br>
 * <b>NOTE:</b> Once created, the request will start.
 * 
 * @author Joseph Lust
 * 
 */
public final class GpxDataPluginRequest extends AbstractPluginRequest<Gpx> {

	GpxParserFactory parserFactory = GWT.create(GpxParserFactory.class);

	Device targetDevice;

	/**
	 * Fetch GPS data from the Communicator Plugin.<br>
	 * <b>Note:</b> Depending on how much data is on the user device, it may
	 * take a while to download it all.
	 * 
	 * @param plugin DevicePlugin instance in use
	 * @param targetDevice from {@links DevicePlugin}
	 * @param callback
	 */
	public GpxDataPluginRequest(DevicePlugin plugin, Device targetDevice, RequestCallback<Gpx> callback) {
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
		getPlugin().startReadFromGps(targetDevice);
		getTimer().scheduleRepeating(POLLING_INTERVAL_MS);
	}

	@Override
	protected boolean finishRequest() {
		FinishStatusType status = getPlugin().finishReadFromGps();
		return FinishStatusType.FINISHED.equals(status);
	}

	@Override
	public void cancelRequest() {
		if(isRunning()) {
			getPlugin().cancelReadFromGps();
			getTimer().cancel();
		}
	}

	@Override
	protected Gpx getRequestResult() {
		setRunning(false);
		String xml = getPlugin().getGpsXml();

		// parsing could take a while, instrument
		// run if in DevMode only, otherwise skipped
		if(GWT.isClient()) {
			long startTime = (new Date()).getTime();
			GWT.log("Starting Gpx XML parse...");

			Gpx gpxObj = parserFactory.create().parse(xml);

			long duration = (new Date()).getTime()-startTime;
			GWT.log("Completed Gpx XML parse in: "+duration+"ms");

			return gpxObj;
		}
		else {
			return parserFactory.create().parse(xml);
		}
	}
}
