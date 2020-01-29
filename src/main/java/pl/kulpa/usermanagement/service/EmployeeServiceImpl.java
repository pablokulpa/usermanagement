package pl.kulpa.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.kulpa.usermanagement.exception.ResourceNotFoundException;
import pl.kulpa.usermanagement.model.Employee;
import pl.kulpa.usermanagement.repository.EmployeeRepository;
import pl.kulpa.usermanagement.repository.EmployeeSpecification;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(long employeeId) {

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee with id: " + employeeId + " doesn't exist");
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> userToDelete = employeeRepository.findById(id);

        if (userToDelete.isPresent()) {
            employeeRepository.delete(userToDelete.get());
        } else {
            throw new ResourceNotFoundException("Employee with id: " + id + " doesn't exist");
        }
    }

    @Override
    public Employee update(Employee employeeToUpdate) {

        Optional<Employee> userToDelete = employeeRepository.findById(employeeToUpdate.getId());

        if (userToDelete.isPresent()) {
            return employeeRepository.save(employeeToUpdate);
        } else {
            throw new ResourceNotFoundException("Employee with id: " + employeeToUpdate.getId() + " doesn't exist");
        }
    }

    @Override
    public List<Employee> search(Map<String, Object> search) {
        Specification<Employee> spec = new EmployeeSpecification(search);
        List<Employee> searchResult = employeeRepository.findAll(spec);
        return searchResult;
    }
}
