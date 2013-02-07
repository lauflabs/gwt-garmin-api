package com.garmin.gwt.communicator.client.base;

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

import com.garmin.gwt.communicator.client.request.FitnessDataPluginRequest;
import com.garmin.gwt.communicator.client.request.GpsDataPluginRequest;

/**
 * Types returned from various requests.
 * 
 * @see {@link GpsDataPluginRequest}
 * @see {@link FitnessDataPluginRequest}
 * 
 * @author Joseph Lust
 *
 */
public enum FinishStatusType {
	IDLE,
	WORKING,
	WAITING,
	FINISHED;


	/**
	 * Get enum from ordinal int
	 * @param ordinal
	 * @return FinishStatusType
	 */
	public static final FinishStatusType fromOrdinal(int ordinal) {
		return values()[ordinal];
	}
}
