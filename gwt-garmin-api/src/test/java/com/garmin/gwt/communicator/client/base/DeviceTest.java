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
		Assert.assertEquals("Failed getter", mockNumber, device.getDeviceNumber());
	}

	public void testAccessors_complex() {

		String registrationCode = "9VGRRHV";
		String unlockCode	 =  "6VFQ8C5RZEUFVCTSW9AJAQ488";

		// model information
		String partNumber = "006-B0450-00";
		long softwareVersion = 290;
		long id = 3600980071L;
		String description = "Forerunner305 Software Version 2.90";
		String extensions = "";

		Model model = new Model(partNumber, softwareVersion, description, extensions);

		String displayName = "Foo name";
		int deviceNumber = 5;

		// genesis
		Device device = new Device(displayName, deviceNumber, model, id, registrationCode, unlockCode);

		Assert.assertEquals("Failed getter", displayName, device.getDisplayName());
		Assert.assertEquals("Failed getter", deviceNumber, device.getDeviceNumber());
		Assert.assertEquals("Failed getter", model, device.getModel());
		Assert.assertEquals("Failed getter", id, device.getId());
		Assert.assertEquals("Failed getter", registrationCode, device.getRegistrationCode());
		Assert.assertEquals("Failed getter", unlockCode, device.getUnlockCode());
	}

	public void testAccessors_toString() {

		String registrationCode = "9VGRRHV";
		String unlockCode	 =  "6VFQ8C5RZEUFVCTSW9AJAQ488";

		// model information
		String partNumber = "006-B0450-00";
		long softwareVersion = 290;
		long id = 3600980071L;
		String description = "Forerunner305 Software Version 2.90";
		String extensions = "";

		Model model = new Model(partNumber, softwareVersion, description, extensions);

		String displayName = "Foo name";
		int deviceNumber = 5;

		// genesis
		Device device = new Device(displayName, deviceNumber, model, id, registrationCode, unlockCode);

		String expected = "Device [displayName=Foo name, deviceNumber=5, model=Model [partNumber=006-B0450-00, softwareVersion=290, description=Forerunner305 Software Version 2.90, extensions=], id=3600980071, registrationCode=9VGRRHV, unlockCode=6VFQ8C5RZEUFVCTSW9AJAQ488]";
		Assert.assertEquals("Failed toString() creation", expected, device.toString());
	}
}
