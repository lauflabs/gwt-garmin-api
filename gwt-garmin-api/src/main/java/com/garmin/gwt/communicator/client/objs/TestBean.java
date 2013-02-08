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


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.garmin.gwt.communicator.client.objs.JAXBExamples.TESTENUM;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TestBean {



	@XmlAttribute
	public String attrone;

	@XmlAttribute(name="attrtwo")
	protected String attr2;

	@XmlAttribute
	private String attrthree;

	@XmlAttribute
	public int attrint;

	@XmlAttribute
	public Integer attrinteger;

	@XmlAttribute
	public long attrlong;

	@XmlAttribute
	public Long attrLong;

	@XmlAttribute
	public short attrshort;

	@XmlAttribute
	public Short attrShort;

	@XmlAttribute
	public float attrfloat;

	@XmlAttribute
	public Float attrFloat;

	@XmlAttribute
	public double attrdouble;

	@XmlAttribute
	public Double attrDouble;

	@XmlAttribute
	public boolean attrboolean;

	@XmlAttribute
	public Boolean attrBoolean;

	@XmlElement
	public TestSubObject publicSubObject;

	@XmlElement
	public ArrayList<TestSubObject> objectList;

	@XmlElement
	public ArrayList<TestSubObject> namedList;

	@XmlElement
	public ArrayList<String> stringsList;

	@XmlTransient
	public String transfield;

	@XmlElement
	public TestStringValue value;

	@XmlAttribute
	public TESTENUM attrEnum;

	@XmlElement
	public TESTENUM elemEnum;

	@XmlElement
	public String elemString;

	@XmlElement
	public TestAbstObject abstractObj;

	public String getAttr2() {
		return attr2;
	}

	public String getAttrthree() {
		return attrthree;
	}

	public void setAttrthree(String attrthree) {
		this.attrthree = attrthree;
	}

}
