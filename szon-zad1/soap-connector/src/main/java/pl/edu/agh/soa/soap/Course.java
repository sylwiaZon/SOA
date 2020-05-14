
package pl.edu.agh.soa.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for course complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="course"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ectsPoints" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="hours" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="profesorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="profesorSurname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "course", propOrder = {
    "ectsPoints",
    "hours",
    "profesorName",
    "profesorSurname"
})
public class Course {

    protected int ectsPoints;
    protected int hours;
    protected String profesorName;
    protected String profesorSurname;

    /**
     * Gets the value of the ectsPoints property.
     * 
     */
    public int getEctsPoints() {
        return ectsPoints;
    }

    /**
     * Sets the value of the ectsPoints property.
     * 
     */
    public void setEctsPoints(int value) {
        this.ectsPoints = value;
    }

    /**
     * Gets the value of the hours property.
     * 
     */
    public int getHours() {
        return hours;
    }

    /**
     * Sets the value of the hours property.
     * 
     */
    public void setHours(int value) {
        this.hours = value;
    }

    /**
     * Gets the value of the profesorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfesorName() {
        return profesorName;
    }

    /**
     * Sets the value of the profesorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfesorName(String value) {
        this.profesorName = value;
    }

    /**
     * Gets the value of the profesorSurname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfesorSurname() {
        return profesorSurname;
    }

    /**
     * Sets the value of the profesorSurname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfesorSurname(String value) {
        this.profesorSurname = value;
    }

}
