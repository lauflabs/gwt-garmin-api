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

@XmlAccessorType(XmlAccessType.FIELD)
public class Bounds {

	@XmlAttribute(name = "minlat", required = true)
	protected double minLatitude;

	@XmlAttribute(name = "minlon", required = true)
	protected double minLongitude;

	@XmlAttribute(name = "maxlat", required = true)
	protected double maxLatitude;

	@XmlAttribute(name = "maxlon", required = true)
	protected double maxLongitude;

	/**
	 * @return the minLatitude
	 */
	public final double getMinLatitude() {
		return minLatitude;
	}

	/**
	 * @param minLatitude the minLatitude to set
	 */
	public final void setMinLatitude(double minLatitude) {
		this.minLatitude = minLatitude;
	}

	/**
	 * @return the minLongitude
	 */
	public final double getMinLongitude() {
		return minLongitude;
	}

	/**
	 * @param minLongitude the minLongitude to set
	 */
	public final void setMinLongitude(double minLongitude) {
		this.minLongitude = minLongitude;
	}

	/**
	 * @return the maxLatitude
	 */
	public final double getMaxLatitude() {
		return maxLatitude;
	}

	/**
	 * @param maxLatitude the maxLatitude to set
	 */
	public final void setMaxLatitude(double maxLatitude) {
		this.maxLatitude = maxLatitude;
	}

	/**
	 * @return the maxLongitude
	 */
	public final double getMaxLongitude() {
		return maxLongitude;
	}

	/**
	 * @param maxLongitude the maxLongitude to set
	 */
	public final void setMaxLongitude(double maxLongitude) {
		this.maxLongitude = maxLongitude;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bounds [minLatitude=" + minLatitude + ", minLongitude="
				+ minLongitude + ", maxLatitude=" + maxLatitude
				+ ", maxLongitude=" + maxLongitude + "]";
	}
}
