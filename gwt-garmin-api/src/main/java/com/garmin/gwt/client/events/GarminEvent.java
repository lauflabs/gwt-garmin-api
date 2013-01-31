package com.garmin.gwt.client.events;

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

import com.google.gwt.event.shared.GwtEvent;

/**
 * Inherit this into unique Map Event
 * 
 * @param <H> {@link MapHandler}
 * @param <E> {@link GarminEvent}
 */
public abstract class GarminEvent<H extends GarminEventHandler<E>, E> extends GwtEvent<H> {

  /**
   * properties from the map event call back {@link com.google.gwt.ajaxloader.client.Properties}
   */
  protected Object data;

  /**
   * create a new map event
   * 
   * @param properties
   */
  public GarminEvent(Object data) {
    this.data = data;
  }

  /**
   * get the raw properties
   * 
   * @return {@link com.google.gwt.ajaxloader.client.Properties}
   */
  public Object getData() {
    return data;
  }

  /**
   * implement in the event that inherits this
   */
  @Override
  protected abstract void dispatch(H handler);

}
