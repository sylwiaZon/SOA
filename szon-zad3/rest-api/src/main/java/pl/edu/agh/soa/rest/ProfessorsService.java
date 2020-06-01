package pl.edu.agh.soa.rest;

import io.swagger.annotations.*;
import pl.edu.agh.soa.dao.ProfessorDao;
import pl.edu.agh.soa.models.Professor;
import pl.edu.agh.soa.rest.authentication.JWTTokenNeeded;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/professors", description = "Get professors info")
@Path("/professors")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ProfessorsService {

    @EJB
    ProfessorDao professorDao = new ProfessorDao();

    @GET
    @ApiOperation(value = "Get Professors")
    @ApiResponses({@ApiResponse(code=200, message="Success"), @ApiResponse(code = 404, message = "Not Found")})
    public Response getAll() {
        try{
            return Response.ok(professorDao.getProfessors()).status(Response.Status.OK).build();
        } catch (Exception ex){
            return Response.notModified().status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/professor")
    @ApiOperation(value = "Get specified professor")
    @ApiResponses({@ApiResponse(code=200, message="Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request")})
    public Response getFacultyById(@ApiParam(value = "filter by id", required = false) @QueryParam("id") Integer id,
                                   @ApiParam(value = "filter by name", required = false) @QueryParam("name") String name,
                                   @ApiParam(value = "filter by name", required = false) @QueryParam("surname") String surname) {
        if(id != null){
            try{
                return Response.ok(professorDao.getProfessorById(id)).status(Response.Status.OK).build();
            } catch (Exception ex){
                return Response.notModified().status(Response.Status.NOT_FOUND).build();
            }
        } else if(name != null && surname != null){
            try{
                return Response.ok(professorDao.getProfessorByName(name, surname)).status(Response.Status.OK).build();
            } catch (Exception ex){
                return Response.notModified().status(Response.Status.NOT_FOUND).build();
            }
        }
        return Response.notModified().status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @JWTTokenNeeded
    @ApiOperation(value = "Add professor", authorizations = {@Authorization(value = "jwt")}, notes = "JWT authorization needed")
    @ApiResponses({@ApiResponse(code=201, message="Created"), @ApiResponse(code=409, message="Conflict")})
    public Response addStudent(@ApiParam(value = "Professor to be added", required = true) Professor professor) {
        try {
            professorDao.getProfessorByName(professor.getName(), professor.getSurname());
            return Response.notModified().status(Response.Status.CONFLICT).build();
        }catch (Exception ex) {
            try {
                professorDao.addProfessor(professor);
                return Response.ok().status(Response.Status.CREATED).build();
            } catch (Exception ex2) {
                return Response.notModified().status(Response.Status.CONFLICT).build();
            }
        }
    }
}