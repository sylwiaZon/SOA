package main.java.pl.edu.agh.soa.models;

public class Course {
    private String name;
    private String profesorName;
    private String profesorSurname;
    private int ectsPoints;
    private int hours;

    public Course(String name, String profesorName, String profesorSurname, int ectsPoints, int hours) {
        this.name = name;
        this.profesorName = profesorName;
        this.profesorSurname = profesorSurname;
        this.ectsPoints = ectsPoints;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public String getProfesorName() {
        return profesorName;
    }

    public String getProfesorSurname() {
        return profesorSurname;
    }

    public String getProfesorFullName() {
        return profesorName + " " + profesorSurname;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public int getHours() {
        return hours;
    }

    public void setProfesorName(String profesorName) {
        this.profesorName = profesorName;
    }

    public void setProfesorSurname(String profesorSurname) {
        this.profesorSurname = profesorSurname;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return ectsPoints == course.ectsPoints &&
                hours == course.hours &&
                name.equals(course.name) &&
                profesorName.equals(course.profesorName) &&
                profesorSurname.equals(course.profesorSurname);
    }

}
