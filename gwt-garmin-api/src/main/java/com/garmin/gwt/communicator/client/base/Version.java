package com.garmin.gwt.communicator.client.base;

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
