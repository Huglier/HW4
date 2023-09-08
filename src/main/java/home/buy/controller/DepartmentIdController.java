package home.buy.controller;

import home.buy.model.Employee;
import home.buy.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentIdController {
    private final DepartmentService departmentService;

    public DepartmentIdController (DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalary(@RequestParam("departmentId") Integer departmentId){
        return departmentService.findEmployeeMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalary(@RequestParam("departmentId") Integer departmentId){
        return departmentService.findEmployeeMinSalary(departmentId);
    }
    @GetMapping(value = "/all", params = "departmentId")
    public Collection<Employee> addAllDepartmentId(@RequestParam("departmentId") Integer departmentId){
        return departmentService.addAllDepartmentId(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllDepartmentIdEmployee(){
        return departmentService.getAllDepartmentIdEmployee();
    }
}
