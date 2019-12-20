package Rest;

import model.Employee;
import service.OfyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("employees")
public class EmployeeRestService {
    private static final Logger log  = Logger.getLogger(EmployeeRestService.class.getName());

    @GET
    @Path("byid")
    public void printEmployeeByID(@QueryParam("id") long id){
        log.info("Get Employee By ID method :"+id);
        Employee empFetch = OfyService.ofy().load().type(Employee.class).id(id).now();

        System.out.println(empFetch.toString());

    }


    @POST
    @Path("byid")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeByID(@QueryParam("id") long id){
        log.info("Get Employee By ID method :"+id);
        Employee empFetch = OfyService.ofy().load().type(Employee.class).id(id).now();

        System.out.println(empFetch.toString());

        return empFetch;
    }

}
