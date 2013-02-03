package com.garmin.gwt.client.util;

import junit.framework.Assert;

import com.garmin.gwt.client.base.Device;
import com.garmin.gwt.client.base.TransferProgress;
import com.garmin.gwt.client.testutil.AbstractGwtTestUtil;

/**
 * Test PluginUtils
 * 
 * @author Joseph Lust
 * 
 */
public class PluginUtilsTest extends AbstractGwtTestUtil {

	public void testToString_no_percentage() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>Foo Title</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Foo\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = PluginUtils.parseProgressXml(mockXml);

		String expected = "Foo Title";
		Assert.assertEquals("Incorrect tostring() output", expected, prog.toString());
	}

	public void testXmlConstructor() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>GarminPlugin Status not yet implemented</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Percentage\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = PluginUtils.parseProgressXml(mockXml);

		String expected = "GarminPlugin Status not yet implemented";
		Assert.assertEquals("Incorrectly parsed xml title", expected, prog.getTitle());

		expected = "0% complete";
		Assert.assertTrue("Only one text string should appear in output", prog.getText().length==1);
		Assert.assertEquals("Incorrectly parsed xml title", expected, prog.getText()[0]);

		int expectedPercentage = 33;
		Assert.assertTrue("Percentage set flag should be set",prog.hasPercentage());
		Assert.assertEquals("Incorrectly parsed xml percentage", expectedPercentage, prog.getPercentage());
	}

	public void testXmlConstructor_indefinite_percentage() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>GarminPlugin Status not yet implemented</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Indefinite\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = PluginUtils.parseProgressXml(mockXml);

		int expectedPercentage = 100;
		Assert.assertTrue("Percentage set flag should be set",prog.hasPercentage());
		Assert.assertEquals("Incorrectly parsed xml percentage", expectedPercentage, prog.getPercentage());
	}

	public void testXmlConstructor_no_percentage() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>GarminPlugin Status not yet implemented</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Foo\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = PluginUtils.parseProgressXml(mockXml);

		int expectedPercentage = 0;
		Assert.assertFalse("Percentage set flag should NOT be set",prog.hasPercentage());
		Assert.assertEquals("Incorrectly parsed xml percentage", expectedPercentage, prog.getPercentage());
	}

	public void testParseDeviceXml() {
		String mockDeviceXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><Devices xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Device DisplayName=\"Forerunner305 Software Version 2.90\" Number=\"4\" /></Devices>";
		Device[] deviceList = PluginUtils.parseDeviceXml(mockDeviceXml);

		Assert.assertTrue("Should only have been a single parsed device", deviceList.length==1);

		String expected = "Forerunner305 Software Version 2.90";
		Assert.assertEquals("Incorrect displayName value parsed", expected, deviceList[0].getDisplayName());

		int expectedNumber = 4;
		Assert.assertEquals("Incorrect deviceNumber value parsed", expectedNumber, deviceList[0].getNumber());
	}

	public void testParseDeviceXml_several_devices() {
		String mockDeviceXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><Devices xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Device DisplayName=\"Forerunner305 Software Version 2.90\" Number=\"0\" /><Device DisplayName=\"Forerunner303 Software Version 2.90\" Number=\"1\" /><Device DisplayName=\"Forerunner405 Software Version 2.90\" Number=\"2\" /></Devices>";
		Device[] deviceList = PluginUtils.parseDeviceXml(mockDeviceXml);

		Assert.assertTrue("Wrong number of devices parsed", deviceList.length==3);

		String expected = "Forerunner305 Software Version 2.90";
		Assert.assertEquals("Incorrect displayName value parsed", expected, deviceList[0].getDisplayName());
		expected = "Forerunner303 Software Version 2.90";
		Assert.assertEquals("Incorrect displayName value parsed", expected, deviceList[1].getDisplayName());
		expected = "Forerunner405 Software Version 2.90";
		Assert.assertEquals("Incorrect displayName value parsed", expected, deviceList[2].getDisplayName());

		Assert.assertEquals("Incorrect deviceNumber value parsed", 0, deviceList[0].getNumber());
		Assert.assertEquals("Incorrect deviceNumber value parsed", 1, deviceList[1].getNumber());
		Assert.assertEquals("Incorrect deviceNumber value parsed", 2, deviceList[2].getNumber());
	}

	public void testParseDeviceXml_empty() {
		String mockDeviceXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><Devices xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\" />";
		Device[] deviceList = PluginUtils.parseDeviceXml(mockDeviceXml);

		Assert.assertTrue("Device list should be empty", deviceList.length==0);
	}

}
