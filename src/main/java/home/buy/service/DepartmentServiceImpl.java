package home.buy.service;

import home.buy.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeMaxSalary(Integer departmentId) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentId(), departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("No employee department"));
    }

    @Override
    public Employee findEmployeeMinSalary(Integer departmentId) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentId(), departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("No employee department"));
    }

    @Override
    public Collection<Employee> addAllDepartmentId(Integer departmentId) {
        return employeeService.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentId(), departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllDepartmentIdEmployee() {
        return employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
