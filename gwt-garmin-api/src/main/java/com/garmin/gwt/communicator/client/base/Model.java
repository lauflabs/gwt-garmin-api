package com.garmin.gwt.communicator.client.base;

/**
 * POJO to hold Garmin model device information<br>
 * Properties based on <a
 * href="http://www.garmin.com/xmlschemas/GarminDevicev2.xsd">Garmin
 * schema</a>.
 * 
 * @author Joseph Lust
 * 
 */
public class Model {

	private String partNumber;
	private long softwareVersion; // unsigned int
	private String description;
	private String extensions; // optional

	protected Model() {}

	/**
	 * Create populated, immutable Model POJO
	 * 
	 * @param partNumber
	 * @param softwareVersion
	 * @param description
	 * @param extensions
	 */
	public Model(final String partNumber, final long softwareVersion,
			final String description, final String extensions) {
		super();
		this.partNumber = partNumber;
		this.softwareVersion = softwareVersion;
		this.description = description;
		this.extensions = extensions;
	}

	/**
	 * @return the partNumber
	 */
	public final String getPartNumber() {
		return partNumber;
	}

	/**
	 * @return the softwareVersion
	 */
	public final long getSoftwareVersion() {
		return softwareVersion;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @return the extensions
	 */
	public final String getExtensions() {
		return extensions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Model [partNumber=" + partNumber + ", softwareVersion="
				+ softwareVersion + ", description=" + description
				+ ", extensions=" + extensions + "]";
	}

}
