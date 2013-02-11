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


import com.garmin.gwt.communicator.client.objs.TestParserFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;

public class TestParserFactoryGwtTest extends GWTTestCase {

	private TestParserFactory p;

	@Override
	public String getModuleName() {
		return "com.garmin.gwt.communicator.Communicator";
	}

	@Override
	protected boolean supportsAsync() {
		return false;
	}

	@Override
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		p = GWT.create(TestParserFactory.class);
	}

	public void testParseRoot() {
		SharedTests.testParseRoot(p);
	}

	public void testParseBadRoot() {
		SharedTests.testParseBadRoot(p);
	}

	public void testParseMisnamedRoot() {
		SharedTests.testParseMisnamedRoot(p);
	}

	public void testParsePublicAttribute() {
		SharedTests.testParsePublicAttribute(p);
	}

	public void testParseRenamedProtectedAttribute() {
		SharedTests.testParseRenamedProtectedAttribute(p);
	}

	public void testParsePrivateAttribute() {
		SharedTests.testParsePrivateAttribute(p);
	}

	public void testParseTypedAttribute() {
		SharedTests.testParseTypedAttribute(p);
	}

	public void testParseSubObjectAttribute() {
		SharedTests.testParseSubObjectAttribute(p);
	}

	public void testParseSubObjectList() {
		SharedTests.testParseSubObjectList(p);
	}

	public void testParseSubObjectPolymorphicList() {
		SharedTests.testParseSubObjectPolymorphicList(p);
	}

	public void testParseTransientAttribute() {
		SharedTests.testParseTransientAttribute(p);
	}

	public void testParseValueAttribute() {
		SharedTests.testParseValueAttribute(p);
	}

	public void testParseNamedSubObjectPolymorphicList() {
		SharedTests.testParseNamedSubObjectPolymorphicList(p);
	}

	public void testParseStringElement() {
		SharedTests.testParseStringElement(p);
	}

	public void testParseElementEnum() {
		SharedTests.testParseElementEnum(p);
	}

	public void testParseAttributeEnum() {
		SharedTests.testParseAttributeEnum(p);
	}

	public void testPolymprohicElement() {
		SharedTests.testPolymprohicElement(p);
	}

	public void testListStringElement() {
		SharedTests.testListStringElement(p);
	}

}
