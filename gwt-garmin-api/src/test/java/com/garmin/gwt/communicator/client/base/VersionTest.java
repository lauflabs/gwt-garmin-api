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

import org.junit.Test;


/**
 * test version comparators
 * 
 * @author Joseph Lust
 * 
 */
public class VersionTest extends TestCase {

	@Test
	public void testConstructor_array() {

		int[] initArray = new int[]{1,2,3,4};
		Version actual = new Version(initArray);

		Assert.assertEquals("Incorrect version init",initArray[0],actual.getVersionMajor());
		Assert.assertEquals("Incorrect version init",initArray[1],actual.getVersionMinor());
		Assert.assertEquals("Incorrect version init",initArray[2],actual.getBuildMajor());
		Assert.assertEquals("Incorrect version init",initArray[3],actual.getBuildMinor());
	}

	@Test
	public void testAccessors_values() {

		int[] initArray = new int[]{1,2,3,4};
		Version actual = new Version(initArray[0],initArray[1],initArray[2],initArray[3]);

		Assert.assertEquals("Incorrect version init",initArray[0],actual.getVersionMajor());
		Assert.assertEquals("Incorrect version init",initArray[1],actual.getVersionMinor());
		Assert.assertEquals("Incorrect version init",initArray[2],actual.getBuildMajor());
		Assert.assertEquals("Incorrect version init",initArray[3],actual.getBuildMinor());
	}

	@Test
	public void testAccessors_toString() {

		int[] initArray = new int[]{1,2,3,4};
		Version actual = new Version(initArray);

		String expected = "1.2.3.4";
		Assert.assertEquals("Incorrect string concat",expected,actual.toString());
	}

	@Test
	public void testAccessors_toArray() {

		int[] initArray = new int[]{1,2,3,4};
		Version actual = new Version(initArray);

		Assert.assertEquals("Incorrect string concat",initArray[0],actual.toArray()[0]);
		Assert.assertEquals("Incorrect string concat",initArray[1],actual.toArray()[1]);
		Assert.assertEquals("Incorrect string concat",initArray[2],actual.toArray()[2]);
		Assert.assertEquals("Incorrect string concat",initArray[3],actual.toArray()[3]);
	}

	@Test
	public void testIsVersionOlderThan_greaterThanMjV() {

		int[] InitTarget = new int[]{2,1,1,1};
		Version target = new Version(InitTarget);

		int[] initArray = new int[]{1,1,1,1};
		Version version = new Version(initArray);

		Assert.assertTrue("Incorrect version oldness", version.isVersionOlderThan(target));
	}

	@Test
	public void testIsVersionOlderThan_greaterThanMvV() {

		int[] InitTarget = new int[]{1,2,1,1};
		Version target = new Version(InitTarget);

		int[] initArray = new int[]{1,1,1,1};
		Version version = new Version(initArray);

		Assert.assertTrue("Incorrect version oldness", version.isVersionOlderThan(target));
	}

	@Test
	public void testIsVersionOlderThan_greaterThanMjB() {

		int[] InitTarget = new int[]{1,1,2,1};
		Version target = new Version(InitTarget);

		int[] initArray = new int[]{1,1,1,1};
		Version version = new Version(initArray);

		Assert.assertTrue("Incorrect version oldness", version.isVersionOlderThan(target));
	}

	@Test
	public void testIsVersionOlderThan_greaterThanMvB() {

		int[] InitTarget = new int[]{1,1,1,2};
		Version target = new Version(InitTarget);

		int[] initArray = new int[]{1,1,1,1};
		Version version = new Version(initArray);

		Assert.assertTrue("Incorrect version oldness", version.isVersionOlderThan(target));
	}

	@Test
	public void testIsVersionOlderThan_equal() {

		int[] InitTarget = new int[]{1,1,1,1};
		Version target = new Version(InitTarget);

		int[] initArray = new int[]{1,1,1,1};
		Version version = new Version(initArray);

		Assert.assertFalse("Incorrect version oldness", version.isVersionOlderThan(target));
	}

	@Test
	public void testIsVersionOlderThan_lessThanMjV() {

		int[] InitTarget = new int[]{1,1,1,1};
		Version target = new Version(InitTarget);

		int[] initArray = new int[]{2,1,1,1};
		Version version = new Version(initArray);

		Assert.assertFalse("Incorrect version oldness", version.isVersionOlderThan(target));
	}

	@Test
	public void testIsVersionOlderThan_lessThanMvV() {

		int[] InitTarget = new int[]{1,1,1,1};
		Version target = new Version(InitTarget);

		int[] initArray = new int[]{1,2,1,1};
		Version version = new Version(initArray);

		Assert.assertFalse("Incorrect version oldness", version.isVersionOlderThan(target));
	}

	@Test
	public void testIsVersionOlderThan_lessThanMjB() {

		int[] InitTarget = new int[]{1,1,1,1};
		Version target = new Version(InitTarget);

		int[] initArray = new int[]{1,1,2,1};
		Version version = new Version(initArray);

		Assert.assertFalse("Incorrect version oldness", version.isVersionOlderThan(target));
	}

	@Test
	public void testIsVersionOlderThan_lessThanMvB() {

		int[] InitTarget = new int[]{1,1,1,1};
		Version target = new Version(InitTarget);

		int[] initArray = new int[]{1,1,1,2};
		Version version = new Version(initArray);

		Assert.assertFalse("Incorrect version oldness", version.isVersionOlderThan(target));
	}
}
