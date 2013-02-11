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
import com.garmin.gwt.communicator.client.gpx.Gpx;
import com.garmin.gwt.communicator.client.gpx.MetaData;
import com.garmin.gwt.communicator.client.plugin.DevicePlugin;
import com.garmin.gwt.communicator.client.request.FindDevicesPluginRequest;
import com.garmin.gwt.communicator.client.request.FitnessDataPluginRequest;
import com.garmin.gwt.communicator.client.request.GpxDataPluginRequest;
import com.garmin.gwt.communicator.client.request.RequestCallback;
import com.garmin.gwt.communicator.client.request.TransferProgress;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class Showcase implements EntryPoint {

	private TextArea console;
	private final String testContainer = "content";

	final DevicePlugin plugin = GWT.create(DevicePlugin.class);

	// keys are public and url bound, no need to conceal
	final KeyPair key = new KeyPair("http://lauflabs.github.com",
			"f7fca95a7c1ef1fe41f0a46e39c59d22");
	final KeyPair[] keys = new KeyPair[]{key};

	@Override
	public void onModuleLoad() {

		// small delay to allow the page to parse the plugin
		final Timer delay = new Timer() {
			@Override
			public void run() {
				conditionallyLoadScreen();
			}
		};
		delay.schedule(300);
	}

	private void conditionallyLoadScreen() {
		boolean hasPlugin = pluginDetect();
		if(hasPlugin) {
			loadScreen();
		}
		else {
			installPluginScreen();
		}
	}

	private void installPluginScreen() {
		HTML html = new HTML("<b>:(</b> Garmin Communicator is <b>NOT</b> <u>installed</u> OR is not <u>enabled</u>.<br/>Please visit the <a target='_blank' href=\"http://www.garmin.com/products/communicator/\">Garmin Communicator Site</a> to install<br>OR click the browser prompt to allow the plugin to load for this site");
		addWidget(html);
	}

	private boolean pluginDetect() {
		try {
			return plugin.unlock(keys);
		}
		catch(Exception e) {
			return false;
		}

	}

	/**
	 * Show basic controls to test functionality
	 */
	private void loadScreen() {
		HTML html = new HTML("Version Feature Tests<br/>");
		addWidget(html);

		console = new TextArea();
		addWidget(console);

		Button button = new Button("Plugin Version");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String version = plugin.getPluginVersionString();
				displayToConsole("Installed plugin version: " + version);
			}
		});
		addWidget(button);

		button = new Button("Plugin Version XML");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String version = plugin.getVersionXml();
				displayToConsole("Installed plugin version: " + version);
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
				displayToConsole(version);
			}
		});
		addWidget(button);

		button = new Button("Plugin Latest Version");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				displayToConsole(plugin.getLatestPluginVersion().toString());
			}
		});
		addWidget(button);

		button = new Button("Plugin Required Version");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				displayToConsole(plugin.getRequiredPluginVersion().toString());
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
				displayToConsole(message);
			}
		});
		addWidget(button);

		HTML html2 = new HTML("<br/>Load Data Tests<br/>");
		addWidget(html2);


		button = new Button("Get Progress XML");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				displayToConsole(plugin.getProgressXml());
			}
		});
		addWidget(button);

		button = new Button("Get Progress");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				displayToConsole(plugin.getProgress().toString());
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

		button = new Button("Device descriptsion XML");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				testReadDeviceDescriptionXml();
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

		button = new Button("Get Parsed GPX Data");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				testReadGpsData();
			}
		});
		addWidget(button);

		button = new Button("Get Fitness Data XML");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				testReadFitnessData();
			}
		});
		addWidget(button);

	}

	private void testReadFromDeviceXml() {
		// unlock plugin
		if(!plugin.unlock(keys) ) {
			displayToConsole("failed to unlock plugin!");
		}

		// get list of devices
		plugin.startFindDevices();

		final Timer poller = new Timer() {
			@Override
			public void run() {
				if(plugin.finishFindDevices()) {
					this.cancel();
					String deviceXml = plugin.getDevicesXml();
					displayToConsole( deviceXml );
				}
			}
		};
		poller.scheduleRepeating(200);
	}

	private void testReadDeviceDescriptionXml() {
		// unlock plugin
		if(!plugin.unlock(keys) ) {
			displayToConsole("failed to unlock plugin!");
		}

		Device fooDevice = new Device("Foo Device", 0);
		String deviceXml = plugin.getDeviceDescriptionXml(fooDevice);
		displayToConsole( deviceXml );
	}

	private void testReadFromDevice() {

		// save reference if you want to cancel()
		new FindDevicesPluginRequest(plugin, new RequestCallback<Device[]>() {

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
				displayToConsole("Loading Device data "+progress.getPercentage());
			}

		});
	}

	private void testReadGpsData() {

		Device targetDevice = new Device("Foo", 0);

		// save reference if you want to cancel()
		new GpxDataPluginRequest(plugin, targetDevice, new RequestCallback<Gpx>() {

			@Override
			public void onSuccess(Gpx result) {

				String out = "Creator: "+result.getCreator()+"\n";
				out += "Version: "+result.getVersion() +"\n";
				out += "Tracks: "+result.getTracks().size() +"\n";
				out += "Routes: "+result.getRoutes().size() +"\n";
				out += "WayPoints: "+result.getWayPoints().size() +"\n";

				MetaData meta = result.getMetadata();
				if((meta!=null) && (meta.getName()!=null)) {
					out += "Name: "+meta.getName()+"\n";
				}
				if((meta!=null) && (meta.getLink()!=null)) {
					out += "Link: "+meta.getLink()+"\n";
				}
				if((meta!=null) && (meta.getAuthor()!=null)) {
					out += "Author: "+meta.getAuthor()+"\n";
				}
				if((meta!=null) && (meta.getCopyright()!=null)) {
					out += "Copyright: "+meta.getCopyright()+"\n";
				}

				displayToConsole(out);
			}

			@Override
			public void onCancel() {
				displayToConsole("Error reading GPS xml data!");
			}

			@Override
			public void onProgress(TransferProgress progress) {
				displayToConsole("Loading GPS data "+progress.getPercentage());
			}

		});
	}

	private void testReadFitnessData() {

		Device targetDevice = new Device("Foo", 0);

		// save reference if you want to cancel()
		new FitnessDataPluginRequest(plugin, targetDevice, "training" ,new RequestCallback<String>() {

			@Override
			public void onSuccess(String result) {
				displayToConsole(result);
			}

			@Override
			public void onCancel() {
				displayToConsole("Error reading Fitness xml data!");
			}

			@Override
			public void onProgress(TransferProgress progress) {
				displayToConsole("Loading Fitness data "+progress.getPercentage());
			}

		});
	}

	private void displayToConsole(String msg) {
		console.setText(msg);
	}

	private void displayDevices(Device[] devices) {
		String out = "";
		for(Device d : devices) {
			out += d.toString() + "\n";
		}
		displayToConsole(out);
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
