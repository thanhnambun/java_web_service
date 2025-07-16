package ss6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ss6.entity.DataResponse;
import ss6.entity.Employee;
import ss6.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse<List<Employee>>> getAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok().body(new DataResponse<>(employees, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<DataResponse<Employee>> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(new DataResponse<>(employeeService.save(employee), HttpStatus.ACCEPTED), HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<DataResponse<Employee>> updateEmployee(@RequestBody Employee employee, @PathVariable Long employeeId) {
        return new ResponseEntity<>(new DataResponse<>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }
}
