package home.buy.service;

import home.buy.model.Employee;


public interface EmployeeService {

    void addEmployee(Employee employee);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}
