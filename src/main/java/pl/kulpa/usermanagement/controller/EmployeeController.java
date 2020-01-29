package pl.kulpa.usermanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kulpa.usermanagement.model.Employee;
import pl.kulpa.usermanagement.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }

    @DeleteMapping("/employees/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee updatedEmployee) {
        updatedEmployee.setId(id);
        return ResponseEntity.ok().body(employeeService.update(updatedEmployee));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> search(@RequestBody Map<String, Object> search) {
        return ResponseEntity.ok().body(employeeService.search(search));
    }
}
