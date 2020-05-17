import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.edu.agh.soa.models.Student;
import pl.edu.agh.soa.models.User;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.MessageFormat;
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
        student.setCourses(null);
        Response response = target.request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token).post(Entity.entity(student, MediaType.APPLICATION_JSON ));
        System.out.println("addStudent response: " + response.getStatus() + " " + response.getStatusInfo());
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
        student.setCourses(null);
        System.out.println("deleteStudent response: " + response.getStatus() + " " + response.getStatusInfo());
    }

}
