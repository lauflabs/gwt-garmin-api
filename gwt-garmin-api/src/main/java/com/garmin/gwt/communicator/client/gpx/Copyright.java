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
public class Copyright {

	@XmlElement(name="year")
	protected int year;

	@XmlElement(name="license")
	protected String license;

	@XmlAttribute(name = "author", required=true)
	protected String author;

	/**
	 * @return the year
	 */
	public final int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public final void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the license
	 */
	public final String getLicense() {
		return license;
	}

	/**
	 * @param license the license to set
	 */
	public final void setLicense(String license) {
		this.license = license;
	}

	/**
	 * @return the author
	 */
	public final String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public final void setAuthor(String author) {
		this.author = author;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Copyright [year=" + year + ", "
				+ (license != null ? "license=" + license + ", " : "")
				+ (author != null ? "author=" + author : "") + "]";
	}


}
