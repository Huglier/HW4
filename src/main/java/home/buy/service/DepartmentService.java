package home.buy.service;

import home.buy.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findEmployeeMaxSalary(Integer departmentId);
    Employee findEmployeeMinSalary(Integer departmentId);
    Collection<Employee> addAllDepartmentId(Integer departmentId);
    Map <Integer, List<Employee>> getAllDepartmentIdEmployee();
}
