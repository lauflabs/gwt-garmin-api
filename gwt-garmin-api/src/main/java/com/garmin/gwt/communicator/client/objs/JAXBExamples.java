package com.garmin.gwt.communicator.client.objs;

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


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class JAXBExamples implements EntryPoint {

	public static enum TESTENUM {
		VAL1,
		VAL2,
		VAL3
	}

	@Override
	public void onModuleLoad() {
		TestParserFactory p = GWT.create(TestParserFactory.class);
		TestBean bean = p.create().parse("<TestBean />");
		System.out.println(bean);
		//		Element ele;
		//		ele.hasAttribute(name)

	}

}
