package com.garmin.gwt.communicator.client.base;

/*
 * #%L
 * GWT Maps API V3 - Core API
 * %%
 * Copyright (C) 2011 - 2012 GWT Maps API V3
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
 * A point on a two-dimensional plane. <br>
 */
public class LatLng {
	
	/**
	 * @param latitude
	 * @param longitude
	 */
	public LatLng(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	private double latitude;
	private double longitude;
	
	/**
	 * @return the latitude
	 */
	public final double getLatitude() {
		return latitude;
	}
	/**
	 * @return the longitude
	 */
	public final double getLongitude() {
		return longitude;
	}	
}
