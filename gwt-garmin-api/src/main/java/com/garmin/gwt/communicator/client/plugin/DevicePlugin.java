package com.garmin.gwt.communicator.client.plugin;

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

import com.garmin.gwt.communicator.client.base.Device;
import com.garmin.gwt.communicator.client.base.KeyPair;
import com.garmin.gwt.communicator.client.base.Version;
import com.garmin.gwt.communicator.client.request.TransferProgress;

/**
 * @author Joseph Lust
 * 
 */
public interface DevicePlugin {

	/**
	 * Unlocks the GpsControl object to be used at the given web address.<br>
	 * More than one set of path-key pairs my be passed in.<br>
	 * See documentation site for more info on getting a key. <br/>
	 * 
	 * @since Minimum plugin version 2.0.0.4
	 * @param keyPairs
	 *            array of {@link KeyPair}
	 * @return whether unlock was successful
	 */
	boolean unlock(KeyPair[] keyPairs);

	/**
	 * Returns true if the plugin is unlocked.
	 * 
	 * @return unlock state
	 */
	boolean isUnlocked();

	/**
	 * Gets a string of the version number for the plugin the user has currently
	 * installed.<br>
	 * 
	 * @return A string of the format
	 *         "versionMajor.versionMinor.buildMajor.buildMinor"<br>
	 *         i.e.: <code>2.0.0.4</code>
	 */
	String getPluginVersionString();

	/**
	 * Returns metadata information about the plugin version in raw XML form.
	 * 
	 * @return XML block
	 */
	String getVersionXml();

	/**
	 * Gets the version number for the plugin the user has currently installed.<br>
	 * <ul>
	 * <li>0 - VersionMajor</li>
	 * <li>1 - VersionMinor</li>
	 * <li>2 - BuildMajor</li>
	 * <li>3 - BuildMajor</li>
	 * </ul>
	 * 
	 * @return four element array
	 */
	Version getPluginVersion();

	/**
	 * Get the latest version.<br>
	 * Used in place of static <code>LATEST_VERSION</code> access in JS APIto
	 * adhere to Java interface best practices.
	 * 
	 * @return latest plugin version
	 */
	Version getLatestPluginVersion();

	/**
	 * Get the latest version.<br>
	 * Used in place of static <code>REQUIRED_VERSION</code> access in JS APIto
	 * adhere to Java interface best practices.
	 * 
	 * @return required plugin version
	 */
	Version getRequiredPluginVersion();

	/**
	 * Get the status/progress of the current state or transfer.
	 * 
	 * @return XML describing the ambient plugin progress state
	 */
	String getProgressXml();

	/**
	 * Get the status/progress of the current state or transfer
	 * 
	 * @return XML values parsed into a TransferProgress object
	 */
	TransferProgress getProgress();

	/**
	 * Initiates a find GPS devices action on the plugin.<br>
	 * Poll with {@link #finishFindDevices()} to determine when the plugin has
	 * completed this action.<br>
	 * Use {@link #getDevicesXml()} to inspect XML contents for and array
	 * of Device nodes.<br/>
	 * 
	 * @since 2.0.0.4
	 */
	void startFindDevices();

	/**
	 * Cancel the current find devices interaction.
	 * 
	 * @since 2.0.0.4
	 */
	void cancelFindDevices();

	/**
	 * Get state of last find devices action
	 * 
	 * @since 2.0.0.4
	 * @return true if completed finding devices otherwise false.
	 */
	boolean finishFindDevices();

	/**
	 * Returns information about the number of devices connected to this machine
	 * as well as the names of those devices. Refer to the Devices element in
	 * the <a href="http://www.garmin.com/xmlschemas/GarminPluginAPIV1.xsd">
	 * GarminPluginAPIV1 schema</a> for what is included. The XML returned
	 * should contain a 'Device' element with 'DisplayName' and 'Number' if
	 * there is a device actually connected.
	 * 
	 * @since 2.0.0.4
	 * @return XML, potentially empty if no devices found
	 */
	String getDevicesXml();

	/**
	 * Parses {@link #getDevicesXml()} values into a Device array
	 * 
	 * @return empty array if no devices found
	 */
	Device[] getDevices();

	/**
	 * This is the GpsXml information from the device. Typically called after a
	 * read operation.
	 */
	String getGpsXml();

	/**
	 * Initiates the read from the GPS device connected. Use finishReadFromGps
	 * and getGpsProgressXml to determine when the plugin is done with this
	 * operation. Also, use getGpsXml to extract the actual data from the
	 * device. <br/>
	 * 
	 * @since 2.0.0.4
	 * @param deviceNumber
	 *            deviceNumber assigned by plugin
	 */
	void startReadFromGps(int deviceNumber);

	/**
	 * Cancels the current read from the device.
	 * 
	 * @since 2.0.0.4
	 */
	void cancelReadFromGps();

	/**
	 * Indicates the status of the read process. It will return an integer know
	 * as the completion state. The purpose is to show the user information
	 * about what is happening to the plugin while it is servicing your request.
	 * Used after startReadFromGps().
	 * 
	 * @since 2.0.0.4
	 * @return Completion state - The completion state can be one of the
	 *         following: <br/>
	 *         <ul>
	 *         <li>0 idle</li>
	 *         <li>1 working</li>
	 *         <li>2 waiting</li>
	 *         <li>3 finished</li>
	 *         </ul>
	 */
	int finishReadFromGps();
}
