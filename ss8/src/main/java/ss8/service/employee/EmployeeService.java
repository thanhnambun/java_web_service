package ss8.service.employee;


import ss8.model.dto.EmployeeDTO;
import ss8.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(EmployeeDTO dto);
    Employee update(Long id, EmployeeDTO dto);
    void delete(Long id);
    List<Employee> findAll();
}
