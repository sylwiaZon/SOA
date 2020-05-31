package pl.edu.agh.soa.rest;

import io.swagger.annotations.*;
import pl.edu.agh.soa.dao.StudentDao;
import pl.edu.agh.soa.dao.UserDao;
import pl.edu.agh.soa.model.StudentOuterClass;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Student;
import pl.edu.agh.soa.rest.authentication.JWTTokenNeeded;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Api(value = "/students", description = "Get students info")
@Path("/students")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class StudentService {

    @EJB
    StudentDao dao = new StudentDao();

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
    public Response addStudent(@NotNull @ApiParam(value = "Student to be added", required = true) Student student) {
        dao.addStudent(student);
        if(Students.getInstance().addStudent(student)){
            return Response.ok().status(Response.Status.CREATED).build();
        }
        return Response.notModified().status(Response.Status.CONFLICT).build();
    }


    @GET
    @Path("/{albumNumber}")
    @ApiOperation(value = "Get specified student")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
    public Response getStudent(@NotNull @ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber) {
        return Response.ok(dao.getStudent(albumNumber)).status(Response.Status.OK).build();
    }

    @DELETE
    @JWTTokenNeeded
    @Path("/{albumNumber}")
    @ApiOperation(value = "Delete student", authorizations = {@Authorization(value = "jwt")}, notes = "JWT authorization needed")
    @ApiResponses({@ApiResponse(code = 204, message = "No Content"), @ApiResponse(code = 404, message = "Not Found")})
    public Response deleteStudent(@NotNull @ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber) {
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
    public Response updateStudent(@NotNull @ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber,
                                  @NotNull @ApiParam(value = "Student to add", required = true) Student student) {
        if(Students.getInstance().updateStudent(albumNumber, student)){
            return Response.ok().status(Response.Status.NO_CONTENT).build();
        }
        return Response.notModified().status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @JWTTokenNeeded
    @Path("/{albumNumber}/courses")
    @ApiOperation(value = "Add course to student", authorizations = {@Authorization(value = "jwt")}, notes = "JWT authorization needed")
    @ApiResponses({@ApiResponse(code=201, message="Created"), @ApiResponse(code = 404, message = "Not Found")})
    public Response addCourseToStudent(@NotNull @ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber,
                                       @NotNull @ApiParam(value = "Course to add", required = true) Course course) {
        if(Students.getInstance().addCourseToStudent(albumNumber,course)) {
            return Response.ok().status(Response.Status.CREATED).build();
        }
        return Response.notModified().status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{albumNumber}/courses")
    @ApiOperation(value = "Get student courses")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
    public Response getStudentCourses(@NotNull @ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber) {
        return Response.ok(Students.getInstance().getStudent(albumNumber).getCourses()).status(Response.Status.OK).build();
    }

    @GET
    @Path("/icon")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "Get app icon")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
    public Response getIcon() throws IOException {
        String filePath = "C:/Users/Sylwia/Desktop/Studia/SOA/zad1/szon-zad3/rest-api/src/main/java/pl/edu/agh/soa/rest/applicationIcon.png";
        java.nio.file.Path path = Paths.get(filePath);
        byte[] file = Files.readAllBytes(path);

        return Response.ok(Base64.getEncoder().encode(file)).status(Response.Status.OK).build();

    }

    @GET
    @Path("/{albumNumber}/proto")
    @Produces("application/protobuf")
    @ApiOperation(value = "Get student as proto buffer")
    @ApiResponses({@ApiResponse(code=200, message="Success")})
    public Response getStudentProto(@NotNull @ApiParam(value = "Album number to search student by", required = true) @PathParam("albumNumber") int albumNumber) {

        Student st = Students.getInstance().getStudent(albumNumber);
        StudentOuterClass.Student.Builder studentBilder = StudentOuterClass.Student.newBuilder();
        studentBilder.setAlbumNumber(st.getAlbumNumber())
                .setField(st.getFaculty())
                .setName(st.getName())
                .setSurname(st.getSurname());
        for (Course c : st.getCourses()) {
            StudentOuterClass.Course course = StudentOuterClass.Course.newBuilder()
                    .setName(c.getName())
                    .setHours(c.getHours())
                    .setEctsPoints(c.getEctsPoints())
                    .setProfesorName(c.getProfesorName())
                    .setProfesorSurname(c.getProfesorSurname())
                    .build();
            studentBilder.addCourses(course);
        }
        StudentOuterClass.Student student = studentBilder.build();
        return Response.ok(student.toByteArray(), "application/protobuf").build();
    }
}
