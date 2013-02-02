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

import com.garmin.gwt.client.base.KeyPair;
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

	/*
	 * void startFindDevices();
	 * 
	 * void cancelFindDevices();
	 * 
	 * void finishFindDevices();
	 */
}
