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

import java.util.ArrayList;

import junit.framework.Assert;

import com.garmin.gwt.communicator.client.AbstractGarminGWTTest;
import com.garmin.gwt.communicator.client.resources.TestResources;
import com.google.gwt.core.client.GWT;

/**
 * Test Jaxb parsing
 * 
 * @author Joseph Lust
 * 
 */
public class GpxParserFactoryGwtTest extends AbstractGarminGWTTest {

	private GpxParserFactory parser;

	@Override
	protected boolean supportsAsync() {
		return false;
	}

	@Override
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		parser = GWT.create(GpxParserFactory.class);
	}


	public void testParseMetaData() {
		String testXml = TestResources.INSTANCE.exampleGpxXml().getText();
		Gpx obj = parser.create().parse(testXml);
		testXml = ""; // clear out, string kills debugger

		String expected = "GarminPlugin";
		Assert.assertEquals("wrong creator", expected, obj.getCreator());

		String version = "1.1";
		Assert.assertEquals("wrong version", version, obj.getVersion());

		//meta
		MetaData meta = obj.getMetadata();

		Assert.assertEquals("wrong meta time", "2012-12-15T14:40:43.000Z", meta.getTime());

		//copyright
		Copyright copy = meta.getCopyright();

		Assert.assertNotNull("missing copyright", copy);

		Assert.assertEquals("wrong copyright author", "Lauf Labs LLC", copy.getAuthor());
		Assert.assertEquals("wrong copyright author", 2013, copy.getYear());
		Assert.assertEquals("wrong copyright author", "sampleUrl", copy.getLicense());

		//bounds
		Bounds bounds = meta.getBounds();
		Assert.assertNotNull("missing bounds", bounds);

		Assert.assertEquals("wrong bounds value", 34.34d, bounds.getMinLongitude());
		Assert.assertEquals("wrong bounds value", 10.1d, bounds.getMinLatitude());
		Assert.assertEquals("wrong bounds value", 54.33d, bounds.getMaxLongitude());
		Assert.assertEquals("wrong bounds value", 22.4d, bounds.getMaxLatitude());

		//author
		Person author = meta.getAuthor();
		Assert.assertNotNull("missing author", author);

		String name = author.getName();
		Assert.assertEquals("wrong author name", "Foo Name", name);


		//email
		Email email = author.getEmail();
		Assert.assertNotNull("missing author email", email);

		Assert.assertEquals("wrong author email id", "someName", email.getId());
		Assert.assertEquals("wrong author email domain", "foo.com", email.getDomain());

		Assert.assertNotNull("wrong keywords value", meta.getKeywords());
		Assert.assertNotNull("wrong name value", meta.getName());
		Assert.assertNotNull("wrong name description", meta.getDescription());

		//link
		Link link = meta.getLink();
		Assert.assertEquals("wrong link href", "connect.garmin.com", link.getHref());
		Assert.assertEquals("wrong link type", "site", link.getType());
		Assert.assertEquals("wrong link text", "Garmin Connect", link.getText());
	}

	public void testParseTracks() {
		String testXml = TestResources.INSTANCE.exampleGpxXml().getText();
		Gpx obj = parser.create().parse(testXml);
		testXml = ""; // clear out, string kills debugger

		ArrayList<Track> tracks = obj.getTracks();
		Assert.assertEquals("tracks missing", 2, tracks.size());

		Track track = tracks.get(0);
		Assert.assertEquals("wrong track name", "2013-01-19T21:37:15Z", track.getName());
		ArrayList<TrackSegment> segments = track.getTrkseg();
		Assert.assertEquals("segments missing", 6, segments.size());

		ArrayList<TrackPoint> trackPoints = segments.get(0).getTrackPoints();
		Assert.assertEquals("waypoints missing", 428, trackPoints.size());

		TrackPoint point = trackPoints.get(0);
		double precision = 1e-4;
		Assert.assertEquals("bad latitude", 40.6536d, point.getLatitude(),precision);
		Assert.assertEquals("bad longitude", -73.96741d, point.getLongitude(),precision);
		Assert.assertEquals("bad elevation", 18.8831d, point.getElevation(),precision);
		Assert.assertEquals("bad time", "2013-01-19T21:48:26Z", point.getTime());

	}

}
