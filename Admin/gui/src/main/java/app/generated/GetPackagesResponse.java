
package app.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getPackagesResult" type="{http://tempuri.org/}ArrayOfPackage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getPackagesResult"
})
@XmlRootElement(name = "getPackagesResponse")
public class GetPackagesResponse {

    protected ArrayOfPackage getPackagesResult;

    /**
     * Gets the value of the getPackagesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPackage }
     *     
     */
    public ArrayOfPackage getGetPackagesResult() {
        return getPackagesResult;
    }

    /**
     * Sets the value of the getPackagesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPackage }
     *     
     */
    public void setGetPackagesResult(ArrayOfPackage value) {
        this.getPackagesResult = value;
    }

}
