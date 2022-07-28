package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees") //furnizam un URL pentru REST APIs
public class EmployeeController {

    //Nu mai folosim @Autowired deoarece daca avem un constructor in clasa spring injecteaza dependinta automat
    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //@RequestBody foloseste HTTP message converters pentru a converti JSON in obiecte Employee
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //returnam status codul clientului, in cazul nostru CREATED
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return employeeService.getEmployeeById(employeeId) //getEmployeeById returneaza un obiect de tip Optional si putem folosi map pentru a face diferite operatiunea cu raspunsul primit
                .map(ResponseEntity::ok)    //mapeaza daca obiectul Employee exista
                .orElseGet(() -> ResponseEntity.notFound().build());    //daca nu exista returneaza notFound
    }

    @PutMapping("{id}") //bindam valoarea din paranteza {id} cu argumentul metodei: employeeId
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
        return employeeService.getEmployeeById(employeeId)
                .map(savedEmployee -> {
                    //aici updatam employee object
                    savedEmployee.setFirstName(employee.getFirstName());
                    savedEmployee.setLastName(employee.getLastName());
                    savedEmployee.setEmail(employee.getEmail());
                    //aici salvam employee object
                    Employee updatedEmployee = employeeService.updateEmployee(savedEmployee);
                    return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
                }) //savedEmployee este doar obiectul returnat din baza de date atunci cand apelezi metoda
                .orElseGet(() -> ResponseEntity.notFound().build());    //returnam not found daca nu am gasit employee cu id-ul respectiv
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }


}
