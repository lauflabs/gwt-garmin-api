package com.garmin.gwt.client;

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

import com.garmin.gwt.client.base.KeyPair;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class TestScreen implements EntryPoint {

	private final String testContainer = "content";
	final DevicePlugin plugin = new DevicePluginImpl();

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
				Window.alert("Installed plugin version: "+version);
			}
		});
		addWidget(button);

		button = new Button("Plugin Version XML");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String version = plugin.getVersionXml();
				Window.alert("Installed plugin version: "+version);
			}
		});
		addWidget(button);

		button = new Button("Plugin Version Array");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int[] versions = plugin.getPluginVersion().toArray();
				String version = "["+versions[0]+","+versions[1]+","+versions[2]+","+versions[3]+"]";
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
				plugin.unlock(new KeyPair[]{});
				String message = (plugin.isUnlocked()) ? "Unlocked!" : "Still LOCKED!";
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
