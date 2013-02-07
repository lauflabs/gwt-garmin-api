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
	private int deviceNumber;

	private Model model;

	private long id;// too big for int
	private String registrationCode;
	private String unlockCode;

	protected Device() {

	}

	/**
	 * Create basic Device POJO
	 * @param displayName
	 * @param deviceNumber
	 */
	public Device(final String displayName, final int number) {
		super();
		this.displayName = displayName;
		deviceNumber = number;
	}

	/**
	 * Create complex Device POJO
	 * @param displayName
	 * @param deviceNumber
	 * @param model
	 * @param id
	 * @param registrationCode
	 * @param unlockCode
	 */
	public Device(String displayName, int deviceNumber, Model model, long id,
			String registrationCode, String unlockCode) {
		//TODO use a builder pattern?
		super();
		this.displayName = displayName;
		this.deviceNumber = deviceNumber;
		this.model = model;
		this.id = id;
		this.registrationCode = registrationCode;
		this.unlockCode = unlockCode;
	}

	/**
	 * @return the displayName
	 */
	public final String getDisplayName() {
		return displayName;
	}

	/**
	 * @return the deviceNumber
	 */
	public final int getDeviceNumber() {
		return deviceNumber;
	}

	/**
	 * @return the model
	 */
	public final Model getModel() {
		return model;
	}

	/**
	 * Gets the ID, i.e.<code>3498411727</code><br>
	 * <b>NOTE:</b> will be 0 if not present on the XML description
	 * @return the id, or ZERO
	 */
	public final long getId() {
		return id;
	}

	/**
	 * Gets the registration code, i.e.<code>3VGWRH2</code><br>
	 * <b>NOTE:</b> will EMPTY if not present on the XML description
	 * @return the registrationCode, or EMPTY
	 */
	public final String getRegistrationCode() {
		return registrationCode;
	}

	/**
	 * Gets the unlock code, i.e.<code>62FQ8C5RZEUFVCTUY9AJAQ477</code><br>
	 * <b>NOTE:</b> will EMPTY if not present on the XML description
	 * @return the unlockCode, or EMPTY
	 */
	public final String getUnlockCode() {
		return unlockCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Device ["
				+ (displayName != null ? "displayName=" + displayName + ", "
						: "")
						+ "deviceNumber="
						+ deviceNumber
						+ ", "
						+ (model != null ? "model=" + model + ", " : "")
						+ "id="
						+ id
						+ ", "
						+ (registrationCode != null ? "registrationCode="
								+ registrationCode + ", " : "")
								+ (unlockCode != null ? "unlockCode=" + unlockCode : "") + "]";
	}



}
