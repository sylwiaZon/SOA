
package pl.edu.agh.soa.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addCourseToStudent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addCourseToStudent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="albumNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="courseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="profesorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="profesorSurname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ects" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="hours" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addCourseToStudent", propOrder = {
    "albumNumber",
    "courseName",
    "profesorName",
    "profesorSurname",
    "ects",
    "hours"
})
public class AddCourseToStudent {

    protected int albumNumber;
    protected String courseName;
    protected String profesorName;
    protected String profesorSurname;
    protected int ects;
    protected int hours;

    /**
     * Gets the value of the albumNumber property.
     * 
     */
    public int getAlbumNumber() {
        return albumNumber;
    }

    /**
     * Sets the value of the albumNumber property.
     * 
     */
    public void setAlbumNumber(int value) {
        this.albumNumber = value;
    }

    /**
     * Gets the value of the courseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the value of the courseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourseName(String value) {
        this.courseName = value;
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

    /**
     * Gets the value of the ects property.
     * 
     */
    public int getEcts() {
        return ects;
    }

    /**
     * Sets the value of the ects property.
     * 
     */
    public void setEcts(int value) {
        this.ects = value;
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

}
