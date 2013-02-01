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

	@Override
	public void onModuleLoad() {
		loadScreen();
	}

	/**
	 * Show basic controls to test functionality
	 */
	private void loadScreen() {
		HTML html = new HTML("Feature test!<br/>");
		addWidget(html);

		Button button = new Button("Plugin Version!");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				doPluginMagic();
			}
		});
		addWidget(button);

	}
	
	private void doPluginMagic() {
		DevicePlugin plugin = new DevicePluginImpl();
		String version = plugin.getPluginVersionString();
		
		Window.alert("Installed plugin version: "+version);		
		
		
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
