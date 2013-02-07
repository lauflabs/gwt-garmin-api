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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Version_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Version_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VersionMajor" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="VersionMinor" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="BuildMajor" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="BuildMinor" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Version_t", propOrder = {
    "versionMajor",
    "versionMinor",
    "buildMajor",
    "buildMinor"
})
public class VersionT {

    @XmlElement(name = "VersionMajor")
    @XmlSchemaType(name = "unsignedShort")
    protected int versionMajor;
    @XmlElement(name = "VersionMinor")
    @XmlSchemaType(name = "unsignedShort")
    protected int versionMinor;
    @XmlElement(name = "BuildMajor")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer buildMajor;
    @XmlElement(name = "BuildMinor")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer buildMinor;

    /**
     * Gets the value of the versionMajor property.
     * 
     */
    public int getVersionMajor() {
        return versionMajor;
    }

    /**
     * Sets the value of the versionMajor property.
     * 
     */
    public void setVersionMajor(int value) {
        this.versionMajor = value;
    }

    /**
     * Gets the value of the versionMinor property.
     * 
     */
    public int getVersionMinor() {
        return versionMinor;
    }

    /**
     * Sets the value of the versionMinor property.
     * 
     */
    public void setVersionMinor(int value) {
        this.versionMinor = value;
    }

    /**
     * Gets the value of the buildMajor property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBuildMajor() {
        return buildMajor;
    }

    /**
     * Sets the value of the buildMajor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBuildMajor(Integer value) {
        this.buildMajor = value;
    }

    /**
     * Gets the value of the buildMinor property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBuildMinor() {
        return buildMinor;
    }

    /**
     * Sets the value of the buildMinor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBuildMinor(Integer value) {
        this.buildMinor = value;
    }

}
