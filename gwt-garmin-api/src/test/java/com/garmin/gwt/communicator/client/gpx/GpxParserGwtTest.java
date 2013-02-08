package com.garmin.gwt.communicator.client.gpx;

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

import com.garmin.gwt.communicator.client.AbstractGarminGWTTest;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.XMLParser;

/**
 * Test Jaxb parsing
 * 
 * @author Joseph Lust
 * 
 */
public class GpxParserGwtTest extends AbstractGarminGWTTest {

	public void testParseDeviceDescriptionXml_defaultForerunner() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><gpx xmlns=\"http://www.topografix.com/GPX/1/1\" xmlns:gpxx=\"http://www.garmin.com/xmlschemas/GpxExtensions/v3\" xmlns:gpxtpx=\"http://www.garmin.com/xmlschemas/TrackPointExtension/v1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" creator=\"GarminPlugin\" version=\"1.1\" xsi:schemaLocation=\"http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd http://www.garmin.com/xmlschemas/GpxExtensions/v3 http://www.garmin.com/xmlschemas/GpxExtensionsv3.xsd http://www.garmin.com/xmlschemas/TrackPointExtension/v1 http://www.garmin.com/xmlschemas/TrackPointExtensionv1.xsd\"><trk><name>2013-01-19T21:37:15Z</name><trkseg><trkpt lat=\"40.65361784\" lon=\"-73.96741882\"><ele>18.8831</ele><time>2013-01-19T21:48:26Z</time></trkpt><trkpt lat=\"40.65367886\" lon=\"-73.96725152\"><ele>45.3192</ele><time>2013-01-19T21:48:27Z</time></trkpt><trkpt lat=\"40.65368104\" lon=\"-73.96728974\"><ele>36.6675</ele><time>2013-01-19T21:48:28Z</time></trkpt></trkseg></trk></gpx>";

		Document doc = XMLParser.parse(mockXml);


		/*		GpxParserFactory factory = GWT.create(GpxParserFactory.class);
		Gpx gpx = factory.create().parse(mockXml);

		String actual = gpx.getCreator();*/
		String expected = "GarminPlugin";

		//Assert.assertEquals("Incorrectly parsed device description XML", expected, actual);
	}


}
