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
