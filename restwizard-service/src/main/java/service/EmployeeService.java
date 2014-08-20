package service;

import org.springframework.stereotype.Service;
import transport.Employee;

/**
 *
 */
@Service
public class EmployeeService {

    public Employee getEmp() {
        return new Employee("1", "tum", "coder");
    }
}
