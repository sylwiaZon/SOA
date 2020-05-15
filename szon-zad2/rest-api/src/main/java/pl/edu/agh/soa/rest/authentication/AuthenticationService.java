package pl.edu.agh.soa.rest.authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.*;
import pl.edu.agh.soa.models.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Api(value = "/authenticate", description = "Login or register")
@Path("/authenticate")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AuthenticationService {

    @Inject
    private KeyGenerator keyGenerator;

    @Context
    private UriInfo uriInfo;



    @POST
    @Path("/login")
    @ApiOperation(value = "Login")
    @ApiResponses({@ApiResponse(code=200, message="Success"), @ApiResponse(code=401, message="Unauthorized")})
    public Response loginUser(@ApiParam(value = "User to login", required=true) User user) {
        if (authenticate(user)){
            return Response.ok().header(HttpHeaders.AUTHORIZATION, issueToken(user.getLogin())).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Path("/register")
    @ApiOperation(value = "Register")
    @ApiResponses({@ApiResponse(code=201, message="Created"), @ApiResponse(code=409, message="Conflict")})
    public Response registerUser(@ApiParam(value = "User to register", required=true) User user) {
        if(!Users.getInstance().addUser(user)){
            return Response.status(Response.Status.CONFLICT).build();
        } else{
            return Response.status(Response.Status.CREATED).build();
        }
    }

    private boolean authenticate(User user) throws SecurityException {
        String usr = Users.getInstance().getUsers().get(user.getLogin());
        if(usr != null && usr.equals(user.getPassword())){
            return true;
        }
        return false;
    }

    private String issueToken(String login) {
        keyGenerator = new KeyGenerator();
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return jwtToken;
    }
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
