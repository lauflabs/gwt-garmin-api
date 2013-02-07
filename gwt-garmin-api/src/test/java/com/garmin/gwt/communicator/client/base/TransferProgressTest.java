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

import com.garmin.gwt.communicator.client.request.TransferProgress;

/**
 * Test TransferProgress
 * 
 * @author Joseph Lust
 * 
 */
public class TransferProgressTest extends TestCase {

	public void testToString() {
		String[] mockText = new String[]{"Buy","Shaving","Cream"};
		TransferProgress prog = new TransferProgress("Foo Title",mockText,24,true);

		String expected = "Foo Title: 24%";
		String actual = prog.toString();
		Assert.assertEquals("Incorrect toString() output", expected, actual);
	}


	public void testToString_no_title() {
		String[] mockText = new String[]{"Buy","Shaving","Cream"};
		String mockTitle = null;
		TransferProgress prog = new TransferProgress(mockTitle, mockText,24, true);

		String expected = ": 24%";
		Assert.assertEquals("Incorrect tostring() output", expected, prog.toString());
	}
}
