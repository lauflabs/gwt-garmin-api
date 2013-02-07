package com.garmin.gwt.communicator.client.data;

import java.util.ArrayList;

/**
 * Fitness activity information POJO
 * 
 * @author Joseph Lust
 * 
 */
public final class Activity {

	static enum Type {
		RUNNING,
		BIKING,
		OTHER,
		MULTISPORT,
		EXTENSIONS
	}

	private Type sport;
	private ArrayList<Lap> laps;
	private String notes;
	//private Trainining training;
	//private Creator creator;
}
