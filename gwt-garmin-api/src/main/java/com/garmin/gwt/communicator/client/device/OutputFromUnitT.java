//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.06 at 11:45:30 PM EST 
//


package com.garmin.gwt.communicator.client.device;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutputFromUnit_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputFromUnit_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Specification" type="{http://www.garmin.com/xmlschemas/GarminDevice/v2}Specification_t"/>
 *         &lt;element name="File" type="{http://www.garmin.com/xmlschemas/GarminDevice/v2}File_t"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputFromUnit_t", propOrder = {
    "specification",
    "file"
})
public class OutputFromUnitT {

    @XmlElement(name = "Specification", required = true)
    protected SpecificationT specification;
    @XmlElement(name = "File", required = true)
    protected FileT file;

    /**
     * Gets the value of the specification property.
     * 
     * @return
     *     possible object is
     *     {@link SpecificationT }
     *     
     */
    public SpecificationT getSpecification() {
        return specification;
    }

    /**
     * Sets the value of the specification property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecificationT }
     *     
     */
    public void setSpecification(SpecificationT value) {
        this.specification = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link FileT }
     *     
     */
    public FileT getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileT }
     *     
     */
    public void setFile(FileT value) {
        this.file = value;
    }

}