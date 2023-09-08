package home.buy.service;

import home.buy.exception.EmployeeAlreadyAddedException;
import home.buy.exception.EmployeeNotFoundException;
import home.buy.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees = new HashMap();

    @Override
    public void addEmployee(Employee employee) {
        if (employees.containsKey(employee.getFirstName() + employee.getLastName() + employee.getSalary() + employee.getDepartmentId())) {
            throw new EmployeeAlreadyAddedException("This employee has already been added");
        }
        employees.put(employee.getFirstName() + employee.getLastName(), employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName, Integer salary, Integer departmentId) {
        if (!employees.containsKey(firstName + lastName + salary + departmentId)) {
            throw new EmployeeNotFoundException("Employee has not been found");
        }
        employees.remove(firstName + lastName + salary + departmentId);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, Integer salary, Integer departmentId) {
        if (!employees.containsKey(firstName + lastName + salary + departmentId)) {
            throw new EmployeeNotFoundException("Employee has not been found");
        }
        return employees.get(firstName + lastName + salary + departmentId);
    }

    @Override
    public Collection<Employee> getAll() {
        return employees.values();
    }
}
