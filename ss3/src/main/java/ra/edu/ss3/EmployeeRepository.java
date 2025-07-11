package ra.edu.ss3;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Page<Employee> findEmployeesByPhone(String phone,Pageable pageable);
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    Page<Employee> findEmployeesBySalary(@Param("salary") double salary,Pageable pageable);
    Page<Employee> findAll(Pageable pageable);
    @Query("select new ra.edu.ss3.EmployeeDTO(e.id,e.name,e.salary)from Employee e")
    List<EmployeeDTO> findEmployeesDTO();
    @Query("SELECT e.name AS name, e.phone AS phone, e.salary AS salary FROM Employee e")
    List<EmployeeInfo> findAllEmployeeInfo();
    @Query("SELECT e FROM Employee e WHERE e.salary > :minSalary ")
    Page<Employee> findEmployeesBySalaryAndPhone(@Param("minSalary") double minSalary,String Phone,Pageable pageable);
    Employee findEmployeeById(Long id);
}
