package com.garmin.gwt.communicator.client.xml;

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

import com.garmin.gwt.communicator.client.gpx.ExtensionsType;
import com.garmin.gwt.communicator.client.gpx.Gpx;
import com.garmin.gwt.communicator.client.gpx.MetadataType;
import com.garmin.gwt.communicator.client.gpx.Route;
import com.garmin.gwt.communicator.client.gpx.Track;
import com.garmin.gwt.communicator.client.gpx.WayPoint;
import com.garmin.gwt.communicator.client.jaxb.JAXBBindings;
import com.garmin.gwt.communicator.client.jaxb.JAXBParserFactory;


@JAXBBindings(value=Gpx.class, objects={WayPoint.class, Route.class,Track.class,ExtensionsType.class,String.class,MetadataType.class})
public interface GpxParserFactory extends JAXBParserFactory<Gpx	>{}
