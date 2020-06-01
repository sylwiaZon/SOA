package pl.edu.agh.soa.models;

import org.hibernate.validator.constraints.NotEmpty;

public class Course {
    private Integer id;
    @NotEmpty
    private String name;
    private Professor professor;
    private int ectsPoints;
    private int hours;

    public Course(){}

    public Course(String name, String profesorName, String profesorSurname, int ectsPoints, int hours) {
        this.name = name;
        this.professor = new Professor();
        this.professor.setName(profesorName);
        this.professor.setSurname(profesorSurname);
        this.ectsPoints = ectsPoints;
        this.hours = hours;
    }

    public Course(String name, Professor professor, int ectsPoints, int hours) {
        this.name = name;
        this.professor = new Professor();
        this.professor = professor;
        this.ectsPoints = ectsPoints;
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public int getHours() {
        return hours;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return ectsPoints == course.ectsPoints &&
                hours == course.hours &&
                name.equals(course.name) &&
                professor.getName().equals(course.professor.getName()) &&
                professor.getSurname().equals(course.professor.getSurname());
    }

    @Override
    public String toString() {
        return "Course: Name: " + name + ", Profesor name: " + professor.getName() + ", Profesor Surname: " + professor.getSurname() + ", ECTS points: " + ectsPoints + ", hours: " + hours;
    }
}
