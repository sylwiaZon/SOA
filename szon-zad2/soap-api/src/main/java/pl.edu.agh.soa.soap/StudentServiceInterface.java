package pl.edu.agh.soa.soap;

import main.java.pl.edu.agh.soa.models.Student;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@WebService
public interface StudentServiceInterface {
    public Student getStudent(@WebParam(name="albumNumber") int albumNumber);
    public Student addStudent(@WebParam(name="name") String name,
                                @WebParam(name="surname") String surname,
                                @WebParam(name="field") String field,
                                @WebParam(name="albumNumber") int albumNumber);
    public String deleteStudent(@WebParam(name="albumNumber") int albumNumber);
    public Student addCourseToStudent(@WebParam(name="albumNumber") int albumNumber,
                                      @WebParam(name="courseName") String courseName,
                                      @WebParam(name="profesorName") String profesorName,
                                      @WebParam(name="profesorSurname") String profesorSurname,
                                      @WebParam(name="ects") int ects, @WebParam(name="hours") int hours);
    public Collection<Student> getAllStudents();
    public Collection<Student> getStudentsByFaculty(@WebParam(name="faculty") String faculty);
    public Collection<Student> getStudentsByCourse(@WebParam(name="courseName") String course);
    public byte[] getIcon();
}
