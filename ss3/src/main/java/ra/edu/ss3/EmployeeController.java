package ra.edu.ss3;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public String home(Model model,
                       @RequestParam(required = false) String phone,
                       @RequestParam(required = false) Double salary) {

        Page<Employee> employeePage;

        if (phone != null && salary != null) {
            employeePage = employeeRepository.findEmployeesBySalaryAndPhone(salary, phone, PageRequest.of(0, 10));
        } else {
            employeePage = employeeRepository.findAll(PageRequest.of(0, 10));
        }

        model.addAttribute("employeePage", employeePage);
        return "home";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }
    @PostMapping("/add")
    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
    @GetMapping("/edit")
    public String editEmployee(Model model, @RequestParam  Long employeeId) {
        Employee employee = employeeRepository.findEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "editEmployee";
    }
    @PostMapping("/edit")
    public String editEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam  Long employeeId) {
        Employee employee = employeeRepository.findEmployeeById(employeeId);
        employeeRepository.delete(employee);
        return "redirect:/employees";
    }
}
