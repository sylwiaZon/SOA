package pl.edu.agh.soa.soap;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import pl.edu.agh.soa.soap.models.Course;
import pl.edu.agh.soa.soap.models.Student;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Collection;

@Stateless
@WebService(name="StudentService")
@SecurityDomain("my-security-domain")
@DeclareRoles({"users, admins"})
@WebContext(contextRoot="/soa",urlPattern="/studentService", authMethod = "BASIC", transportGuarantee = "NONE")
public class StudentService implements StudentServiceInterface{

    @Override
    @PermitAll
    @WebMethod(operationName = "getStudent")
    @WebResult(name = "returnStudent")
    public Student getStudent(@WebParam(name="albumNumber") int albumNumber) {
        return Students.getInstance().getStudent(albumNumber);
    }

    @Override
    @RolesAllowed("admins")
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
    @RolesAllowed("admins")
    @WebMethod(operationName = "deleteStudent")
    @WebResult(name = "returnResponse")
    public String deleteStudent(@WebParam(name="albumNumber") int albumNumber) {
        if(Students.getInstance().deleteStudent(albumNumber)){
            return "Student was deleted";
        }
        return "There is no such student";
    }

    @Override
    @RolesAllowed("admins")
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

    @Override
    @PermitAll
    @WebMethod(operationName = "getAllStudents")
    @WebResult(name = "returnStudents")
    public Collection<Student> getAllStudents() {
        return Students.getInstance().getAllStudents().values();
    }

    @Override
    @PermitAll
    @WebMethod(operationName = "getStudentsByFaculty")
    @WebResult(name = "returnStudents")
    public Collection<Student> getStudentsByFaculty(@WebParam(name="faculty") String faculty) {
        return Students.getInstance().getStudentsByFaculty(faculty).values();
    }

    @Override
    @PermitAll
    @WebMethod(operationName = "getStudentsByCourse")
    @WebResult(name = "returnStudents")
    public Collection<Student> getStudentsByCourse(@WebParam(name="course") String course) {
        return Students.getInstance().getStudentsByCourse(course).values();
    }

    @Override
    @PermitAll
    @WebMethod(operationName = "getApplicationIcon")
    @WebResult(name = "icon")
    public String getIcon(){
        File file = new File("C:/Users/Sylwia/Desktop/Studia/SOA/zad1/lab1/soap-api/src/main/java/pl.edu.agh.soa.soap/applicationIcon.png");
        String encodedFile = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            encodedFile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedFile;
    }
}