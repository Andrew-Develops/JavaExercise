package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //folosim employeeRepository pentru a chema metode
    //cand avem un constructor in clasa nu mai e nevoie de @Autowire
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        //aducem employee din baza de date si il punem in saveEmployee
        //daca elementul adus nu este nul(.isPresent()) inseamna ca avem deja un email in baza de date
        Optional<Employee> saveEmployee = employeeRepository.findByEmail(employee.getEmail());
        //verificam daca emailul exista DEJA in baza de date
        if (saveEmployee.isPresent()) {
            throw new ResourceNotFoundException("Employee already exist with given email: " + employee.getEmail());
        }
        //daca emailul unui employee nu se afla in baza de date atunci il adaugam
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee updatedEmployee) {
        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

}
