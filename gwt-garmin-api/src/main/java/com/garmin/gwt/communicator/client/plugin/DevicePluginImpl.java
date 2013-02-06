package com.garmin.gwt.communicator.client.plugin;

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

import com.garmin.gwt.communicator.client.base.Device;
import com.garmin.gwt.communicator.client.base.FinishStatusType;
import com.garmin.gwt.communicator.client.base.KeyPair;
import com.garmin.gwt.communicator.client.base.Version;
import com.garmin.gwt.communicator.client.exception.UnsupportedPluginFeatureException;
import com.garmin.gwt.communicator.client.request.TransferProgress;
import com.garmin.gwt.communicator.client.util.PluginUtils;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.XMLParser;

/**
 * Wraps the ActiveX/Netscape plugin that should be installed on your machine in
 * order to talk to a Garmin Device. <br>
 * See <a href=
 * "http://developer.garmin.com/web/communicator-api/documentation/symbols/Garmin.DevicePlugin.html"
 * >PluginDevice API Doc</a>
 */
public class DevicePluginImpl implements DevicePlugin {

	CommunicatorPlugin plugin;
	private Version pluginVersion;
	private boolean isUnlocked;

	// TODO: not a fan of these values hardcoded in the garmin reference impl
	private static final Version LATEST_VERSION = new Version(3, 0, 1, 0);
	private static final Version REQUIRED_VERSION = new Version(3, 0, 0, 0);

	protected static final Version REQUIRED_VERSION_READ_FITNESS_DATA = new Version(
			2, 1, 0, 3);

	/**
	 * Creates a new map inside of the given HTML container, which is typically
	 * a DIV element.
	 */
	public DevicePluginImpl() {
		initialize();
	}

	/**
	 * Get the plugin object and validate
	 * 
	 * @throws Exception
	 */
	private void initialize() {
		plugin = CommunicatorPlugin.newInstance();
	}

	@Override
	public Version getPluginVersion() {

		// cache after first pass since version won't change within session
		if(pluginVersion==null) {

			//TODO move to parsing util class
			String versionXml = plugin.getVersionXml();
			Document dom = XMLParser.parse(versionXml);

			int[] versions = new int[4];
			String[] tags = new String[] { "VersionMajor", "VersionMinor",
					"BuildMajor", "BuildMinor" };

			int n = 0;
			for (String tag : tags) {
				Node node = dom.getElementsByTagName(tag).item(0);
				versions[n] = Integer
						.parseInt(((com.google.gwt.xml.client.Element) node)
								.getFirstChild().getNodeValue());
				n++;
			}
			pluginVersion  = new Version(versions);
		}
		return pluginVersion;
	}

	@Override
	public String getPluginVersionString() {
		return getPluginVersion().toString();
	}

	@Override
	public String getVersionXml() {
		return plugin.getVersionXml();
	}

	@Override
	public Version getLatestPluginVersion() {
		return LATEST_VERSION;
	}

	@Override
	public Version getRequiredPluginVersion() {
		return REQUIRED_VERSION;
	}

	@Override
	public boolean unlock(KeyPair[] keyPairs) {
		// sanity check
		if (isUnlocked()) {
			return true;
		}
		// try pairs
		for (KeyPair pair : keyPairs) {
			if (plugin.unlock(pair)) {
				isUnlocked = true;
				return isUnlocked;
			}
		}
		// try defaults
		KeyPair[] localPairs = new KeyPair[] {
				new KeyPair("file:///", "cb1492ae040612408d87cc53e3f7ff3c"),
				new KeyPair("http://localhost",
						"45517b532362fc3149e4211ade14c9b2"),
						new KeyPair("http://127.0.0.1",
								"40cd4860f7988c53b15b8491693de133") };
		for (KeyPair pair : localPairs) {
			if (plugin.unlock(pair)) {
				isUnlocked = true;
				return isUnlocked;
			}
		}
		// bupkis
		return isUnlocked;
	}

	@Override
	public boolean isUnlocked() {
		return isUnlocked;
	}

	@Override
	public String getProgressXml() {
		return plugin.getProgressXml();
	}

	@Override
	public TransferProgress getProgress() {
		return PluginUtils.parseProgressXml(plugin.getProgressXml());
	}

	/*** Get actual information about/from the devices ***/

	@Override
	public void startFindDevices() {
		plugin.startFindDevices();
	}

	@Override
	public void cancelFindDevices() {
		plugin.cancelFindDevices();
	}

	@Override
	public boolean finishFindDevices() {
		return plugin.finishFindDevices();
	}

	@Override
	public String getDevicesXml() {
		return plugin.devicesXmlString();
	}

	@Override
	public Device[] getDevices() {
		return PluginUtils.parseDeviceXml(plugin.devicesXmlString());
	}

	@Override
	public String getGpsXml() {
		return plugin.gpsXml();
	}

	@Override
	public void startReadFromGps(Device device) {
		plugin.startReadFromGps(device.getNumber());
	}

	@Override
	public void cancelReadFromGps() {
		plugin.cancelReadFromGps();
	}

	@Override
	public FinishStatusType finishReadFromGps() {
		return plugin.finishReadFromGps();
	}

	@Override
	public void startReadFitnessData(Device device, String dataTypeName) {
		if (getPluginVersion()
				.isVersionOlderThan(REQUIRED_VERSION_READ_FITNESS_DATA)) {
			throw new UnsupportedPluginFeatureException(
					formatVersionSupportMessage(pluginVersion,
							"does not support reading this type of fitness data"));
		}
		plugin.startReadFitnessData(device.getNumber(), dataTypeName);
	}

	@Override
	public void cancelReadFitnessData() {
		plugin.cancelReadFitnessData();
	}

	@Override
	public FinishStatusType finishReadFitnessData() {
		return plugin.finishReadFitnessData();
	}

	@Override
	public String getTcdXml() {
		return plugin.getTcdXml();
	}

	/*** HELPERS ***/
	// TODO: move to utils

	/**
	 * Message helper
	 * 
	 * @param version
	 * @param message
	 * @return
	 */
	private String formatVersionSupportMessage(Version version, String message) {
		return "Your Communicator Plug-in version (" + version.toString()
				+ ") " + message + ".";
	}
}
