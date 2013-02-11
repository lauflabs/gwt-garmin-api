//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.02.06 at 11:45:34 PM EST
//


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

	protected MetadataType metadata;

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
	 * Gets the value of the metadata property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links MetadataType }
	 * 
	 */
	public MetadataType getMetadata() {
		return metadata;
	}

	/**
	 * Sets the value of the metadata property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links MetadataType }
	 * 
	 */
	public void setMetadata(MetadataType value) {
		metadata = value;
	}

	/**
	 * Gets the value of the wpt property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the wpt property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getWpt().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@links WayPoint }
	 * 
	 * 
	 */
	public ArrayList<WayPoint> getWayPoints() {
		if (wayPoints == null) {
			wayPoints = new ArrayList<WayPoint>();
		}
		return wayPoints;
	}

	/**
	 * Gets the value of the rte property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the rte property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getRte().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@links Route }
	 * 
	 * 
	 */
	public ArrayList<Route> getRoutes() {
		if (routes == null) {
			routes = new ArrayList<Route>();
		}
		return routes;
	}

	/**
	 * Gets the value of the trk property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the trk property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getTrk().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@links Track }
	 * 
	 * 
	 */
	public ArrayList<Track> getTracks() {
		if (tracks == null) {
			tracks = new ArrayList<Track>();
		}
		return tracks;
	}

	/**
	 * Gets the value of the extensions property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links ExtensionsType }
	 * 
	 */
	public ExtensionsType getExtensions() {
		return extensions;
	}

	/**
	 * Sets the value of the extensions property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links ExtensionsType }
	 * 
	 */
	public void setExtensions(ExtensionsType value) {
		extensions = value;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links String }
	 * 
	 */
	public String getVersion() {
		if (version == null) {
			return "1.1";
		} else {
			return version;
		}
	}

	/**
	 * Sets the value of the version property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links String }
	 * 
	 */
	public void setVersion(String value) {
		version = value;
	}

	/**
	 * Gets the value of the creator property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links String }
	 * 
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * Sets the value of the creator property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links String }
	 * 
	 */
	public void setCreator(String value) {
		creator = value;
	}

}
