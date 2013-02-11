package com.garmin.gwt.communicator.client.jaxb;

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

import com.garmin.gwt.communicator.client.objs.JAXBExamples.TESTENUM;
import com.garmin.gwt.communicator.client.objs.TestBean;
import com.garmin.gwt.communicator.client.objs.TestImplObject;
import com.garmin.gwt.communicator.client.objs.TestParserFactory;
import com.garmin.gwt.communicator.client.objs.TestSubNamedObject;
import com.garmin.gwt.communicator.client.objs.TestSubObjectChild;

/**
 * Tests shared by GWT side code and pure Java tests.
 **/
public class SharedTests {

	public static void testParseRoot(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean />");
		Assert.assertNotNull(bean);
	}

	public static void testParseBadRoot(TestParserFactory p) {
		try {
			p.create().parse("<TestBeanBadRoot");
			Assert.assertTrue("test should not have reached this point",false);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}

	public static void testParseMisnamedRoot(TestParserFactory p) {
		try {
			p.create().parse("<TestBeanBadName />");
			Assert.assertTrue("test should not have reached this point",false);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}

	public static void testParsePublicAttribute(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean attrone=\"passed\"/>");
		Assert.assertNotNull(bean);
		Assert.assertEquals("passed", bean.attrone);
	}

	public static void testParseRenamedProtectedAttribute(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean attrtwo=\"passed\"/>");
		Assert.assertNotNull(bean);
		Assert.assertEquals("passed", bean.getAttr2());
	}

	public static void testParsePrivateAttribute(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean attrthree=\"passed\"/>");
		Assert.assertNotNull(bean);
		Assert.assertEquals("passed", bean.getAttrthree());
	}

	public static void testParseTypedAttribute(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean attrint=\"1\" attrinteger=\"2\"/>");
		Assert.assertNotNull(bean);
		Assert.assertEquals(1, bean.attrint);
		Assert.assertEquals(2, bean.attrinteger.intValue());
	}

	public static void testParseSubObjectAttribute(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean><publicSubObject attrone=\"passed\"/></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.publicSubObject);
		Assert.assertEquals("passed", bean.publicSubObject.attrone);
	}

	public static void testParseSubObjectList(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean><objectList attrone=\"passed1\"/><objectList attrone=\"passed2\"/><objectList attrone=\"passed3\"/></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.objectList);
		Assert.assertEquals(3, bean.objectList.size());
		Assert.assertEquals("passed1", bean.objectList.get(0).attrone);
		Assert.assertEquals("passed2", bean.objectList.get(1).attrone);
		Assert.assertEquals("passed3", bean.objectList.get(2).attrone);
	}

	public static void testParseSubObjectPolymorphicList(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean><objectList attrone=\"passed1\"/><objectList xsi:type=\"TestSubObjectChild\" attrtwo=\"passed3\" attrone=\"passed2\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.objectList);
		Assert.assertEquals(2, bean.objectList.size());
		Assert.assertEquals("passed1", bean.objectList.get(0).attrone);
		Assert.assertEquals("passed2", ((TestSubObjectChild)bean.objectList.get(1)).attrone);
		Assert.assertEquals("passed3", ((TestSubObjectChild)bean.objectList.get(1)).attrtwo);
	}

	public static void testParseTransientAttribute(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean transfield=\"false\"/>");
		Assert.assertNotNull(bean);
		Assert.assertNull(bean.transfield);
	}

	public static void testParseValueAttribute(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean><value encoded=\"true\">innervalue</value></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.value);
		Assert.assertTrue(bean.value.encoded);
		Assert.assertEquals("innervalue", bean.value.value);
	}

	public static void testParseNamedSubObjectPolymorphicList(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean><namedList xsi:type=\"namedObject\" objattr=\"passed3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.namedList);
		Assert.assertEquals(1, bean.namedList.size());
		Assert.assertEquals("passed3", ((TestSubNamedObject)bean.namedList.get(0)).objattr);
	}

	public static void testParseStringElement(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean><elemString>testString</elemString></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.elemString);
		Assert.assertEquals("testString", bean.elemString);
	}

	public static void testParseElementEnum(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean><elemEnum>VAL2</elemEnum></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.elemEnum);
		Assert.assertEquals(TESTENUM.VAL2, bean.elemEnum);
	}

	public static void testParseAttributeEnum(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean attrEnum=\"VAL2\"></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.attrEnum);
		Assert.assertEquals(TESTENUM.VAL2, bean.attrEnum);
	}

	public static void testPolymprohicElement(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean><abstractObj xsi:type=\"testImplObject\" val=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.abstractObj);
		Assert.assertTrue(bean.abstractObj instanceof TestImplObject);
		Assert.assertTrue(((TestImplObject)bean.abstractObj).val);
	}

	public static void testListStringElement(TestParserFactory p) {
		TestBean bean = p.create().parse("<testBean><abstractObj xsi:type=\"testImplObject\" val=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/><stringsList>test</stringsList><stringsList>test2</stringsList><stringsList>test3</stringsList></testBean>");
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.stringsList);
		Assert.assertEquals(3, bean.stringsList.size());
	}


}
