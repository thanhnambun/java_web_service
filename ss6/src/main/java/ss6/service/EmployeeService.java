package ss6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ss6.entity.Employee;
import ss6.reopo.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee, Long id) {
        Employee updatedEmployee = employeeRepository.findById(id).orElse(null);
        if (updatedEmployee != null) {
            updatedEmployee.setName(employee.getName());
            updatedEmployee.setEmail(employee.getEmail());
            updatedEmployee.setPosition(employee.getPosition());
            updatedEmployee.setSalary(employee.getSalary());
            return employeeRepository.save(updatedEmployee);
        }
        return null;
    }
}
