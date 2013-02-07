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
 * Test Model POJO
 * 
 * @author Joseph Lust
 * 
 */
public class ModelTest extends TestCase {

	public void testAccessors() {

		String mockPartNumber = "006-B0450-00";
		int mockSoftwareVersion = 5;
		String mockDescription = "Foo device descr";
		String mockExtensions = null; // none
		Model model = new Model(mockPartNumber, mockSoftwareVersion,
				mockDescription, mockExtensions);

		Assert.assertEquals("Failed getter", mockPartNumber,		model.getPartNumber());
		Assert.assertEquals("Failed getter", mockSoftwareVersion,	model.getSoftwareVersion());
		Assert.assertEquals("Failed getter", mockDescription,		model.getDescription());
		Assert.assertEquals("Failed getter", mockExtensions,		model.getExtensions());
	}

	public void testToString() {
		String mockPartNumber = "006-B0450-00";
		int mockSoftwareVersion = 5;
		String mockDescription = "Foo device descr";
		String mockExtensions = null; // none
		Model model = new Model(mockPartNumber, mockSoftwareVersion,
				mockDescription, mockExtensions);

		String expected = "Model [partNumber=006-B0450-00, softwareVersion=5, description=Foo device descr, extensions=null]";
		Assert.assertEquals("Failed getter", expected, model.toString());
	}
}
