package com.garmin.gwt.client.base;

/**
 * POJO to encapsulate version information
 * 
 * @author Joseph Lust
 */
public final class Version {
	private int versionMajor;
	private int versionMinor;
	private int buildMajor;
	private int buildMinor;

	/**
	 * @param versionMajor
	 * @param versionMinor
	 * @param buildMajor
	 * @param buildMinor
	 */
	public Version(int versionMajor, int versionMinor, int buildMajor,
			int buildMinor) {
		super();
		this.versionMajor = versionMajor;
		this.versionMinor = versionMinor;
		this.buildMajor = buildMajor;
		this.buildMinor = buildMinor;
	}

	/**
	 * Initialize with an array of versions
	 * 
	 * @param versions
	 *            four elements, cannot be null
	 */
	public Version(int[] versions) {
		super();
		assert versions.length == 4 : "Versions array must have four elements";
		versionMajor = versions[0];
		versionMinor = versions[1];
		buildMajor = versions[2];
		buildMinor = versions[3];
	}

	/**
	 * @return the versionMajor
	 */
	public final int getVersionMajor() {
		return versionMajor;
	}

	/**
	 * @return the versionMinor
	 */
	public final int getVersionMinor() {
		return versionMinor;
	}

	/**
	 * @return the buildMajor
	 */
	public final int getBuildMajor() {
		return buildMajor;
	}

	/**
	 * @return the buildMinor
	 */
	public final int getBuildMinor() {
		return buildMinor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return versionMajor + "." + versionMinor + "." + buildMajor + "."
				+ buildMinor;
	}

	/**
	 * Convert to array
	 * 
	 * @return four element array
	 */
	public final int[] toArray() {
		return new int[] { versionMajor, versionMinor, buildMajor, buildMinor };
	}

}
