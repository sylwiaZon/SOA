package pl.edu.agh.soa.dao;

import pl.edu.agh.soa.jpa.CourseEntity;
import pl.edu.agh.soa.jpa.FacultyEntity;
import pl.edu.agh.soa.jpa.StudentEntity;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Faculty;
import pl.edu.agh.soa.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {
    public static Student mapEntityToStudent(StudentEntity studentEntity){
        Student student = new Student();
        student.setName(studentEntity.getName());
        student.setSurname(studentEntity.getSurname());
        student.setFaculty(FacultyMapper.mapEntityToFaculty(studentEntity.getFacultyEntity()));
        student.setAlbumNumber(studentEntity.getAlbumNumber());
        student.setCourses(CourseMapper.mapEntitiesToCourses(studentEntity.getCourses()));
        return student;
    }

    public static StudentEntity mapStudentToEntity(Student student){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setSurname(student.getSurname());
        studentEntity.setAlbumNumber(student.getAlbumNumber());
        studentEntity.setFacultyEntity(FacultyMapper.mapFacultyToEntity(student.getFaculty()));
        if(student.getCourses() != null){
            studentEntity.setCourses(CourseMapper.mapCoursesToEntities(student.getCourses()));
        }
        return studentEntity;
    }

    public static StudentEntity mapStudentToEntity(Student student, Faculty faculty){
        StudentEntity studentEntity = mapStudentToEntity(student);
        studentEntity.setFacultyEntity(FacultyMapper.mapFacultyToEntity(faculty));
        return studentEntity;
    }

    public static ArrayList<Student> mapEntitiesToStudents(List<StudentEntity> resultList) {
        ArrayList<Student> students = new ArrayList<>();
        for(StudentEntity studentEntity: resultList){
            students.add(mapEntityToStudent(studentEntity));
        }
        return students;
    }
}
