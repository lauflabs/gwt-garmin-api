package com.garmin.gwt.client.base;

import java.util.ArrayList;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

/**
 * Encapsulates the data provided by the device for the current process'
 * progress.
 * 
 * @author Joseph Lust
 * 
 */
public class TransferProgress {
	private int percentage;
	private String title;
	private String[] text;
	private boolean hasPercentage; // whether the value has been set

	/**
	 * @param percentage
	 * @param title
	 * @param text
	 */
	public TransferProgress(int percentage, String title, String[] text) {
		super();
		this.percentage = percentage;
		this.title = title;
		this.text = text;

		hasPercentage = true;
	}

	/**
	 * Populate using the string from {@link DevicePlugin.getProgressXml()}
	 * 
	 * @param progressXml
	 */
	public TransferProgress(String progressXml) {
		setFromProgressXml(progressXml);
	}

	/**
	 * The percentage,<br>
	 * <b>NOTE:</b> Check getHasPercentage() to determine if this progress state uses percentage
	 * @return defaults to 0.
	 */
	public final int getPercentage() {
		return percentage;
	}

	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * @return the hasPercentage
	 */
	public final boolean hasPercentage() {
		return hasPercentage;
	}

	/**
	 * @return the text
	 */
	public final String[] getText() {
		return text;
	}

	/**
	 * Parse all values out from XML progress string
	 */
	private void setFromProgressXml(String progressXml) {
		Document dom = XMLParser.parse(progressXml);

		/** Title **/
		Node titleNode = dom.getElementsByTagName("Title").item(0);
		title = ((Element)titleNode).getFirstChild().getNodeValue();

		/** Percentage **/
		NodeList progressBarNodeList = dom.getElementsByTagName("ProgressBar");
		// not sure why the API reference impl does this check, so doing it for safety sake
		if(progressBarNodeList.getLength()>0) {
			Node progressBarNode = progressBarNodeList.item(0);
			String progressType = ((Element)progressBarNode).getAttribute("Type");

			// two possible type of processes, if neither, is NULL
			if("percentage".equalsIgnoreCase(progressType)) {
				percentage = Integer.parseInt( ((Element)progressBarNode).getAttribute("Value") );
				hasPercentage = true;
			}
			else if("indefinite".equalsIgnoreCase(progressType)) {
				percentage = 100;
				hasPercentage = true;
			}
		}

		/** Text **/
		ArrayList<String> textList = new ArrayList<String>();
		NodeList textNodeList = dom.getElementsByTagName("Text");

		if(textNodeList.getLength()>0) { // for speed during rapid calls

			for(int n=0; n<textNodeList.getLength(); n++) {

				Node textNode = textNodeList.item(n);
				if(textNode.hasChildNodes()) {
					String text = textNode.getFirstChild().getNodeValue();
					if(!text.isEmpty()) {
						textList.add(text);
					}
				}
			}
			text = textList.toArray(new String[]{});
		}
	}

	@Override
	public String toString() {
		String progressString = "";
		if(title!= null) {
			progressString += title;
		}
		if(hasPercentage) {
			progressString += ": " + percentage + "%";
		}
		return progressString;
	}

}
