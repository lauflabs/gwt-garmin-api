//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.06 at 11:45:30 PM EST 
//


package com.garmin.gwt.communicator.client.device;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransferDirection_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransferDirection_t">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="InputOutput"/>
 *     &lt;enumeration value="InputToUnit"/>
 *     &lt;enumeration value="OutputFromUnit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransferDirection_t")
@XmlEnum
public enum TransferDirectionT {

    @XmlEnumValue("InputOutput")
    INPUT_OUTPUT("InputOutput"),
    @XmlEnumValue("InputToUnit")
    INPUT_TO_UNIT("InputToUnit"),
    @XmlEnumValue("OutputFromUnit")
    OUTPUT_FROM_UNIT("OutputFromUnit");
    private final String value;

    TransferDirectionT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransferDirectionT fromValue(String v) {
        for (TransferDirectionT c: TransferDirectionT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
