package com.garmin.gwt.client.events;

/*
 * #%L
 * GWT Maps API V3 - Core API
 * %%
 * Copyright (C) 2011 - 2012 GWT Maps API V3
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
 * possible observable event types
 * 
 * {@link MapHandlerRegistration} uses these events. (Also find trigger here too)
 * 
 */
public enum GarminEventType {

	/**
	 *  called when starting to search for devices. the object returned is {controller: this}
	 */
	START_FIND_DEVICES("onStartFindDevices"),

	/**
	 *  is called when the controller is told to cancel finding devices {controller: this}
	 */
	CANCEL_FIND_DEVICES("onCancelFindDevices"),

	/**
	 *  called when the devices are found. the object returned is {controller: this}
	 */
	FINISH_FIND_DEVICES("onFinishFindDevices"),

	/**
	 * called when an exception occurs in a method object passed back is {msg: exception}
	 */
	EXCEPTION("onException"),

	/**
	 * called when the device is lazy loaded, but finds no devices, yet still attempts a read/write action {controller: this}
	 */
	INTERACTION_WITH_NO_DEVICE("onInteractionWithNoDevice"),

	/**
	 * called when the controller is about to start reading from the device {controller: this}
	 */
	START_READ_FROM_DEVICE("onStartReadFromDevice"),

	/**
	 * called when the controller is done reading the device. the read is either a success or failure, which is communicated via json. object passed back contains {success:this.garminPlugin.GpsTransferSucceeded, controller: this}
	 */
	FINISH_READ_FROM_DEVICE("onFinishReadFromDevice"),

	/**
	 * called when the controller is waiting for input from the user about the device. object passed back contains: {message: this.garminPlugin.MessageBoxXml, controller: this}
	 */
	WAITING_READ_FROM_DEVICE("onWaitingReadFromDevice"),

	/**
	 * called when the controller is still reading information from the device. in this case the message is a percent complete/ {progress: this.getDeviceStatus(), controller: this}
	 */
	PROGRESS_READ_FROM_DEVICE("onProgressReadFromDevice"),

	/**
	 * called when the controller is told to cancel reading from the device {controller: this}
	 */
	CANCEL_READ_FROM_DEVICE("onCancelReadFromDevice"),

	/**
	 * called when the controller is done writing to the device. the write is either a success or failure, which is communicated via json. object passed back contains {success:this.garminPlugin.GpsTransferSucceeded, controller: this}
	 */
	FINISH_WRITE_TO_DEVICE("onFinishWriteToDevice"),

	/**
	 * called when the controller is waiting for input from the user about the device. object passed back contains: {message: this.garminPlugin.MessageBoxXml, controller: this}
	 */
	WAITING_WRITE_TO_DEVICE("onWaitingWriteToDevice"),

	/**
	 * called when the controller is still writing information to the device. in this case the message is a percent complete/ {progress: this.getDeviceStatus(), controller: this}
	 */
	PROGRESS_WRITE_TO_DEVICE("onProgressWriteToDevice"),

	/**
	 * called when the controller is told to cancel writing to the device {controller: this}
	 */
	CANCEL_WRITE_TO_DEVICE("onCancelWriteToDevice");

	private String callbackMethod;

	/**
	 * Types of event
	 * @param callbackMethod expected name of method underlying API will call on event
	 */
	private GarminEventType(String callbackMethod) {
		this.callbackMethod = callbackMethod;
	}

	public String value() {
		return name().toLowerCase();
	}

	public static GarminEventType fromValue(String type) {
		return valueOf(type.toUpperCase());
	}

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}