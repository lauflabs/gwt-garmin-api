package com.garmin.gwt.communicator.client.gpx;

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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class WayPoint {

	@XmlElement(name="ele")
	protected double elevation;

	@XmlElement(name="time", required = true)
	protected String time;

	@XmlAttribute(name = "lat", required = true)
	protected double latitude;

	@XmlAttribute(name = "lon", required = true)
	protected double longitude;

	//@XmlElement(name="extensions")
	protected ExtensionsType extensions;



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WayPoint [elev=" + elevation + ", "
				+ (time != null ? "time=" + time + ", " : "") + "lat="
				+ latitude + ", lon=" + longitude + "]";
	}

	/**
	 * @return the elevation
	 */
	public final double getElevation() {
		return elevation;
	}

	/**
	 * @param elevation the elevation to set
	 */
	public final void setElevation(double elevation) {
		this.elevation = elevation;
	}

	/**
	 * @return the time
	 */
	public final String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public final void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the latitude
	 */
	public final double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public final void setLatitude(double latatiude) {
		latitude = latatiude;
	}

	/**
	 * @return the longitude
	 */
	public final double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public final void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the extensions
	 */
	public final ExtensionsType getExtensions() {
		return extensions;
	}

	/**
	 * @param extensions the extensions to set
	 */
	public final void setExtensions(ExtensionsType extensions) {
		this.extensions = extensions;
	}



}
