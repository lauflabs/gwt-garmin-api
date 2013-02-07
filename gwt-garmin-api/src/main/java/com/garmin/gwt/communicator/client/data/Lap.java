package com.garmin.gwt.communicator.client.data;

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

/**
 * Fitness lap information POJO
 * 
 * @author Joseph Lust
 * 
 */
public final class Lap {

	private String id;
	private Date startTime;

	// NOTE: double, rather than XSD specifics since JS only uses 64bit doubles internally
	private double totalTimeSeconds;
	private double distanceMeters;
	private double maximumSpeed;
	private double calories;
	private double averageHeartRateBpm;
	private double maximumHeartRateBpm;
	private String notes;

	//private ArrayList<Track> tracks;

}
