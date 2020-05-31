package pl.edu.agh.soa.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="professor")
public class ProfessorEntity {
    @Id
    @Column(name="faculty_id")
    @GeneratedValue
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="surname", nullable = false)
    private String surname;

    @OneToMany
    private List<CourseEntity> courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<CourseEntity> courses) {
        this.courses = courses;
    }
}
