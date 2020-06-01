import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.edu.agh.soa.model.StudentOuterClass;
import pl.edu.agh.soa.models.*;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

public class Client {
    private ResteasyClient client;
    private static final String API_URL = "http://localhost:8086/rest-api/api";
    public Client(){
        client = new ResteasyClientBuilder().build();
    }

    public void register(String login, String password){
        ResteasyWebTarget target = client.target(API_URL+"/authenticate/register");
        Response response = target.request().post(Entity.entity(new User(login,password), MediaType.APPLICATION_JSON));
        System.out.println("Register response: " + response.getStatus() + " " + response.getStatusInfo());
    }

    public String login(String login, String password){
        ResteasyWebTarget target = client.target(API_URL+"/authenticate/login");
        Response response = target.request().post(Entity.entity(new User(login,password), MediaType.APPLICATION_JSON));
        System.out.println("Login response: " + response.getStatus() + " " + response.getStatusInfo());
        return response.getHeaderString("Authorization");
    }

    public List<Student> getStudents() {
        ResteasyWebTarget target = client.target(API_URL+"/students");
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        System.out.println("getStudents response: " + response.getStatus() + " " + response.getStatusInfo());
        return response.readEntity(new GenericType<List<Student>>() {});
    }

    public List<Student> getStudentsByFaculty(String faculty) {
        ResteasyWebTarget target = client.target(API_URL+"/students");
        target.queryParam("faculty",faculty);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        System.out.println("getStudents with faculty param response: " + response.getStatus() + " " + response.getStatusInfo());
        return response.readEntity(new GenericType<List<Student>>() {});
    }

    public void addStudent(Student student, String token){
        ResteasyWebTarget target = client.target(API_URL+"/students");
        Response response = target.request(MediaType.APPLICATION_JSON).header("Authorization", token).post(Entity.entity(student, MediaType.APPLICATION_JSON ));
        System.out.println("addStudent response: " + response.getStatus() + " " + response.getStatusInfo());
    }

    public void addFaculty(Faculty faculty, String token){
        ResteasyWebTarget target = client.target(API_URL+"/faculties");
        Response response = target.request(MediaType.APPLICATION_JSON).header("Authorization", token).post(Entity.entity(faculty, MediaType.APPLICATION_JSON ));
        System.out.println("addFaculty response: " + response.getStatus() + " " + response.getStatusInfo());
    }

    public void addProfessor(Professor professor, String token){
        ResteasyWebTarget target = client.target(API_URL+"/professors");
        Response response = target.request(MediaType.APPLICATION_JSON).header("Authorization", token).post(Entity.entity(professor, MediaType.APPLICATION_JSON ));
        System.out.println("addProfessor response: " + response.getStatus() + " " + response.getStatusInfo());
    }

    public void addCourse(Course course, String token){
        ResteasyWebTarget target = client.target(API_URL+"/courses");
        Response response = target.request(MediaType.APPLICATION_JSON).header("Authorization", token).post(Entity.entity(course, MediaType.APPLICATION_JSON ));
        System.out.println("addCourse response: " + response.getStatus() + " " + response.getStatusInfo());
    }

    public Student getStudent(int albumNumber){
        ResteasyWebTarget target = client.target(API_URL+"/students/"+albumNumber);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        System.out.println("getStudent response: " + response.getStatus() + " " + response.getStatusInfo());
        return response.readEntity(new GenericType<Student>() {});
    }

    public void deleteStudent(int albumNumber,String token) {
        ResteasyWebTarget target = client.target(API_URL+"/students/"+albumNumber);
        Response response = target.request().header("Authorization", token).delete();
        System.out.println("deleteStudent response: " + response.getStatus() + " " + response.getStatusInfo());
    }

    public void updateStudent(int albumNumber, Student student, String token) {
        ResteasyWebTarget target = client.target(API_URL+"/students/"+albumNumber);
        Response response = target.request().header("Authorization", token).put(Entity.entity(student, MediaType.APPLICATION_JSON ));
        System.out.println("updateStudent response: " + response.getStatus() + " " + response.getStatusInfo());
    }

    public ArrayList<Course> getCourses(int albumNumber){
        ResteasyWebTarget target = client.target(API_URL+"/students/"+albumNumber+"/courses");
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        System.out.println("getCourses response: " + response.getStatus() + " " + response.getStatusInfo());
        return response.readEntity(new GenericType<ArrayList<Course>>() {});
    }

    public void addCoursesToStudent(int albumNumber, Course course, String token){
        ResteasyWebTarget target = client.target(API_URL+"/students/"+albumNumber+"/courses");
        Response response = target.request(MediaType.APPLICATION_JSON).header("Authorization", token).post(Entity.entity(course, MediaType.APPLICATION_JSON ));
        System.out.println("addCoursesToStudent response: " + response.getStatus() + " " + response.readEntity(String.class));
    }

    public void getIcon(){
        ResteasyWebTarget target = client.target(API_URL+"/students/icon");
        Response response = target.request().get();
        System.out.println("getCourses response: " + response.getStatus() + " " + response.getStatusInfo());
        String icon = response.readEntity(String.class);
        byte[] decodedIcon = Base64.getDecoder().decode(icon);
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(decodedIcon);
            BufferedImage bufferedImage = ImageIO.read(stream);
            ImageIO.write(bufferedImage, "png", new File("newIcon.png"));
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File("newIcon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProtocolBufferStudent(int albumNumber){
        ResteasyWebTarget target = client.target(API_URL+"/students/"+albumNumber+"/proto");
        InputStream response = target.request().header("accept","application/protobuf").get(InputStream.class);
        try {
            StudentOuterClass.Student student = StudentOuterClass.Student.parseFrom(IOUtils.toByteArray(response));
            return student.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
