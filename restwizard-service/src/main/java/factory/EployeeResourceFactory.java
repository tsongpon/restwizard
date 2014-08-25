package factory;

import org.skife.jdbi.v2.DBI;
import repository.EmlooyeeRepository;
import resources.EmployeeResource;
import responsemapper.EmployeeMapper;
import service.EmployeeService;

/**
 *
 */
public class EployeeResourceFactory {

    public EmployeeResource getNewInstance(final DBI dbi) throws ClassNotFoundException {
        EmlooyeeRepository dao = dbi.onDemand(EmlooyeeRepository.class);
        EmployeeService employeeService = new EmployeeService(dao);
        EmployeeMapper employeeMapper = new EmployeeMapper();

        return new EmployeeResource(employeeService, employeeMapper);
    }
}
