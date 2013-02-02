package com.garmin.gwt.client.base;

import junit.framework.Assert;

import com.garmin.gwt.client.testutil.AbstractGwtTestUtil;

/**
 * Test TransferProgress
 * 
 * @author Joseph Lust
 * 
 */
public class TransferProgressTest extends AbstractGwtTestUtil {

	public void testToString() {
		String[] mockText = new String[]{"Buy","Shaving","Cream"};
		TransferProgress prog = new TransferProgress(24,"Foo Title",mockText);

		String expected = "Foo Title: 24%";
		String actual = prog.toString();
		Assert.assertEquals("Incorrect toString() output", expected, actual);
	}

	public void testToString_no_percentage() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>Foo Title</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Foo\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = new TransferProgress(mockXml);

		String expected = "Foo Title";
		Assert.assertEquals("Incorrect tostring() output", expected, prog.toString());
	}

	public void testToString_no_title() {
		String[] mockText = new String[]{"Buy","Shaving","Cream"};
		String mockTitle = null;
		TransferProgress prog = new TransferProgress(24,mockTitle, mockText);

		String expected = ": 24%";
		Assert.assertEquals("Incorrect tostring() output", expected, prog.toString());
	}

	public void testXmlConstructor() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>GarminPlugin Status not yet implemented</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Percentage\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = new TransferProgress(mockXml);

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
		TransferProgress prog = new TransferProgress(mockXml);

		int expectedPercentage = 100;
		Assert.assertTrue("Percentage set flag should be set",prog.hasPercentage());
		Assert.assertEquals("Incorrectly parsed xml percentage", expectedPercentage, prog.getPercentage());
	}

	public void testXmlConstructor_no_percentage() {
		String mockXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?><ProgressWidget xmlns=\"http://www.garmin.com/xmlschemas/PluginAPI/v1\"><Title>GarminPlugin Status not yet implemented</Title><Text></Text><Text></Text><Text>0% complete</Text><ProgressBar Type=\"Foo\" Value=\"33\"/></ProgressWidget>";
		TransferProgress prog = new TransferProgress(mockXml);

		int expectedPercentage = 0;
		Assert.assertFalse("Percentage set flag should NOT be set",prog.hasPercentage());
		Assert.assertEquals("Incorrectly parsed xml percentage", expectedPercentage, prog.getPercentage());
	}
}
