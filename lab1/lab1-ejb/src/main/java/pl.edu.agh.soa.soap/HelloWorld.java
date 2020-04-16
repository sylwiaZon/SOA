package pl.edu.agh.soa.soap;

import org.jboss.ws.api.annotation.WebContext;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@Stateless
@WebService
@WebContext(contextRoot="/soa",urlPattern="/hello")
public class HelloWorld {

    @WebMethod(action="hello")
    @WebResult(name="result")
    public String hello(@WebParam(name = "name") String name) {
        return "Hello " + name;
    }

}