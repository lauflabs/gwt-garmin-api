package com.garmin.gwt.communicator.client.base;

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

/**
 * POJO for the Device return information from the API
 * 
 * @author Joseph Lust
 * 
 */
public class Device {

	private String displayName;
	private int number;
	private String softwareVersion;

	/**
	 * @param displayName
	 * @param number
	 */
	public Device(String displayName, int number) {
		super();
		this.displayName = displayName;
		this.number = number;
	}

	/**
	 * @return the displayName
	 */
	public final String getDisplayName() {
		return displayName;
	}

	/**
	 * @return the number
	 */
	public final int getNumber() {
		return number;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Device [displayName=" + displayName + ", number=" + number
				+ ", softwareVersion=" + softwareVersion + "]";
	}

}
