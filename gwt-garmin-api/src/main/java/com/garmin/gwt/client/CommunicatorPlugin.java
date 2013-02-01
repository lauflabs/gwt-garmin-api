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

import com.garmin.gwt.client.exception.UnsupportedBrowserException;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.XMLParser;

/**
 * @author Joseph Lust
 * 
 */
public final class CommunicatorPlugin extends JavaScriptObject {

	static final String IE_PLUGIN_OBJECT = "GarminActiveXControl";
	static final String FF_PLUGIN_OBJECT = "GarminNetscapePlugin";
	static final String OBJECT_TYPE = "application/vnd-garmin.mygarmin";

	/**
	 * See {@link #newInstance()}
	 */
	protected CommunicatorPlugin() {

	}
	
	/**
	 * Insert the object necessary to connect to the plugin from the DOM.<br>
	 * We could do this by requiring users to insert them, but let's be dynamic!
	 */
	private final static void insertObject() {
		Element ieObject = DOM.createElement("object");
		ieObject.setAttribute("id", IE_PLUGIN_OBJECT);
		ieObject.setAttribute("type", OBJECT_TYPE);
		ieObject.setAttribute("style", "WIDTH: 0px; HEIGHT: 0px; visible: hidden");
		ieObject.setAttribute("classid", "CLSID:099B5A62-DE20-48C6-BF9E-290A9D1D8CB5"); // volatile?
		
		GWT.log("Appending IE object to root panel");
		// TODO pass in desired target location
		RootPanel.get().getElement().appendChild(ieObject);
		
		Element ffObject = DOM.createElement("object");
		ffObject.setAttribute("id", FF_PLUGIN_OBJECT);
		ffObject.setAttribute("type", OBJECT_TYPE);
		ffObject.setAttribute("height", "0");
		ffObject.setAttribute("width", "0");
		
		ieObject.appendChild(ffObject);
		GWT.log("Inserting FF object into IE object");
	}

	public final static CommunicatorPlugin newInstance() {
		insertObject();
				
		CommunicatorPlugin plugin = createJso().cast();
		if (plugin == null) {
			// should not happen, should have been inserted above
			throw new UnsupportedBrowserException("HtmlTagNotFoundException for Garmin plugin");
		}
		return plugin;
	}

	/**
	 * Find the plugin object at the expected location in IE or FF/Chrome
	 * 
	 * @return NULL if no object found
	 */
	private final static native JavaScriptObject createJso() /*-{
		
		// switch based on detected browser 
		var objName = ($wnd.ActiveXObject) ?
			@com.garmin.gwt.client.CommunicatorPlugin::IE_PLUGIN_OBJECT // IE
			: @com.garmin.gwt.client.CommunicatorPlugin::FF_PLUGIN_OBJECT; // All others

		// Either we have it, or it is not installed, or not supported
		return $doc.getElementById(objName);
	}-*/;

	/**
	 * Get plugin version information in XML form
	 * @return
	 */
	public final native String getVersionXml() /*-{
		return this.VersionXml;
	}-*/;
}
