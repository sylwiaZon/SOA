package pl.edu.agh.soa.soap;

import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Student;

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
        return students.remove(albumNumber) != null;
    }

    public void addCourseToStudent(int albumNumber, Course course){
        Student student = students.get(albumNumber);
        student.addCourse(course);
        students.replace(albumNumber,student);
    }

    public HashMap<Integer,Student> getAllStudents(){
        return students;
    }

    public HashMap<Integer,Student> getStudentsByFaculty(String faculty){
        HashMap<Integer,Student> resp = new HashMap<>();
        for(Student st: students.values()){
            if(st.getFaculty().equals(faculty)){
                resp.put(st.getAlbumNumber(),st);
            }
        }
        return resp;
    }

    public HashMap<Integer,Student> getStudentsByCourse(String course){
        HashMap<Integer,Student> resp = new HashMap<>();
        for(Student st: students.values()){
            for(Course c: st.getCourses()){
                if(c.getName().equals(course)){
                    resp.put(st.getAlbumNumber(),st);
                }
            }
        }
        return resp;
    }
}
