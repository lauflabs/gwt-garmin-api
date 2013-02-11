/**
 * 
 */
package com.garmin.gwt.communicator.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Sample files for XML parser testing
 * 
 * @author Joseph Lust
 * 
 */
public interface TestResources extends ClientBundle {

	TestResources INSTANCE = GWT.create(TestResources.class);

	@Source("xml/exampleGpsData.xml")
	public TextResource exampleGpxXml();
}
