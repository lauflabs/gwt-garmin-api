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
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MetaData {

	@XmlElement(name="link")
	protected Link link;

	@XmlElement(name="name")
	protected String name;

	@XmlElement(name="desc")
	protected String description;

	@XmlElement(name="author")
	protected Person author;

	@XmlElement(name="copyright")
	protected Copyright copyright;

	//@XmlSchemaType(name = "dateTime")
	@XmlElement(name="time")
	protected String time;

	@XmlElement(name="keywords")
	protected String keywords;

	@XmlElement(name="bounds")
	protected Bounds bounds;

	protected ExtensionsType extensions;

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the author
	 */
	public final Person getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public final void setAuthor(Person author) {
		this.author = author;
	}

	/**
	 * @return the copyright
	 */
	public final Copyright getCopyright() {
		return copyright;
	}

	/**
	 * @param copyright the copyright to set
	 */
	public final void setCopyright(Copyright copyright) {
		this.copyright = copyright;
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
	 * @return the keywords
	 */
	public final String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public final void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the bounds
	 */
	public final Bounds getBounds() {
		return bounds;
	}

	/**
	 * @param bounds the bounds to set
	 */
	public final void setBounds(Bounds bounds) {
		this.bounds = bounds;
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
	 * @return the link
	 */
	public final Link getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public final void setLink(Link link) {
		this.link = link;
	}


}
