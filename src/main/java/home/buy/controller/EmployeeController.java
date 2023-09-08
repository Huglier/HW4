package home.buy.controller;

import home.buy.model.Employee;
import home.buy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public void addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer salary, @RequestParam Integer departmentId) {
        employeeService.addEmployee(new Employee(firstName, lastName, salary, departmentId));
    }

    @GetMapping("/remove")
    public void removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer salary, @RequestParam Integer departmentId) {
        employeeService.removeEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer salary, @RequestParam Integer departmentId) {
        return employeeService.findEmployee(firstName, lastName, salary, departmentId);
    }
}
