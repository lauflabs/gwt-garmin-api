package com.garmin.gwt.client.base;

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
