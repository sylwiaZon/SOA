package pl.edu.agh.soa.rest;

import javax.crypto.KeyGenerator;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceException;
import java.io.*;
import java.net.URL;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Student;
import pl.edu.agh.soa.rest.authentication.JWTTokenNeeded;

@Path("/students")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class StudentService {

    @GET
    public Response getAll(@QueryParam("course") String course,
                           @QueryParam("faculty") String faculty) {
        if(course != null){
            return Response.ok(Students.getInstance().getStudentsByCourse(course).values()).status(Response.Status.OK).build();
        }
        if(faculty != null){
            return Response.ok(Students.getInstance().getStudentsByFaculty(faculty).values()).status(Response.Status.OK).build();
        }
        return Response.ok(Students.getInstance().getAllStudents().values()).status(Response.Status.OK).build();
    }

    @POST
    @JWTTokenNeeded
    public Response addStudent(Student student) {
        if(Students.getInstance().addStudent(student)){
            return Response.ok().status(Response.Status.CREATED).build();
        }
        return Response.notModified().status(Response.Status.CONFLICT).build();
    }


    @GET
    @Path("/{albumNumber}")
    public Response getUser(@PathParam("albumNumber") int albumNumber) {
        return Response.ok(Students.getInstance().getStudent(albumNumber)).status(Response.Status.OK).build();
    }

    @DELETE
    @JWTTokenNeeded
    @Path("/{albumNumber}")
    public Response deleteUser(@PathParam("albumNumber") int albumNumber) {
        if(Students.getInstance().deleteStudent(albumNumber)){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else{
            return Response.notModified().status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @JWTTokenNeeded
    @Path("/{albumNumber}")
    public Response updateStudent(@PathParam("albumNumber") int albumNumber, Student student) {
        if(Students.getInstance().updateStudent(albumNumber, student)){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        }
        return Response.notModified().status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @JWTTokenNeeded
    @Path("/{albumNumber}/courses")
    public Response getStudentCourses(@PathParam("albumNumber") int albumNumber, Course course) {
        Students.getInstance().addCourseToStudent(albumNumber,course);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{albumNumber}/courses")
    public Response addCourseToStudent(@PathParam("albumNumber") int albumNumber) {
        return Response.ok(Students.getInstance().getStudent(albumNumber).getCourses()).status(Response.Status.OK).build();
    }

    @GET
    @Path("/icon")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getIcon() throws IOException {
        String filePath = "C:/Users/Sylwia/Desktop/Studia/SOA/zad1/szon-zad2/rest-api/src/main/java/pl/edu/agh/soa/rest/applicationIcon.png";
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream inputStream = new BufferedInputStream(fis);
        byte[] fileBytes = new byte[(int) file.length()];
        inputStream.read(fileBytes);
        inputStream.close();

        return Response.ok(fileBytes).status(Response.Status.OK).build();

    }

}
