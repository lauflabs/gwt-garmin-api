package com.garmin.gwt.communicator.client.util;

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

import junit.framework.Assert;

import com.garmin.gwt.communicator.client.AbstractGarminGWTTest;
import com.garmin.gwt.communicator.client.base.Device;

/**
 * Test DeviceUtils
 * 
 * @author Joseph Lust
 * 
 */
public class DeviceUtilsGwtTest extends AbstractGarminGWTTest {


	public void testIsForerunner_true() {
		Device mockDevice = new Device("ForerunnEr305 Software Version 2.90", 0);
		boolean actual = DeviceUtils.isForerunner(mockDevice);

		Assert.assertTrue("Device should be a Forerunner", actual);
	}

	public void testIsForerunner_false() {
		Device mockDevice = new Device("Forerunn305 Software Version 2.90", 0);
		boolean actual = DeviceUtils.isForerunner(mockDevice);

		Assert.assertFalse("Device should NOT be a Forerunner", actual);
	}

	public void testIsEdge_true() {
		Device mockDevice = new Device("nüvi 255", 0);
		boolean actual = DeviceUtils.isNuvi(mockDevice);

		Assert.assertTrue("Device should be a Nuvi", actual);

		mockDevice = new Device("nuvi 255", 0);
		actual = DeviceUtils.isNuvi(mockDevice);

		Assert.assertTrue("Device should be a Nuvi", actual);
	}

	public void testIsEdge_false() {
		Device mockDevice = new Device("nuuvi 255", 0);
		boolean actual = DeviceUtils.isNuvi(mockDevice);

		Assert.assertFalse("Device should NOT be a Nuvi", actual);
	}

	public void testIsNuvi_true() {
		Device mockDevice = new Device("Edge500 Software Version 2.90", 0);
		boolean actual = DeviceUtils.isEdge(mockDevice);

		Assert.assertTrue("Device should be an Edge", actual);
	}

	public void testIsNuvi_false() {
		Device mockDevice = new Device("Forage Software Version 2.90", 0);
		boolean actual = DeviceUtils.isEdge(mockDevice);

		Assert.assertFalse("Device should NOT be an Edge", actual);
	}
}
