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

import java.util.HashMap;

/**
 * @author Joseph Lust
 *
 */
public interface DevicePlugin {

	/**
	 * Unlocks the GpsControl object to be used at the given web address.<br>
	 * More than one set of path-key pairs my be passed in, for example:<br>
	 * <code>{{'http://myDomain.com/', 'xxx'},{'http://www.myDomain.com/', 'yyy'}}</code>
	 * See documentation site for more info on getting a key. <br/>
	 * <br/>
	 * @version Minimum plugin version 2.0.0.4
	 * @param pathKeysPair baseURL and key pairs  
	 * @return true if successfully unlocked or undefined otherwise
	 */
	boolean unlock( HashMap<String,String> pathKeysPair );
	
	/**
	 * Returns true if the plug-in is unlocked.
	 * @return unlock state
	 */
	boolean isUnlocked();
	
	/**
	 * Gets a string of the version number for the plugin the user has currently installed.<br>
	 * 
	 * @return  A string of the format "versionMajor.versionMinor.buildMajor.buildMinor"<br>
	 * i.e.: <code>2.0.0.4</code>
	 */
	String getPluginVersionString();
	

/*	void startFindDevices();
	
	void cancelFindDevices();
	
	void finishFindDevices();*/
}
