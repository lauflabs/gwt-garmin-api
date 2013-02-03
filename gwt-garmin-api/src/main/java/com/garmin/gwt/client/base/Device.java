package com.garmin.gwt.client.base;

/**
 * POJO for the Device return information from the API
 * 
 * @author Joseph Lust
 * 
 */
public class Device {

	private String displayName;
	private int number;
	private String softwareVersion;

	/**
	 * @param displayName
	 * @param number
	 */
	public Device(String displayName, int number) {
		super();
		this.displayName = displayName;
		this.number = number;
	}

	/**
	 * @return the displayName
	 */
	public final String getDisplayName() {
		return displayName;
	}

	/**
	 * @return the number
	 */
	public final int getNumber() {
		return number;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Device [displayName=" + displayName + ", number=" + number
				+ ", softwareVersion=" + softwareVersion + "]";
	}

}
