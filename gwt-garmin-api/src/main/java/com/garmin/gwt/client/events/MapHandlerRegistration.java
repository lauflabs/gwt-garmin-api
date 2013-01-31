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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;

public class MapHandlerRegistration {

  /**
   * event handler
   * 
   * @param jso
   * @param eventType
   * @param handler
   * @param formatter
   */
  @SuppressWarnings("rawtypes")
  // is ugly, but is a cyclic generic type, so suppressed
  public static <E extends GarminEvent> HandlerRegistration addHandler(JavaScriptObject jso, GarminEventType eventType,
      GarminEventHandler<E> handler, EventFormatter<E> formatter) {
    final JavaScriptObject listener = addHandlerImpl(jso, eventType.value(), handler, formatter);
    HandlerRegistration registration = new HandlerRegistration() {
      @Override
      public void removeHandler() {
        removeHandlerImpl(listener);
      }
    };
    return registration;
  }

  /**
   * process the callback and send it to the handler
   * 
   * @param jso
   * @param eventName
   * @param handler
   * @param formatter
   */
  @SuppressWarnings("rawtypes")
  // is ugly, but is a cyclic generic type, so suppressed
  private static native <E extends GarminEvent> JavaScriptObject addHandlerImpl(JavaScriptObject jso, String eventName,
		  GarminEventHandler<E> handler, EventFormatter<E> formatter) /*-{
    var callback = function(event) {
      $entry(@com.google.gwt.maps.client.events.MapHandlerRegistration::onCallback(Lcom/google/gwt/maps/client/events/MapHandler;Lcom/google/gwt/ajaxloader/client/Properties;Lcom/google/gwt/maps/client/events/MapEventFormatter;)(handler, event, formatter));
    };
    return $wnd.google.maps.event.addListener(jso, eventName, callback)
  }-*/;

  /**
   * HandlerRegistration call when finished
   * 
   * @param listener
   */
  private static native void removeHandlerImpl(JavaScriptObject listener) /*-{
    $wnd.google.maps.event.removeListener(listener);
  }-*/;


}
