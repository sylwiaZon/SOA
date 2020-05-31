package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.CourseEntity;
import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {
    public static Student mapEntityToStudent(StudentEntity studentEntity){
        Student student = new Student();
        student.setName(studentEntity.getName());
        student.setSurname(studentEntity.getSurname());
        student.setFaculty(FacultyMapper.mapFaculty(studentEntity.getFacultyEntity()));
        student.setAlbumNumber(studentEntity.getAlbumNumber());
        student.setCourses(CourseMapper.getCoursesFromEntities(studentEntity.getCourses()));
        return student;
    }

    public static StudentEntity mapStudentToEntity(Student student){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setSurname(student.getSurname());
        studentEntity.setAlbumNumber(student.getAlbumNumber());
        if(student.getCourses() != null){
            studentEntity.setCourses(CourseMapper.getEntitiesFromCourses(student.getCourses()));
        }
        return studentEntity;
    }
    public static ArrayList<Student> getStudentsFromEntities(List<StudentEntity> studentEntities){
        ArrayList<Student> students = new ArrayList<>();
        for(StudentEntity studentEntity: studentEntities){
            students.add(mapEntityToStudent(studentEntity));
        }
        return students;
    }

    public static List<StudentEntity> getEntitiesFromStdents(ArrayList<Student> students){
        ArrayList<StudentEntity> studentEntities = new ArrayList<>();
        for(Student student: students){
            studentEntities.add(mapStudentToEntity(student));
        }
        return studentEntities;
    }
}
