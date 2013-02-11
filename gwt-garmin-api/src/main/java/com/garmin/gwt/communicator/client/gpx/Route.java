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
import javax.xml.bind.annotation.XmlSchemaType;
@XmlAccessorType(XmlAccessType.FIELD)
public class Route {

	@XmlElement
	protected String name;

	@XmlElement
	protected ArrayList<WayPoint> rtept;

	protected String cmt;
	protected String desc;
	protected String src;

	@XmlSchemaType(name = "nonNegativeInteger")
	protected long number;

	protected String type;
	protected ExtensionsType extensions;


	/**
	 * Gets the value of the name property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links String }
	 * 
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * Gets the value of the comment property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links String }
	 * 
	 */
	public String getCmt() {
		return cmt;
	}

	/**
	 * Sets the value of the comment property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links String }
	 * 
	 */
	public void setCmt(String value) {
		cmt = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links String }
	 * 
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links String }
	 * 
	 */
	public void setDesc(String value) {
		desc = value;
	}

	/**
	 * Gets the value of the source property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links String }
	 * 
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * Sets the value of the source property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links String }
	 * 
	 */
	public void setSrc(String value) {
		src = value;
	}

	/**
	 * Gets the value of the number property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links long }
	 * 
	 */
	public long getNumber() {
		return number;
	}

	/**
	 * Sets the value of the number property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links long }
	 * 
	 */
	public void setNumber(long value) {
		number = value;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return
	 *     possible object is
	 *     {@links String }
	 * 
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@links String }
	 * 
	 */
	public void setType(String value) {
		type = value;
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
	 * Gets the value of the rtept property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the rtept property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getRtept().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@links WayPoint }
	 * 
	 * 
	 */
	public ArrayList<WayPoint> getRtept() {
		if (rtept == null) {
			rtept = new ArrayList<WayPoint>();
		}
		return rtept;
	}

}
