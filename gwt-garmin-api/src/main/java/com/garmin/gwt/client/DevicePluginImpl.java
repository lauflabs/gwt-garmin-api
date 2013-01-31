package com.garmin.gwt.client;

/*
 * #%L
 * GWT Maps API V3 - Core API
 * %%
 * Copyright (C) 2011 - 2012 GWT Maps API V3
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

import com.google.gwt.dom.client.Element;

/**
 * Creates a new map inside of the given HTML container, which is typically a DIV element <br>
 * <br>
 * See <a href= "https://developers.google.com/maps/documentation/javascript/reference#Map" >Map API Doc</a>
 */
public class DevicePluginImpl {

  /**
   * Creates a new map inside of the given HTML container, which is typically a DIV element.
   */
  protected DevicePluginImpl() {
  }

  /**
   * Creates a new map inside of the given HTML container, which is typically a DIV element.
   * 
   * @param element - map dom element container, like a div
   * @param options - {@link MapOptions}
   * @return {@link Garmin}
   */
  public final static DevicePluginImpl newInstance(Element element) {
    return createJso(element);
  }

  /**
   * private native method
   * 
   * @param id - dom element id
   * @param {@link MapOptions}
   */
  private final static native DevicePluginImpl createJso(Element element) /*-{
    return new $wnd.google.maps.Map(element);
  }-*/;

  /**
   * Get map's containing element
   */
  public final native Element getDiv() /*-{
    return this.getDiv();
  }-*/;

}
