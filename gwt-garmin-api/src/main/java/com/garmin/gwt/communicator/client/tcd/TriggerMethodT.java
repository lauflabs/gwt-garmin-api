//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.06 at 11:45:40 PM EST 
//


package com.garmin.gwt.communicator.client.tcd;

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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TriggerMethod_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TriggerMethod_t">
 *   &lt;restriction base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Token_t">
 *     &lt;enumeration value="Manual"/>
 *     &lt;enumeration value="Distance"/>
 *     &lt;enumeration value="Location"/>
 *     &lt;enumeration value="Time"/>
 *     &lt;enumeration value="HeartRate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TriggerMethod_t")
@XmlEnum
public enum TriggerMethodT {

    @XmlEnumValue("Manual")
    MANUAL("Manual"),
    @XmlEnumValue("Distance")
    DISTANCE("Distance"),
    @XmlEnumValue("Location")
    LOCATION("Location"),
    @XmlEnumValue("Time")
    TIME("Time"),
    @XmlEnumValue("HeartRate")
    HEART_RATE("HeartRate");
    private final String value;

    TriggerMethodT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TriggerMethodT fromValue(String v) {
        for (TriggerMethodT c: TriggerMethodT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
