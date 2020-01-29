package pl.kulpa.usermanagement.service;

import pl.kulpa.usermanagement.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee getEmployeeById(long id);

    Employee createEmployee(Employee employee);

    void deleteEmployee(long id);

    Employee update(Employee employeeToUpdate);

    List<Employee> search(Map<String, Object> search);
}
