package pl.edu.agh.soa.models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name="student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    private String name;
    private String surname;
    private int albumNumber;
    private String faculty;
    @XmlElementWrapper(name="courses")
    @XmlElement(name="course")
    private ArrayList<Course> courses;

    public Student (){};

    public Student(String name, String surname, int albumNumber, String faculty) {
        this.name = name;
        this.surname = surname;
        this.albumNumber = albumNumber;
        this.faculty = faculty;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getAlbumNumber(){
        return albumNumber;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public void setCourses(ArrayList courses){
        this.courses = courses;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void deleteCourse(Course course){
        courses.remove(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return albumNumber == student.albumNumber &&
                name.equals(student.name) &&
                surname.equals(student.surname) &&
                faculty.equals(student.faculty);
    }

}
