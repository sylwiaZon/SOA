package pl.edu.agh.soa.soap;

import org.jboss.ws.api.annotation.WebContext;
import pl.edu.agh.soa.soap.models.Course;
import pl.edu.agh.soa.soap.models.Student;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@Stateless
@WebService(name="StudentService")
@WebContext(contextRoot="/soa",urlPattern="/studentService")
public class StudentService implements StudentServiceInterface{

    @Override
    @PermitAll
    @WebMethod(operationName = "getStudent")
    @WebResult(name = "returnStudent")
    public Student getStudent(@WebParam(name="albumNumber") int albumNumber) {
        return Students.getInstance().getStudent(albumNumber);
    }

    @Override
    @PermitAll
    @WebMethod(operationName = "addStudent")
    @WebResult(name = "returnStudent")
    public Student addStudent(@WebParam(name="name") String name,
                             @WebParam(name="surname") String surname,
                             @WebParam(name="field") String field,
                             @WebParam(name="albumNumber") int albumNumber) {
        Students.getInstance().addStudent(new Student(name,surname,albumNumber,field));
        return Students.getInstance().getStudent(albumNumber);
    }

    @Override
    @PermitAll
    @WebMethod(operationName = "deleteStudent")
    @WebResult(name = "returnStudent")
    public String deleteStudent(@WebParam(name="albumNumber") int albumNumber) {
        if(Students.getInstance().deleteStudent(albumNumber)){
            return "Student was deleted";
        }
        return "There is no such student";
    }

    @Override
    @PermitAll
    @WebMethod(operationName = "addCourseToStudent")
    @WebResult(name = "returnStudent")
    public Student addCourseToStudent(@WebParam(name="albumNumber") int albumNumber,
                                      @WebParam(name="courseName") String courseName,
                                      @WebParam(name="profesorName") String profesorName,
                                      @WebParam(name="profesorSurname") String profesorSurname,
                                      @WebParam(name="ects") int ects,
                                      @WebParam(name="hours") int hours) {
        Students.getInstance().addCourseToStudent(albumNumber,new Course(courseName,profesorName,profesorSurname,ects,hours));
        return Students.getInstance().getStudent(albumNumber);
    }
}