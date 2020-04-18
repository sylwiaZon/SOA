package pl.edu.agh.soa.soap;

import javax.xml.ws.BindingProvider;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Client {
    public static void main(String[] args){
        StudentServiceService service = new StudentServiceService();
        StudentServiceInterface serviceI = service.getStudentServicePort();
        setCredentials((BindingProvider) serviceI);

        Course maths = new Course();
        maths.setProfesorName("Piotr");
        maths.setProfesorSurname("Janiak");
        maths.setEctsPoints(5);
        maths.setHours(30);

        Course english = new Course();
        english.setProfesorName("Anna");
        english.setProfesorSurname("Polak");
        english.setEctsPoints(2);
        english.setHours(30);

        Course spanish = new Course();
        spanish.setProfesorName("Mercedes");
        spanish.setProfesorSurname("Cruz");
        spanish.setEctsPoints(2);
        spanish.setHours(30);

        Student studentA  = new Student();
        studentA.setName("Jan");
        studentA.setSurname("Kowalski");
        studentA.setAlbumNumber(297456);
        studentA.setFaculty("ComputerScience");

        Student studentB  = new Student();
        studentB.setName("Janina");
        studentB.setSurname("Nowak");
        studentB.setAlbumNumber(297459);
        studentB.setFaculty("Telecommunication");

        serviceI.addStudent(studentA.getName(),studentA.getSurname(),studentA.getFaculty(),studentA.getAlbumNumber());
        serviceI.addStudent(studentB.getName(),studentB.getSurname(),studentB.getFaculty(),studentB.getAlbumNumber());

        serviceI.addCourseToStudent(studentA.getAlbumNumber(),"Maths", maths.getProfesorName(), maths.getProfesorSurname(), maths.getEctsPoints(), maths.getHours());
        serviceI.addCourseToStudent(studentB.getAlbumNumber(),"Maths", maths.getProfesorName(), maths.getProfesorSurname(), maths.getEctsPoints(), maths.getHours());
        serviceI.addCourseToStudent(studentA.getAlbumNumber(),"Spanish", spanish.getProfesorName(), spanish.getProfesorSurname(), spanish.getEctsPoints(), spanish.getHours());
        serviceI.addCourseToStudent(studentB.getAlbumNumber(),"English", english.getProfesorName(), english.getProfesorSurname(), english.getEctsPoints(), english.getHours());

        System.out.println("All students: ");
        printStudentsList(serviceI.getAllStudents());

        System.out.println("Students who attend maths: ");
        printStudentsList(serviceI.getStudentsByCourse("Maths"));

        System.out.println("Students who attend Spanish: ");
        printStudentsList(serviceI.getStudentsByCourse("Spanish"));

        System.out.println("Students whos faculty is Telecommunication: ");
        printStudentsList(serviceI.getStudentsByFaculty("Telecommunication"));

        System.out.println("Student whose album number is 297459: ");
        printStudent(serviceI.getStudent(297459));

        byte[] icon = serviceI.getIcon();
        icon = Base64.getDecoder().decode(icon);

        System.out.println("Service icon: ");
        writeByte(icon);
    }

    private static void setCredentials(BindingProvider port) {
        port.getRequestContext().put("javax.xml.ws.security.auth.username","testUser");
        port.getRequestContext().put("javax.xml.ws.security.auth.password","testPassword");
    }

    private static void printStudent(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("Surname: " + student.getSurname());
        System.out.println("Album Number: " + student.getAlbumNumber());
        System.out.println("Faculty: " + student.getFaculty());
        System.out.println("Courses: ");
        printCourses(student.getCourses());
        System.out.println();
    }

    private static void printStudentsList(List<Student> students){
        for(Student student: students){
            printStudent(student);
        }
    }

    private static void printCourses(Student.Courses courses){
        for(Course course: courses.getCourse()){
            System.out.println("Profesor Name: " + course.getProfesorName());
            System.out.println("Profesor Surname: " + course.getProfesorSurname());
            System.out.println("Ects point: " + course.getEctsPoints());
            System.out.println("Hours: " + course.getHours());
        }
    }

    static void writeByte(byte[] bytes)
    {
        File file = new File("C:/Users/Sylwia/Desktop/Studia/SOA/zad1/lab1/soap-api/src/main/java/pl.edu.agh.soa.soap/applicationIcon.png");
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
            outputStream.close();
            Desktop dt = Desktop.getDesktop();
            dt.open(file);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
