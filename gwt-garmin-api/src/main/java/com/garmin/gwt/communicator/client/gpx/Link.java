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
public class Link {

	@XmlElement(name = "text")
	protected String text;

	@XmlElement(name = "type")
	protected String type;

	@XmlAttribute(name = "href", required = true)
	protected String href;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Link [" + (text != null ? "text=" + text + ", " : "")
				+ (type != null ? "type=" + type + ", " : "")
				+ (href != null ? "href=" + href : "") + "]";
	}

	/**
	 * @return the text
	 */
	public final String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public final void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the type
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the href
	 */
	public final String getHref() {
		return href;
	}

	/**
	 * @param href the href to set
	 */
	public final void setHref(String href) {
		this.href = href;
	}

}
