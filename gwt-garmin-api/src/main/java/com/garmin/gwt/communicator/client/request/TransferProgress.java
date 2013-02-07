package com.garmin.gwt.communicator.client.request;

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
 * Encapsulates the data provided by the device for the current process'
 * progress.
 * 
 * @author Joseph Lust
 * 
 */
public class TransferProgress {
	private int percentage;
	private String title;
	private String[] text;
	private boolean hasPercentage; // whether the value has been set

	/**
	 * @param percentage
	 * @param title
	 * @param text
	 * @param hasPercentage set to false if percentage does not apply
	 */
	public TransferProgress(String title, String[] text, int percentage, boolean hasPercentage) {
		super();
		this.percentage = percentage;
		this.title = title;
		this.text = text;
		this.hasPercentage = hasPercentage;
	}

	/**
	 * The percentage,<br>
	 * <b>NOTE:</b> Check getHasPercentage() to determine if this progress state uses percentage
	 * @return defaults to 0.
	 */
	public final int getPercentage() {
		return percentage;
	}

	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @return the hasPercentage
	 */
	public final boolean hasPercentage() {
		return hasPercentage;
	}

	/**
	 * @return the text
	 */
	public final String[] getText() {
		return text;
	}

	@Override
	public String toString() {
		String progressString = "";
		if(title!= null) {
			progressString += title;
		}
		if(hasPercentage) {
			progressString += ": " + percentage + "%";
		}
		return progressString;
	}

}
