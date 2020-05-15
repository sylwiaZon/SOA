package pl.edu.agh.soa.rest;

import io.swagger.annotations.*;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Student;
import pl.edu.agh.soa.rest.authentication.JWTTokenNeeded;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Api(value = "/students", description = "Get students info")
@Path("/students")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class StudentService {

    @GET
    @ApiOperation(value = "Get students")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
    public Response getAll(@ApiParam(value = "filter by course", required = false) @QueryParam("course") String course,
                           @ApiParam(value = "filter by faculty", required = false) @QueryParam("faculty") String faculty) {
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
    @ApiOperation(value = "Add student", authorizations = {@Authorization(value = "jwt")}, notes = "JWT authorization needed")
    @ApiResponses({@ApiResponse(code=201, message="Created"), @ApiResponse(code=409, message="Conflict")})
    public Response addStudent(@ApiParam(value = "Student to be added", required = true) Student student) {
        if(Students.getInstance().addStudent(student)){
            return Response.ok().status(Response.Status.CREATED).build();
        }
        return Response.notModified().status(Response.Status.CONFLICT).build();
    }


    @GET
    @Path("/{albumNumber}")
    @ApiOperation(value = "Get specified student")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
    public Response getUser(@ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber) {
        return Response.ok(Students.getInstance().getStudent(albumNumber)).status(Response.Status.OK).build();
    }

    @DELETE
    @JWTTokenNeeded
    @Path("/{albumNumber}")
    @ApiOperation(value = "Delete student", authorizations = {@Authorization(value = "jwt")}, notes = "JWT authorization needed")
    @ApiResponses({@ApiResponse(code = 204, message = "No Content"), @ApiResponse(code = 404, message = "Not Found")})
    public Response deleteUser(@ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber) {
        if(Students.getInstance().deleteStudent(albumNumber)){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else{
            return Response.notModified().status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @JWTTokenNeeded
    @Path("/{albumNumber}")
    @ApiOperation(value = "Update student", authorizations = {@Authorization(value = "jwt")}, notes = "JWT authorization needed")
    @ApiResponses({@ApiResponse(code = 204, message = "No Content"), @ApiResponse(code = 404, message = "Not Found")})
    public Response updateStudent(@ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber,
                                  @ApiParam(value = "Student to add", required = true) Student student) {
        if(Students.getInstance().updateStudent(albumNumber, student)){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        }
        return Response.notModified().status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @JWTTokenNeeded
    @Path("/{albumNumber}/courses")
    @ApiOperation(value = "Add course to student", authorizations = {@Authorization(value = "jwt")}, notes = "JWT authorization needed")
    @ApiResponses({@ApiResponse(code=201, message="Created")})
    public Response getStudentCourses(@ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber,
                                      @ApiParam(value = "Course to add", required = true) Course course) {
        Students.getInstance().addCourseToStudent(albumNumber,course);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{albumNumber}/courses")
    @ApiOperation(value = "Get student courses")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
    public Response addCourseToStudent(@ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber) {
        return Response.ok(Students.getInstance().getStudent(albumNumber).getCourses()).status(Response.Status.OK).build();
    }

    @GET
    @Path("/icon")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "Get app icon")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
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
