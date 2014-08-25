package resources;

import com.codahale.metrics.annotation.Timed;
import domain.Employee;
import responsemapper.EmployeeMapper;
import service.EmployeeService;
import transport.EmployeeTransport;
import transport.ResponseTransport;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 */

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private EmployeeService employeeServic;
    private EmployeeMapper employeeMapper;

    public EmployeeResource(EmployeeService employeeServic, EmployeeMapper mapper) {
        this.employeeServic = employeeServic;
        this.employeeMapper = mapper;
    }

    @GET
    @Timed
    public ResponseTransport<EmployeeTransport> getEmp() {
        List<Employee> employees = employeeServic.getEmp();
        return employeeMapper.map(employees);
    }

    @GET
    @Path("{id}")
    public EmployeeTransport getById(@PathParam("id")Long id) {
        Employee employee = employeeServic.getEmp(id);
        return employeeMapper.map(employee);
    }
}
