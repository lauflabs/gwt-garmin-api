package com.garmin.gwt.client.base;


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
	 * @param hasPercentage set to false if percentage does not apply
	 */
	public TransferProgress(String title, String[] text, int percentage, boolean hasPercentage) {
		super();
		this.percentage = percentage;
		this.title = title;
		this.text = text;
		this.hasPercentage = hasPercentage;
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
