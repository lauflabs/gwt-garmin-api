package com.garmin.gwt.communicator.client.data;

import java.util.Date;

/**
 * Fitness lap information POJO
 * 
 * @author Joseph Lust
 * 
 */
public final class Lap {

	private String id;
	private Date startTime;

	// NOTE: double, rather than XSD specifics since JS only uses 64bit doubles internally
	private double totalTimeSeconds;
	private double distanceMeters;
	private double maximumSpeed;
	private double calories;
	private double averageHeartRateBpm;
	private double maximumHeartRateBpm;
	private String notes;

	//private ArrayList<Track> tracks;

}
