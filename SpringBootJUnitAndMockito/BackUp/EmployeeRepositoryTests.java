package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired //folosim @Autowired pentru a injecta employee repository
    private EmployeeRepository employeeRepository;

    private Employee employee;


    //JUnit test for save employee operation
    @DisplayName("JUnit test for save employee operation")
    //folosim @DisplayName cand vrem sa ii dam un Alias metodei noastre
    @Test   //folosim @Test pentru a-i permite JUnit sa identifice aceasta metoda ca fiind un JUnit test case
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Andrew")
                .lastName("Right")
                .email("andrew@gmail.com")
                .build();

        //when - action or the behaviour that we are going to test
        Employee saveEmployee = employeeRepository.save(employee);

        //then - verify the output
        //folosim Assertion din org.assertj.core.api sau facem metoda assertThat statica schimband importul in static si .assertThat la sfarsit
        assertThat(saveEmployee).isNotNull();   //verificam daca obiectul saveEmployee este gol
        assertThat(saveEmployee.getId()).isGreaterThan(0);   //verificam daca primary key este mai mare decat 0
    }

    //JUnit test for get all employees operation
    @DisplayName("JUnit test for get all employees operation")
    @Test
    public void givenEmployeesList_whenFindAll_thenEmployeesList() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Andrew")
                .lastName("Right")
                .email("andrew@gmail.com")
                .build();

        Employee employee1 = Employee.builder()
                .firstName("John")
                .lastName("Mike")
                .email("mike@gmail.com")
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        //when - action or the behaviour that we are going to test
        List<Employee> employeeList = employeeRepository.findAll();

        //then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    //JUnit test for get employee by id operation
    @DisplayName("JUnit test for get employee by id operation")
    @Test
    public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Andrew")
                .lastName("Right")
                .email("andrew@gmail.com")
                .build();

        employeeRepository.save(employee);
        //when - action or the behaviour that we are going to test
        Employee employeeDB = employeeRepository.findById(employee.getId()).get();

        //then - verify the output
        assertThat(employeeDB).isNotNull();

    }

    //JUnit test for get employee by email operation
    @DisplayName("JUnit test for get employee by email operation")
    @Test
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Andrew")
                .lastName("Wasabi")
                .email("andrew@gmail.com")
                .build();

        employeeRepository.save(employee);

        //when - action or the behaviour that we are going to test
        Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();

        //then - verify the output
        assertThat(employeeDB).isNotNull();

    }

    //JUnit test for update employee operation
    @DisplayName("JUnit test for update employee operation")
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenUpdateEmployee() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Michael")
                .lastName("Mos")
                .email("michael@gmail.com")
                .build();

        employeeRepository.save(employee);

        //when - action or the behaviour that we are going to test
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setEmail("mike@gmail.com");
        savedEmployee.setFirstName("Mike");
        Employee updatedEmployee = employeeRepository.save(savedEmployee);

        //then - verify the output
        assertThat(updatedEmployee.getEmail()).isEqualTo("mike@gmail.com");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Mike");
    }

    //JUnit test for delete employee operation
    @DisplayName("JUnit test for delete employee operation")
    @Test
    public void givenEmployeeObject_whenDelete_thenRemoveEmployee() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Mike")
                .email("mike@gmail.com")
                .build();

        employeeRepository.save(employee);

        //when - action or the behaviour that we are going to test
        employeeRepository.deleteById(employee.getId());
        //metoda findById returneaza un Optional
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

        //then - verify the output
        assertThat(employeeOptional).isEmpty();
    }

    //JUnit test for custom query using JPQL with index
    @DisplayName("JUnit test for custom query using JPQL with index")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnEmployeeObject() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Mike")
                .email("mike@gmail.com")
                .build();

        employeeRepository.save(employee);
        String firstName = "John";
        String lastName = "Mike";

        //when - action or the behaviour that we are going to test
        //Employee savedEmployee = employeeRepository.findByJPQL(firstName, lastName);
        Employee savedEmployee = employeeRepository.findByJPQL(employee.getFirstName(), employee.getLastName());

        //then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    //JUnit test for custom query using JPQL with Named params
    @DisplayName("JUnit test for custom query using JPQL with Named params")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQLNamedParams_thenReturnEmployeeObject() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Mike")
                .email("mike@gmail.com")
                .build();

        employeeRepository.save(employee);
        String firstName = "John";
        String lastName = "Mike";

        //when - action or the behaviour that we are going to test
        //Employee savedEmployee = employeeRepository.findByJPQLNamedParams(firstName, lastName);
        Employee savedEmployee = employeeRepository.findByJPQLNamedParams(employee.getFirstName(), employee.getLastName());

        //then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    //JUnit test for custom query using native SQL with index
    @DisplayName("JUnit test for custom query using native SQL with index")
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSQL_thenReturnEmployeeObject() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Mike")
                .email("mike@gmail.com")
                .build();

        employeeRepository.save(employee);
        String firstName = "John";
        String lastName = "Mike";

        //when - action or the behaviour that we are going to test
        //Employee savedEmployee = employeeRepository.findByNativeSQL(firstName, lastName);
        Employee savedEmployee = employeeRepository.findByNativeSQL(employee.getFirstName(), employee.getLastName());

        //then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    //JUnit test for custom query using native SQL with named params
    @DisplayName("JUnit test for custom query using native SQL with named params")
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSQLNamedParam_thenReturnEmployeeObject() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Mike")
                .email("mike@gmail.com")
                .build();

        employeeRepository.save(employee);
        String firstName = "John";
        String lastName = "Mike";

        //when - action or the behaviour that we are going to test
        //Employee savedEmployee = employeeRepository.findByNativeSQLNamedParams(firstName, lastName);
        Employee savedEmployee = employeeRepository.findByNativeSQLNamedParams(employee.getFirstName(), employee.getLastName());

        //then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

}

