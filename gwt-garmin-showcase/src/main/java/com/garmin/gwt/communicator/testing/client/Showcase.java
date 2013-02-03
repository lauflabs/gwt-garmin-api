package com.garmin.gwt.communicator.testing.client;

/*
 * #%L
 * GWT Maps API V3 - Showcase
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
import com.garmin.gwt.communicator.client.base.KeyPair;
import com.garmin.gwt.communicator.client.plugin.DevicePlugin;
import com.garmin.gwt.communicator.client.plugin.DevicePluginImpl;
import com.garmin.gwt.communicator.client.request.DevicesPluginRequest;
import com.garmin.gwt.communicator.client.request.RequestCallback;
import com.garmin.gwt.communicator.client.request.TransferProgress;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Showcase implements EntryPoint {

	private final String testContainer = "content";

	final DevicePlugin plugin = new DevicePluginImpl();

	// keys are public and url bound, no need to conceal
	final KeyPair key = new KeyPair("https://lauflabs.github.com",
			"3f287910143193d31f568d4d7d87cb4a");
	final KeyPair[] keys = new KeyPair[]{key};

	@Override
	public void onModuleLoad() {

		loadScreen();
	}

	/**
	 * Show basic controls to test functionality
	 */
	private void loadScreen() {
		HTML html = new HTML("Version Feature Tests<br/>");
		addWidget(html);

		Button button = new Button("Plugin Version");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String version = plugin.getPluginVersionString();
				Window.alert("Installed plugin version: " + version);
			}
		});
		addWidget(button);

		button = new Button("Plugin Version XML");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String version = plugin.getVersionXml();
				Window.alert("Installed plugin version: " + version);
			}
		});
		addWidget(button);

		button = new Button("Plugin Version Array");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int[] versions = plugin.getPluginVersion().toArray();
				String version = "[" + versions[0] + "," + versions[1] + ","
						+ versions[2] + "," + versions[3] + "]";
				Window.alert(version);
			}
		});
		addWidget(button);

		button = new Button("Plugin Latest Version");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert(plugin.getLatestPluginVersion().toString());
			}
		});
		addWidget(button);

		button = new Button("Plugin Required Version");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert(plugin.getRequiredPluginVersion().toString());
			}
		});
		addWidget(button);

		button = new Button("Unlock");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				plugin.unlock(new KeyPair[] {});
				String message = (plugin.isUnlocked()) ? "Unlocked!"
						: "Still LOCKED!";
				Window.alert(message);
			}
		});
		addWidget(button);

		button = new Button("Get Progress XML");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert(plugin.getProgressXml());
			}
		});
		addWidget(button);

		button = new Button("Get Progress");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert(plugin.getProgress().toString());
			}
		});
		addWidget(button);

		button = new Button("Device list XML");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				testReadFromDeviceXml();
			}
		});
		addWidget(button);

		button = new Button("Device list");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				testReadFromDevice();
			}
		});
		addWidget(button);

	}

	private void testReadFromDeviceXml() {
		// unlock plugin
		if(!plugin.unlock(keys) ) {
			Window.alert("failed to unlock plugin!");
		}

		// get list of devices
		plugin.startFindDevices();

		final Timer poller = new Timer() {
			@Override
			public void run() {
				if(plugin.finishFindDevices()) {
					this.cancel();
					String deviceXml = plugin.getDevicesXml();
					displayDevicesXml( deviceXml );
				}
			}
		};
		poller.scheduleRepeating(200);
	}

	private void testReadFromDevice() {
		// unlock plugin
		if(!plugin.unlock(keys) ) {
			Window.alert("failed to unlock plugin!");
		}

		// save reference if you want to cancel()
		new DevicesPluginRequest(plugin, new RequestCallback<Device[]>() {

			@Override
			public void onSuccess(Device[] result) {
				displayDevices(result);
			}

			@Override
			public void onCancel() {
				// clean up
			}

			@Override
			public void onProgress(TransferProgress progress) {
				// show progress
			}

		});
	}

	private void displayDevicesXml(String xml) {
		Window.alert(xml);
	}

	private void displayDevices(Device[] devices) {
		String out = "";
		for(Device d : devices) {
			out += d.toString() + "\n";
		}
		Window.alert(out);
	}

	/**
	 * Add the widget to the demos
	 * 
	 * @param widget
	 */
	private void addWidget(Widget widget) {
		RootPanel.get(testContainer).add(widget);
	}


}
