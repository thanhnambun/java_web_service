package ss6.reopo;

import org.springframework.data.jpa.repository.JpaRepository;
import ss6.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
