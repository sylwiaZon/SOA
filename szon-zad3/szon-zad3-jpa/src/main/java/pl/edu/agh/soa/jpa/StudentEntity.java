package pl.edu.agh.soa.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @Column(name = "album_number", nullable = false)
    private int albumNumber;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="surname", nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn(name="faculty_id")
    private FacultyEntity facultyEntity;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="student_courses",
            joinColumns = @JoinColumn(name="album_number"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseEntity> courses;

    public StudentEntity() {
        courses = new ArrayList<>();
    }

    public void addCourse(CourseEntity course){
        courses.add(course);
       // course.addStudent(this);
    }

    public int getAlbumNumber() {
        return albumNumber;
    }

    public void setAlbumNumber(int albumNumber) {
        this.albumNumber = albumNumber;
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

    public FacultyEntity getFacultyEntity() {
        return facultyEntity;
    }

    public void setFacultyEntity(FacultyEntity facultyEntity) {
        this.facultyEntity = facultyEntity;
    }

    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<CourseEntity> courses) {
        this.courses = courses;
    }
}
