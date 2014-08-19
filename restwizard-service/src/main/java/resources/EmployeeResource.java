package resources;

import com.codahale.metrics.annotation.Timed;
import transport.Employee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 */

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @GET
    @Timed
    public Employee getEmp() {
        return new Employee("1", "tum", "coder");
    }
}
