package com.garmin.gwt.communicator.client.base;

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
import junit.framework.TestCase;

import com.garmin.gwt.communicator.client.base.Device;

/**
 * Test Device POJO
 * 
 * @author Joseph Lust
 * 
 */
public class DeviceTest extends TestCase {

	public void testAccessors() {

		String mockName = "Foo name";
		int mockNumber = 5;
		Device device = new Device(mockName, mockNumber);

		Assert.assertEquals("Failed getter", mockName, device.getDisplayName());
		Assert.assertEquals("Failed getter", mockNumber, device.getNumber());
	}
}
