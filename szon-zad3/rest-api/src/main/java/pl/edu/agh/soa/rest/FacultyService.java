package pl.edu.agh.soa.rest;

import io.swagger.annotations.*;
import pl.edu.agh.soa.dao.FacultyDao;
import pl.edu.agh.soa.dao.StudentDao;
import pl.edu.agh.soa.models.Faculty;
import pl.edu.agh.soa.rest.authentication.JWTTokenNeeded;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/faculties", description = "Get faculties info")
@Path("/faculties")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class FacultyService {

    @EJB
    FacultyDao facultyDao = new FacultyDao();

    @GET
    @ApiOperation(value = "Get Faculties")
    @ApiResponses({@ApiResponse(code=200, message="Success"), @ApiResponse(code = 404, message = "Not Found")})
    public Response getAll() {
        try{
            return Response.ok(facultyDao.getFaculties()).status(Response.Status.OK).build();
        } catch (Exception ex){
            return Response.notModified().status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/faculty")
    @ApiOperation(value = "Get specified faculty")
    @ApiResponses({@ApiResponse(code=200, message="Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request")})
    public Response getFacultyById(@ApiParam(value = "filter by id", required = false) @QueryParam("id") Integer id,
                                   @ApiParam(value = "filter by name", required = false) @QueryParam("faculty") String faculty) {
        if(id != null){
            try{
                return Response.ok(facultyDao.getFacultyById(id)).status(Response.Status.OK).build();
            } catch (Exception ex){
                return Response.notModified().status(Response.Status.NOT_FOUND).build();
            }
        } else if(faculty != null){
            try{
                return Response.ok(facultyDao.getFacultyByName(faculty)).status(Response.Status.OK).build();
            } catch (Exception ex){
                return Response.notModified().status(Response.Status.NOT_FOUND).build();
            }
        }
        return Response.notModified().status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @JWTTokenNeeded
    @ApiOperation(value = "Add faculty", authorizations = {@Authorization(value = "jwt")}, notes = "JWT authorization needed")
    @ApiResponses({@ApiResponse(code=201, message="Created"), @ApiResponse(code=409, message="Conflict")})
    public Response addStudent(@ApiParam(value = "Faculty to be added", required = true) Faculty faculty) {
        try {
            facultyDao.getFacultyByName(faculty.getName());
            return Response.notModified().status(Response.Status.CONFLICT).build();
        }catch(Exception ex) {
            try {
                facultyDao.addFaculty(faculty);
                return Response.ok().status(Response.Status.CREATED).build();
            } catch (Exception ex2) {
                return Response.notModified().status(Response.Status.CONFLICT).build();
            }
        }
    }
}
