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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Gpx {

	@XmlElement(name="metadata")
	protected MetaData metadata;

	@XmlElement(name="wpt")
	protected ArrayList<WayPoint> wayPoints;

	@XmlElement(name="rte")
	protected ArrayList<Route> routes;

	@XmlElement(name="trk")
	protected ArrayList<Track> tracks;

	protected ExtensionsType extensions;

	@XmlAttribute(name = "version", required = true)
	protected String version;

	@XmlAttribute(name = "creator", required = true)
	protected String creator;

	/**
	 * @return the metadata
	 */
	public final MetaData getMetadata() {
		return metadata;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public final void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}

	/**
	 * @return the wayPoints
	 */
	public final ArrayList<WayPoint> getWayPoints() {
		return wayPoints;
	}

	/**
	 * @param wayPoints the wayPoints to set
	 */
	public final void setWayPoints(ArrayList<WayPoint> wayPoints) {
		this.wayPoints = wayPoints;
	}

	/**
	 * @return the routes
	 */
	public final ArrayList<Route> getRoutes() {
		return routes;
	}

	/**
	 * @param routes the routes to set
	 */
	public final void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}

	/**
	 * @return the tracks
	 */
	public final ArrayList<Track> getTracks() {
		return tracks;
	}

	/**
	 * @param tracks the tracks to set
	 */
	public final void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
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

	/**
	 * @return the version
	 */
	public final String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public final void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the creator
	 */
	public final String getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public final void setCreator(String creator) {
		this.creator = creator;
	}

}
