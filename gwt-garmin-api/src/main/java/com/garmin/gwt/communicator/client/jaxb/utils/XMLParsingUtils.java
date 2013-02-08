package com.garmin.gwt.communicator.client.jaxb.utils;

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

import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NodeList;


public class XMLParsingUtils {

	public static Element getNamedChild(Element e, String name) {
		NodeList l = e.getChildNodes();
		for(int i = 0; i < l.getLength(); i++) {
			if(l.item(i) instanceof Element) {
				Element n = (Element)l.item(i);
				if(n.getNodeName().equals(name)) {
					return n;
				}
			}
		}
		return null;
	}

	public static boolean hasNamedChild(Element e, String name) {
		NodeList l = e.getChildNodes();
		for(int i = 0; i < l.getLength(); i++) {
			if(l.item(i) instanceof Element) {
				Element n = (Element)l.item(i);
				if(n.getNodeName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	public static <E> ArrayList<E> buildNamedElements(Element e, String name, XMLNodeFactory<E> factory) {
		ArrayList<E> list = new ArrayList<E>();
		NodeList l = e.getChildNodes();
		for(int i = 0; i < l.getLength(); i++) {
			if(l.item(i) instanceof Element) {
				Element n = (Element)l.item(i);
				if(n.getNodeName().equals(name)) {
					E fn = factory.build(n);
					if(fn != null) {
						list.add(fn);
					}
				}
			}
		}
		return list;
	}

	public static <E> E buildNamedElement(Element e, String name, XMLNodeFactory<E> factory) {
		NodeList l = e.getChildNodes();
		for(int i = 0; i < l.getLength(); i++) {
			if(l.item(i) instanceof Element) {
				Element n = (Element)l.item(i);
				if(n.getNodeName().equals(name)) {
					E fn = factory.build(n);
					if(fn != null) {
						return fn;
					}
				}
			}
		}
		return null;
	}

	public static String getNodeText(Element e) {
		if(e == null)  return "";
		NodeList nodes = e.getChildNodes();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < nodes.getLength(); i++) {
			result.append(nodes.item(i).getNodeValue());
		}
		return result.toString();
	}

}
