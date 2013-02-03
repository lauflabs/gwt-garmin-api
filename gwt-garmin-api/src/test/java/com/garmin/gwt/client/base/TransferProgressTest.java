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
