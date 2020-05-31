package pl.edu.agh.soa.rest;

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

    public boolean addStudent(Student student){
        if(getStudent(student.getAlbumNumber()) != null){
            return false;
        }
        students.put(student.getAlbumNumber(),new Student(student.getName(),
                student.getSurname(), student.getAlbumNumber(), student.getFaculty()));
        return true;
    }

    public boolean deleteStudent(int albumNumber){
        return students.remove(albumNumber) != null;
    }

    public boolean addCourseToStudent(int albumNumber, Course course){
        Student student = students.get(albumNumber);
        if(student == null) {
            return false;
        }
        student.addCourse(course);
        students.replace(albumNumber,student);
        return true;
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

    public boolean updateStudent(int albumNumber, Student student){
        Student currentStudent = getStudent(albumNumber);
        if(currentStudent == null){
            return false;
        }
        if(student.getName()!= null){
            currentStudent.setName(student.getName());
        }
        if(student.getSurname()!= null){
            currentStudent.setSurname(student.getSurname());
        }
        if(student.getFaculty()!= null){
            currentStudent.setFaculty(student.getFaculty());
        }
        return true;
    }
}
