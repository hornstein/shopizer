<<<<<<< HEAD
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.13 at 11:05:37 AM EDT 
//


package ca.canadapost.cpcdp.rating.generated.discovery;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelType">
 *   &lt;restriction base="{http://www.canadapost.ca/ws/ship/rate-v3}RelType">
 *     &lt;enumeration value="service"/>
 *     &lt;enumeration value="option"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelType")
@XmlEnum
public enum RelType {

    @XmlEnumValue("service")
    SERVICE("service"),
    @XmlEnumValue("option")
    OPTION("option");
    private final String value;

    RelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelType fromValue(String v) {
        for (RelType c: RelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
=======
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.13 at 11:05:37 AM EDT 
//


package ca.canadapost.cpcdp.rating.generated.discovery;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelType">
 *   &lt;restriction base="{http://www.canadapost.ca/ws/ship/rate-v3}RelType">
 *     &lt;enumeration value="service"/>
 *     &lt;enumeration value="option"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelType")
@XmlEnum
public enum RelType {

    @XmlEnumValue("service")
    SERVICE("service"),
    @XmlEnumValue("option")
    OPTION("option");
    private final String value;

    RelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelType fromValue(String v) {
        for (RelType c: RelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
