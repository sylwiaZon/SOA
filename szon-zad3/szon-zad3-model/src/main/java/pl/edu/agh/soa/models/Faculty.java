package pl.edu.agh.soa.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="faculty")
@XmlAccessorType(XmlAccessType.FIELD)
public class Faculty {
    private Integer id;
    @NotEmpty
    private String name;

    public Faculty() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Faculty: Name: " + name;
    }
}
