package home.buy.service;

import home.buy.exception.EmployeeAlreadyAddedException;
import home.buy.exception.EmployeeNotFoundException;
import home.buy.exception.EmployeeStorageIsFullException;
import home.buy.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees = new HashMap();

    @Override
    public void addEmployee(Employee employee) {
        if (employees.containsKey(employee.getFirstName() + employee.getLastName())) {
            throw new EmployeeAlreadyAddedException("This employee has already been added");
        }
        employees.put(employee.getFirstName() + employee.getLastName(), employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Employee has not been found");
        }
            employees.remove(firstName + lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Employee has not been found");
        }
        return employees.get(firstName+lastName);
    }
}
