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
 * POJO for api key pair<br>
 * i.e.
 * <code>KeyPair("http://foo.com","45517b532362fc3149e4211ade14c9b2")</code>
 * 
 * @author Joseph Lust
 * 
 */
public class KeyPair {

	private String url;
	private String key;

	/**
	 * @param url
	 * @param key
	 */
	public KeyPair(String url, String key) {
		super();
		this.url = url;
		this.key = key;
	}

	/**
	 * @return the url
	 */
	public final String getUrl() {
		return url;
	}

	/**
	 * @return the key
	 */
	public final String getKey() {
		return key;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KeyPair [url=" + url + ", key=" + key + "]";
	}

}
