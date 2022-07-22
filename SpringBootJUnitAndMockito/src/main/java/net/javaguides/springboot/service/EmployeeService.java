package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    //cream o metoda care o sa fie override de clasa Impl
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(long id);

    Employee updateEmployee(Employee updatedEmployee);

    void deleteEmployee(long id);
}
