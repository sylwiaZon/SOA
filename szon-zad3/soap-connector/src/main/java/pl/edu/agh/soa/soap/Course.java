
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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="professor" type="{http://soap.soa.agh.edu.pl/}professor" minOccurs="0"/&gt;
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
    "id",
    "name",
    "professor"
})
public class Course {

    protected int ectsPoints;
    protected int hours;
    protected Integer id;
    protected String name;
    protected Professor professor;

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
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the professor property.
     * 
     * @return
     *     possible object is
     *     {@link Professor }
     *     
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Sets the value of the professor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Professor }
     *     
     */
    public void setProfessor(Professor value) {
        this.professor = value;
    }

}
