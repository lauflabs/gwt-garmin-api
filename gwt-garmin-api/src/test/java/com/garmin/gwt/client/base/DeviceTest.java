package com.garmin.gwt.client.base;

import junit.framework.Assert;

import com.garmin.gwt.client.testutil.AbstractGwtTestUtil;

/**
 * Test Device POJO
 * 
 * @author Joseph Lust
 * 
 */
public class DeviceTest extends AbstractGwtTestUtil {

	public void testAccessors() {

		String mockName = "Foo name";
		int mockNumber = 5;
		Device device = new Device(mockName, mockNumber);

		Assert.assertEquals("Failed getter", mockName, device.getDisplayName());
		Assert.assertEquals("Failed getter", mockNumber, device.getNumber());
	}
}
