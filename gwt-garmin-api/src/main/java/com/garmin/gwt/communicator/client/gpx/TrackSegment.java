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

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrackSegment {

	@XmlElement(name="trkpt")
	protected ArrayList<TrackPoint> trackPoints;

	//@XmlElement(name="extensions")
	protected ExtensionsType extensions;

	/**
	 * @return the trackPoints
	 */
	public final ArrayList<TrackPoint> getTrackPoints() {
		return trackPoints;
	}

	/**
	 * @param trackPoints the trackPoints to set
	 */
	public final void setTrackPoints(ArrayList<TrackPoint> trackPoints) {
		this.trackPoints = trackPoints;
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
