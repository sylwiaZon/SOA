package pl.edu.agh.soa.soap;

import pl.edu.agh.soa.soap.models.Course;
import pl.edu.agh.soa.soap.models.Student;

import java.util.HashMap;

public class Students {
    private HashMap<Integer,Student> students;
    private static Students instance;

    private Students(){
        students = new HashMap<>();
    }

    public static Students getInstance(){
        if(instance == null){
            instance = new Students();
        }
        return instance;
    }

    public Student getStudent(int albumNo){
        return students.get(albumNo);
    }

    public void addStudent(Student student){
        students.put(student.getAlbumNumber(),student);
    }

    public boolean deleteStudent(int albumNumber){
        return students.remove(albumNumber) == null;
    }

    public void addCourseToStudent(int albumNumber, Course course){
        Student student = students.get(albumNumber);
        student.addCourse(course);
        students.replace(albumNumber,student);
    }
}
