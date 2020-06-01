package pl.edu.agh.soa.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name="student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    private int albumNumber;
    @NotEmpty
    @XmlElement(name="faculty")
    private Faculty faculty;
    @XmlElementWrapper(name="courses")
    @XmlElement(name="course")
    private ArrayList<Course> courses;

    public Student (){};

    public Student(String name, String surname, int albumNumber, Faculty faculty) {
        this.name = name;
        this.surname = surname;
        this.albumNumber = albumNumber;
        this.faculty = faculty;
    }

    public Student(String name, String surname, int albumNumber, String faculty) {
        this.name = name;
        this.surname = surname;
        this.albumNumber = albumNumber;
        this.faculty = new Faculty(faculty);
    }

    public Student(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Faculty getFaculty() {
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

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = new Faculty(faculty);
    }

    public void addCourse(Course course){
        if(courses == null) courses = new ArrayList<>();

        courses.add(course);
    }

    public void setAlbumNumber(int albumNumber) {
        this.albumNumber = albumNumber;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
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

    @Override
    public String toString() {
        String resp = "Student: Name: " + name + ", Surname: " + surname + ", Album Number: " + albumNumber + ", Faculty: " + faculty ;
        if(courses != null) {
            resp = "Student: Name: " + name + ", Surname: " + surname + ", Album Number: " + albumNumber + ", Faculty: " + faculty + ", Courses: " + courses.toString();
        }
        return resp;
    }
}
