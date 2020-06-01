package pl.edu.agh.soa.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="courses")
public class CourseEntity {
    @Id
    @Column(name="course_id")
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "ects_points", nullable = false)
    private int ectsPoints;

    @Column(name = "hours", nullable = false)
    private int hours;

    @ManyToOne
    @JoinColumn(name="professor_id")
    private ProfessorEntity professorEntity;

    @ManyToMany
    @JoinTable(name="student_courses",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name = "album_number"))
    private List<StudentEntity> studentEntities;

    public CourseEntity() {
        studentEntities = new ArrayList<>();
    }

    public void addStudent(StudentEntity studentEntity){
        studentEntities.add(studentEntity);
    }

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

    public int getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public ProfessorEntity getProfessorEntity() {
        return professorEntity;
    }

    public void setProfessorEntity(ProfessorEntity professorEntity) {
        this.professorEntity = professorEntity;
    }

    public List<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(ArrayList<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }
}
