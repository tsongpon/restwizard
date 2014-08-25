package responsemapper;

import domain.Employee;
import transport.EmployeeTransport;
import transport.ResponseTransport;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class EmployeeMapper {
    public EmployeeTransport map(Employee employee) {
        return new EmployeeTransport(employee.getId(), employee.getName(), employee.getTitle());
    }

    public ResponseTransport<EmployeeTransport> map(List<Employee> employeeList) {
        List<EmployeeTransport> employeeTransports = new ArrayList<EmployeeTransport>();
        for (Employee eachEmp : employeeList) {
            employeeTransports.add(map(eachEmp));
        }

        return new ResponseTransport<EmployeeTransport>(employeeTransports, employeeList.size());
    }
}
