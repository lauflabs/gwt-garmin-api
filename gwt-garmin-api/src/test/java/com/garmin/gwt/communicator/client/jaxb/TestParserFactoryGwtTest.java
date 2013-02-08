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
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		p = GWT.create(TestParserFactory.class);
	}

	public void testParseRoot() {
		MututalTests.testParseRoot(p);
	}

	public void testParseBadRoot() {
		MututalTests.testParseBadRoot(p);
	}

	public void testParseMisnamedRoot() {
		MututalTests.testParseMisnamedRoot(p);
	}

	public void testParsePublicAttribute() {
		MututalTests.testParsePublicAttribute(p);
	}

	public void testParseRenamedProtectedAttribute() {
		MututalTests.testParseRenamedProtectedAttribute(p);
	}

	public void testParsePrivateAttribute() {
		MututalTests.testParsePrivateAttribute(p);
	}

	public void testParseTypedAttribute() {
		MututalTests.testParseTypedAttribute(p);
	}

	public void testParseSubObjectAttribute() {
		MututalTests.testParseSubObjectAttribute(p);
	}

	public void testParseSubObjectList() {
		MututalTests.testParseSubObjectList(p);
	}

	public void testParseSubObjectPolymorphicList() {
		MututalTests.testParseSubObjectPolymorphicList(p);
	}

	public void testParseTransientAttribute() {
		MututalTests.testParseTransientAttribute(p);
	}

	public void testParseValueAttribute() {
		MututalTests.testParseValueAttribute(p);
	}

	public void testParseNamedSubObjectPolymorphicList() {
		MututalTests.testParseNamedSubObjectPolymorphicList(p);
	}

	public void testParseStringElement() {
		MututalTests.testParseStringElement(p);
	}

	public void testParseElementEnum() {
		MututalTests.testParseElementEnum(p);
	}

	public void testParseAttributeEnum() {
		MututalTests.testParseAttributeEnum(p);
	}

	public void testPolymprohicElement() {
		MututalTests.testPolymprohicElement(p);
	}

	public void testListStringElement() {
		MututalTests.testListStringElement(p);
	}

}
