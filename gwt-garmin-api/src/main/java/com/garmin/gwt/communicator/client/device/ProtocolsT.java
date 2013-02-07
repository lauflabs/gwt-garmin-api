//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.06 at 11:45:30 PM EST 
//


package com.garmin.gwt.communicator.client.device;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A list of supported protocols and associated data types. This list shows the features a pda supports.
 * 
 * <p>Java class for Protocols_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Protocols_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Link" type="{http://www.garmin.com/xmlschemas/GarminDevice/v2}Protocol_t" minOccurs="0"/>
 *         &lt;element name="Application" type="{http://www.garmin.com/xmlschemas/GarminDevice/v2}AppProtocol_t" maxOccurs="unbounded"/>
 *         &lt;element name="Transport" type="{http://www.garmin.com/xmlschemas/GarminDevice/v2}Protocol_t" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Protocols_t", propOrder = {
    "link",
    "application",
    "transport"
})
public class ProtocolsT {

    @XmlElement(name = "Link")
    protected ProtocolT link;
    @XmlElement(name = "Application", required = true)
    protected List<AppProtocolT> application;
    @XmlElement(name = "Transport")
    protected ProtocolT transport;

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolT }
     *     
     */
    public ProtocolT getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolT }
     *     
     */
    public void setLink(ProtocolT value) {
        this.link = value;
    }

    /**
     * Gets the value of the application property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the application property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppProtocolT }
     * 
     * 
     */
    public List<AppProtocolT> getApplication() {
        if (application == null) {
            application = new ArrayList<AppProtocolT>();
        }
        return this.application;
    }

    /**
     * Gets the value of the transport property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolT }
     *     
     */
    public ProtocolT getTransport() {
        return transport;
    }

    /**
     * Sets the value of the transport property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolT }
     *     
     */
    public void setTransport(ProtocolT value) {
        this.transport = value;
    }

}
