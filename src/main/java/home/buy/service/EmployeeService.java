package home.buy.service;

import home.buy.model.Employee;

import java.util.Collection;


public interface EmployeeService {

    void addEmployee(Employee employee);

    void removeEmployee(String firstName, String lastName, Integer salary, Integer department);

    Employee findEmployee(String firstName, String lastName, Integer salary, Integer department);

    Collection<Employee> getAll();
}
