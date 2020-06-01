package pl.edu.agh.soa.rest;

import io.swagger.annotations.*;
import pl.edu.agh.soa.dao.CourseDao;
import pl.edu.agh.soa.dao.FacultyDao;
import pl.edu.agh.soa.dao.ProfessorDao;
import pl.edu.agh.soa.models.Course;
import pl.edu.agh.soa.models.Faculty;
import pl.edu.agh.soa.models.Professor;
import pl.edu.agh.soa.rest.authentication.JWTTokenNeeded;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/courses", description = "Get courses info")
@Path("/courses")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CoursesService {

    @EJB
    CourseDao courseDao = new CourseDao();

    @EJB
    ProfessorDao professorDao = new ProfessorDao();

    @GET
    @ApiOperation(value = "Get courses")
    @ApiResponses({@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 404, message = "Not Found")})
    public Response getAll() {
        try {
            return Response.ok(courseDao.getCourses()).status(Response.Status.OK).build();
        } catch (Exception ex) {
            return Response.notModified().status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/course")
    @ApiOperation(value = "Get specified course")
    @ApiResponses({@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request")})
    public Response getFacultyById(@ApiParam(value = "filter by id", required = false) @QueryParam("id") Integer id,
                                   @ApiParam(value = "filter by name", required = false) @QueryParam("name") String name) {
        if (id != null) {
            try {
                return Response.ok(courseDao.getCourseById(id)).status(Response.Status.OK).build();
            } catch (Exception ex) {
                return Response.notModified().status(Response.Status.NOT_FOUND).build();
            }
        } else if (name != null) {
            try {
                return Response.ok(courseDao.getCourseByName(name)).status(Response.Status.OK).build();
            } catch (Exception ex) {
                return Response.notModified().status(Response.Status.NOT_FOUND).build();
            }
        }
        return Response.notModified().status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @JWTTokenNeeded
    @ApiOperation(value = "Add course", authorizations = {@Authorization(value = "jwt")}, notes = "JWT authorization needed")
    @ApiResponses({@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 409, message = "Conflict")})
    public Response addStudent(@ApiParam(value = "Faculty to be added", required = true) Course course) {
        try {
            courseDao.getCourseByName(course.getName());
            return Response.notModified().status(Response.Status.CONFLICT).build();
        } catch (Exception ex){
            try {

                Professor professor = professorDao.getProfessorByName(course.getProfessor().getName(), course.getProfessor().getSurname());
                courseDao.addCourse(course, professor);
                return Response.ok().status(Response.Status.CREATED).build();
            } catch (Exception ex2) {
                return Response.notModified().status(Response.Status.CONFLICT).build();
            }
        }
    }
}