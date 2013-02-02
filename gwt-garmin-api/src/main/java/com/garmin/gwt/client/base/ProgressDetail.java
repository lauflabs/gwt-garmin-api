package com.garmin.gwt.client.base;

/**
 * Details of process
 * 
 * @author Joseph Lust
 * 
 */
public final class ProgressDetail {

	private String message;
	private double percent;

	/**
	 * @param message
	 * @param percent
	 */
	public ProgressDetail(String message, double percent) {
		super();
		this.message = message;
		this.percent = percent;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @return the percent
	 */
	public final double getPercent() {
		return percent;
	}



}
