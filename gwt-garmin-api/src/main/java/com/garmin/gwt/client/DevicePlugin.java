package com.garmin.gwt.client;

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

import com.garmin.gwt.client.base.Device;
import com.garmin.gwt.client.base.KeyPair;
import com.garmin.gwt.client.base.TransferProgress;
import com.garmin.gwt.client.base.Version;

/**
 * @author Joseph Lust
 * 
 */
public interface DevicePlugin {

	/**
	 * Unlocks the GpsControl object to be used at the given web address.<br>
	 * More than one set of path-key pairs my be passed in.<br>
	 * See documentation site for more info on getting a key. <br/>
	 * <br/>
	 * 
	 * @version Minimum plugin version 2.0.0.4
	 * @param kayPairs
	 *            array of {@link KeyPair}
	 * @return whether unlock was successful
	 */
	boolean unlock(KeyPair[] kayPairs);

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
	 * Use {@link #getDeviceXmlString()} to inspect XML contents for and array
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
	 * @return XML, potentially empty if no devices found
	 */
	String getDevicesXml();

	/**
	 * Parses {@link #getDevicesXml()} values into a Device array
	 * 
	 * @return empty array if no devices found
	 */
	Device[] getDevices();

	/*
	 * void startFindDevices();
	 * 
	 * void cancelFindDevices();
	 * 
	 * void finishFindDevices();
	 */
}
