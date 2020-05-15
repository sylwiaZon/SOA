package pl.edu.agh.soa.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import pl.edu.agh.soa.models.Student;

@Path("/students")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class StudentEndpoint {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAll() {
        List<Student> users = Arrays.asList(
                new Student("Anna", "Nowak", 297376, "ComputerScience"),
                new Student("Kamil", "Kowalski", 297394, "Physics")
        );
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Student user) {
        System.out.println(user);
        return Response.ok().build();
    }
}
