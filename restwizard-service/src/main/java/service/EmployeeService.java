package service;

import domain.Employee;
import repository.EmlooyeeRepository;

import java.util.List;

/**
 *
 */
public class EmployeeService {

    private EmlooyeeRepository eplooyeeRepository;

    public EmployeeService(EmlooyeeRepository eplooyeeRepository) {
        this.eplooyeeRepository = eplooyeeRepository;
    }

    public List<Employee> getEmp() {
        return eplooyeeRepository.list();
    }

    public Employee getEmp(Long id) {
        return eplooyeeRepository.getById(id);
    }
}
