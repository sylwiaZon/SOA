package pl.edu.agh.soa.soap.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Objects;

@XmlRootElement(name="student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    private String name;
    private String surname;
    private int albumNumber;
    private String field;
    private ArrayList<Course> courses;

    public Student (){};

    public Student(String name, String surname, int albumNumber, String field) {
        this.name = name;
        this.surname = surname;
        this.albumNumber = albumNumber;
        this.field = field;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getField() {
        return field;
    }

    public int getAlbumNumber(){
        return albumNumber;
    }

    public ArrayList<Course> getCourses() {
        return courses;
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
                field.equals(student.field);
    }

}
