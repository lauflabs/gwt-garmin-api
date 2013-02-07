package com.garmin.gwt.communicator.client.util;

import com.garmin.gwt.communicator.client.base.Device;
import com.google.gwt.regexp.shared.RegExp;

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

/**
 * Device utilities
 * 
 * @author Joseph Lust
 * 
 */
public final class DeviceUtils {

	private static final RegExp NAME_EDGE= RegExp.compile("edge","i");
	private static final RegExp NAME_NUVI = RegExp.compile("n[uü]vi","i");
	private static final RegExp NAME_FORERUNNER = RegExp.compile("forerunner","i");

	/**
	 * Is this a Nüvi device?
	 * @param device
	 * @return true if Nüvi
	 */
	public static final boolean isNuvi(Device device) {
		return NAME_NUVI.test(device.getDisplayName());
	}

	/**
	 * Is this an Edge device?
	 * @param device
	 * @return true if Edge
	 */
	public static final boolean isEdge(Device device) {
		return NAME_EDGE.test(device.getDisplayName());
	}

	/**
	 * Is this a Forerunner device?
	 * @param device
	 * @return true if Forerunner
	 */
	public static final boolean isForerunner(Device device) {
		return NAME_FORERUNNER.test(device.getDisplayName());
	}

}
