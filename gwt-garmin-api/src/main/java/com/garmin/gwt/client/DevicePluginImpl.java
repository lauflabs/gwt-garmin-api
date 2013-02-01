package com.garmin.gwt.client;

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

import java.util.HashMap;

import javax.naming.InitialContext;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.XMLParser;

/**
 * Wraps the ActiveX/Netscape plugin that should be installed on your machine in order to talk to a Garmin Device.
 * <br>
 * See <a href=
 * "http://developer.garmin.com/web/communicator-api/documentation/symbols/Garmin.DevicePlugin.html"
 * >PluginDevice API Doc</a>
 */
public class DevicePluginImpl implements DevicePlugin {

	CommunicatorPlugin plugin;
	
	/**
	 * Creates a new map inside of the given HTML container, which is typically
	 * a DIV element.
	 */
	public DevicePluginImpl() {
		initialize();
	}
	
	/**
	 * Get the plugin object and validate 
	 * @throws Exception 
	 */
	private void initialize() {
		plugin = CommunicatorPlugin.newInstance();
	}
		
	@Override
	public boolean unlock(HashMap<String, String> pathKeysPair) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUnlocked() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String[] getPluginVersion() {
		
		String versionXml = plugin.getVersionXml();
		Document dom = XMLParser.parse(versionXml);
		
		String[] versions = new String[4];
		
		Node vMajorNode = dom.getElementsByTagName("VersionMajor").item(0);
		versions[0] = ((com.google.gwt.xml.client.Element)vMajorNode).getFirstChild().getNodeValue();
		
	    Node vMinorNode = dom.getElementsByTagName("VersionMinor").item(0);
	    versions[1] = ((com.google.gwt.xml.client.Element)vMinorNode).getFirstChild().getNodeValue();
		
		Node bMajorNode = dom.getElementsByTagName("BuildMajor").item(0);
		versions[2] = ((com.google.gwt.xml.client.Element)bMajorNode).getFirstChild().getNodeValue();
		
		Node bMinorNode = dom.getElementsByTagName("BuildMinor").item(0);
		versions[3] = ((com.google.gwt.xml.client.Element)bMinorNode).getFirstChild().getNodeValue();

		return versions;
	}

	@Override
	public String getPluginVersionString() {
		String[] versionParts = getPluginVersion();	
		return versionParts[0] + "." + versionParts[1] + "." + versionParts[2] + "." + versionParts[3];
	}

}
