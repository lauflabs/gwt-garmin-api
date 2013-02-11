package com.garmin.gwt.communicator.client.util;

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

import com.garmin.gwt.communicator.client.base.Device;
import com.garmin.gwt.communicator.client.base.Model;
import com.garmin.gwt.communicator.client.request.TransferProgress;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

/**
 * Parsing helpers ToString
 * 
 * @author Joseph Lust
 * 
 */
public final class ParseUtils {

	/**
	 * Parse the DeviceXml string into an array of {@links Device} objects
	 * 
	 * @param progressXml
	 * @return empty array if none parsed
	 */
	public static TransferProgress parseProgressXml(final String progressXml) {
		Document dom = XMLParser.parse(progressXml);

		/** Title **/
		Node titleNode = dom.getElementsByTagName("Title").item(0);
		String title = ((Element) titleNode).getFirstChild().getNodeValue();

		/** Percentage **/
		int percentage = 0;
		boolean hasPercentage = false;

		NodeList progressBarNodeList = dom.getElementsByTagName("ProgressBar");
		// not sure why the API reference impl does this check, so doing it for
		// safety sake
		if (progressBarNodeList.getLength() > 0) {
			Node progressBarNode = progressBarNodeList.item(0);
			String progressType = ((Element) progressBarNode)
					.getAttribute("Type");

			// two possible type of processes, if neither, is NULL
			if ("percentage".equalsIgnoreCase(progressType)) {
				percentage = Integer.parseInt(((Element) progressBarNode)
						.getAttribute("Value"));
				hasPercentage = true;
			} else if ("indefinite".equalsIgnoreCase(progressType)) {
				percentage = 100;
				hasPercentage = true;
			}
		}

		/** Text **/
		String textArray[] = new String[] {};

		ArrayList<String> textList = new ArrayList<String>();
		NodeList textNodeList = dom.getElementsByTagName("Text");

		if (textNodeList.getLength() > 0) { // for speed during rapid calls

			for (int n = 0; n < textNodeList.getLength(); n++) {

				Node textNode = textNodeList.item(n);
				if (textNode.hasChildNodes()) {
					String nodeText = textNode.getFirstChild().getNodeValue();
					if (!nodeText.isEmpty()) {
						textList.add(nodeText);
					}
				}
			}
			textArray = textList.toArray(new String[] {});
		}

		return new TransferProgress(title, textArray, percentage, hasPercentage);
	}

	/**
	 * Parse the salient <a
	 * href="http://www.garmin.com/xmlschemas/GarminDevicev2.xsd">schema</a>
	 * values into the POJO.<br>
	 * <b>NOTE:</b> The reason for passing in the device is due to
	 * displayName/deviceNumber being absent from the device description XML.
	 * 
	 * @param device
	 *            existing device object
	 * @param deviceDescriptionXml
	 *            description to add to the device
	 * @return POJO, or NPE if invalid input provided
	 */
	public final static Device parseDeviceDescriptionXml(final Device device,
			final String deviceDescriptionXml) {

		Document dom = XMLParser.parse(deviceDescriptionXml);

		long id = getNodeValueLong(dom, "Id");
		String registrationCode = getNodeValueStringConditionally(dom, "RegistrationCode");
		String unlockCode	 = getNodeValueStringConditionally(dom, "Code");

		// model information
		String partNumber = getNodeValueStringConditionally(dom, "PartNumber");
		long softwareVersion = getNodeValueLong(dom, "SoftwareVersion");
		String description = getNodeValueStringConditionally(dom, "Description");
		String extensions = getNodeValueStringConditionally(dom, "Extensions");

		Model model = new Model(partNumber, softwareVersion, description, extensions);

		return new Device(device.getDisplayName(), device.getDeviceNumber(), model, id, registrationCode, unlockCode);
	}

	/**
	 * Parse the DeviceXml string into an array of {@links Device} objects
	 * 
	 * @param deviceXml
	 * @return empty array if none parsed
	 */
	public final static Device[] parseDeviceXml(final String deviceXml) {

		ArrayList<Device> deviceList = new ArrayList<Device>();

		// ensure no one sent an incomplete response to us - fail graceful
		if ((deviceXml != null) && !deviceXml.isEmpty()) {

			Document dom = XMLParser.parse(deviceXml);

			NodeList deviceNodes = dom.getElementsByTagName("Device");
			for (int n = 0; n < deviceNodes.getLength(); n++) {

				Node deviceNode = deviceNodes.item(n);

				// these items will always be there
				String displayName = getNodeAttributeString(deviceNode,
						"DisplayName");
				int deviceNumber = getNodeAttributeInt(deviceNode, "Number");

				Device device = new Device(displayName, deviceNumber);
				deviceList.add(device);
			}

			/*
			 * 
			 * String partNumber =
			 * dom.getElementsByTagName("PartNumber")[0].childNodes
			 * [0].nodeValue; String softwareVersion =
			 * dom.getElementsByTagName("SoftwareVersion"
			 * )[0].childNodes[0].nodeValue; String description =
			 * dom.getElementsByTagName
			 * ("Description")[0].childNodes[0].nodeValue; String id =
			 * dom.getElementsByTagName("Id")[0].childNodes[0].nodeValue;
			 * 
			 * device.setPartNumber(partNumber);
			 * device.setSoftwareVersion(softwareVersion);
			 * device.setDescription(description); device.setId(id);
			 * 
			 * String dataTypeList =
			 * dom.getElementsByTagName("MassStorageMode")[
			 * 0].getElementsByTagName("DataType"); String numOfDataTypes =
			 * dataTypeList.length;
			 * 
			 * for ( String j = 0; j < numOfDataTypes; j++ ) { String dataName =
			 * dataTypeList
			 * [j].getElementsByTagName("Name")[0].childNodes[0].nodeValue;
			 * String dataExt =
			 * dataTypeList[j].getElementsByTagName("FileExtension"
			 * )[0].childNodes[0].nodeValue;
			 * 
			 * String dataType = new Garmin.DeviceDataType(dataName, dataExt);
			 * String fileList = dataTypeList[j].getElementsByTagName("File");
			 * 
			 * String numOfFiles = fileList.length;
			 * 
			 * for ( String k = 0; k < numOfFiles; k++ ) { // Path is an
			 * optional element in the schema String pathList =
			 * fileList[k].getElementsByTagName("Path"); String transferDir =
			 * fileList
			 * [k].getElementsByTagName("TransferDirection")[0].childNodes
			 * [0].nodeValue;
			 * 
			 * if ((transferDir ==
			 * Garmin.DeviceControl.TRANSFER_DIRECTIONS.read)) {
			 * dataType.setReadAccess(true);
			 * 
			 * if (pathList.length > 0) { String filePath =
			 * pathList[0].childNodes[0].nodeValue;
			 * dataType.setReadFilePath(filePath); } } else if ((transferDir ==
			 * Garmin.DeviceControl.TRANSFER_DIRECTIONS.write)) {
			 * dataType.setWriteAccess(true);
			 * 
			 * if (pathList.length > 0) { String filePath =
			 * pathList[0].childNodes[0].nodeValue;
			 * dataType.setWriteFilePath(filePath); } } else if ((transferDir ==
			 * Garmin.DeviceControl.TRANSFER_DIRECTIONS.both)) {
			 * dataType.setReadAccess(true); dataType.setWriteAccess(true);
			 * 
			 * if (pathList.length > 0) { String filePath =
			 * pathList[0].childNodes[0].nodeValue;
			 * dataType.setReadFilePath(filePath);
			 * dataType.setWriteFilePath(filePath); } }
			 * 
			 * // Deprecated! Need to be removed at some point. if(
			 * pathList.length > 0) { String filePath =
			 * pathList[0].childNodes[0].nodeValue;
			 * dataType.setFilePath(filePath); }
			 * 
			 * // Identifier is optional String identifierList =
			 * fileList[k].getElementsByTagName("Identifier"); if(
			 * identifierList.length > 0) { String identifier =
			 * identifierList[0].childNodes[0].nodeValue;
			 * dataType.setIdentifier(identifier); } }
			 * device.addDeviceDataType(dataType); } }
			 */
		}

		return deviceList.toArray(new Device[] {});

	}

	/**
	 * Find the node and return its string value
	 * 
	 * @param dom
	 * @param tagname
	 * @return string value
	 */
	protected static String getNodeValueString(Document dom, String tagname) {
		Node node = dom.getElementsByTagName(tagname).item(0);
		String value = ((Element) node).getFirstChild().getNodeValue();
		return value;
	}

	/**
	 * Find the node and return its integer value
	 * 
	 * @param dom
	 * @param tagname
	 * @return integer value
	 */
	public static int getNodeValueInt(Document dom, String tagname) {
		return Integer.parseInt(getNodeValueString(dom, tagname));
	}

	/**
	 * Find the node and return its double value
	 * 
	 * @param dom
	 * @param tagname
	 * @return double value
	 */
	protected static long getNodeValueLong(Document dom, String tagname) {
		return Long.parseLong(getNodeValueString(dom, tagname));
	}

	/**
	 * Find the value in the node if it exists, otherwise return empty string
	 * 
	 * @param dom
	 * @param tagname
	 * @return contents, or EMPTY string
	 */
	protected static String getNodeValueStringConditionally(Document dom,
			String tagname) {
		NodeList nodeList = dom.getElementsByTagName(tagname);
		if(nodeList.getLength()>0) {
			Node node = nodeList.item(0);
			String value = ((Element) node).getFirstChild().getNodeValue();
			return value;
		}
		return "";
	}

	/**
	 * @return Get value from the node as a string.
	 * @param node
	 * @param tagname
	 */
	protected static String getNodeAttributeString(Node node, String tagname) {
		return ((Element) node).getAttribute(tagname);
	}

	/**
	 * Get named attribute from node and convert to int
	 * 
	 * @param node
	 * @param tagname
	 */
	protected static int getNodeAttributeInt(Node node, String tagname) {
		return Integer.parseInt(((Element) node).getAttribute(tagname));
	}
}
