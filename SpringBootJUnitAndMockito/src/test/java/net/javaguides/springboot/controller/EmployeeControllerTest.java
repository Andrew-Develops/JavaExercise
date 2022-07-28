package net.javaguides.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.ArgumentMatchers.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@WebMvcTest //incarca componentele necesare pentru a testa EmployeeController
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc; //folosim MockMvc pentru a chema REST API

    @MockBean   //ii spune Spring sa creeze un mock object EmployeeService si sa il injecteze in EmployeeController
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper; //folosit pentru serializare si deserializarea obiectelor java

    //JUnit test for Create employee REST API
    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception {
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Randy")
                .lastName("Marsh")
                .email("randy@gmail.com")
                .build();
        //trebuie sa mock metoda .saveEmployee din Controller
        //asta va returna argumentul care a fost inserat la crearea createEmployee()
        given(employeeService.saveEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // when - action or behaviour that we are going to test
        //facem un call pentru REST API
        ResultActions response = mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)));

        // then - verify the result of output using assert statement
        //verificam daca s-a creat status codul 201 in Response
        response.andDo(print())   //printam raspunsul in consola pentru o vizualizare mai buna
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName()))) //am folosit o JSONPath method pentru a verifica valorile cu expected value
                .andExpect(jsonPath("$.lastName", is(employee.getLastName())))  //$ inseamna root element
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
    }

    //JUnit test for Get All employees REST API
    @Test
    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception {

        //given - precondition or setup
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder().firstName("Randy").lastName("Marsh").email("randy@gmail.com").build());
        employeeList.add(Employee.builder().firstName("John").lastName("Cena").email("john@gmail.com").build());
        //stabbing getAllEmployees
        given(employeeService.getAllEmployees()).willReturn(employeeList);

        //when - action or the behaviour that we are going to test
        ResultActions response = mockMvc.perform(get("/api/employees"));

        //then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(employeeList.size())));  //asa obtinem marimea listei
    }

    //positive scenario - valid employee id
    //JUnit test for Get employee By ID REST API
    @Test
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject() throws Exception {
        //given - precondition or setup
        long employeeId = 1L;
        Employee employee = Employee.builder()
                .firstName("Randy")
                .lastName("Marsh")
                .email("randy@gmail.com")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(employee));

        //when - action or the behaviour that we are going to test
        ResultActions response = mockMvc.perform(get("/api/employees/{id}", employeeId));

        //then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(employee.getLastName())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
    }

    //negative scenario - valid employee id
    //JUnit test for Get employee By ID REST API
    @Test
    public void givenInvalidEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject() throws Exception {
        //given - precondition or setup
        long employeeId = 1L;
        Employee employee = Employee.builder()
                .firstName("Randy")
                .lastName("Marsh")
                .email("randy@gmail.com")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.empty());

        //when - action or the behaviour that we are going to test
        ResultActions response = mockMvc.perform(get("/api/employees/{id}", employeeId));

        //then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());
    }

    //JUnit test for updateEmployee REST API - positive scenario
    @Test
    public void givenUpdatedEmployee_whenUpdateEmployee_thenReturnUpdatedEmployeeObject() throws Exception {
        //given - precondition or setup
        long employeeId = 1L;
        Employee savedEmployee = Employee.builder()
                .firstName("Randy")
                .lastName("Marsh")
                .email("randy@gmail.com")
                .build();

        Employee updatedEmployee = Employee.builder()
                .firstName("Tony")
                .lastName("Stark")
                .email("tony@gmail.com")
                .build();
        //trebuie sa stab 2 metode, una pentru getEmployeeById cealalta pentru updateEmployee
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(savedEmployee));
        given(employeeService.updateEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when - action or the behaviour that we are going to test
        ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)));

        //then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(updatedEmployee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(updatedEmployee.getLastName())))
                .andExpect(jsonPath("$.email", is(updatedEmployee.getEmail())));

    }

    //JUnit test for updateEmployee REST API - negative scenario
    @Test
    public void givenUpdatedEmployee_whenUpdateEmployee_thenReturnStatusCode404() throws Exception {
        //given - precondition or setup
        long employeeId = 1L;
        Employee savedEmployee = Employee.builder()
                .firstName("Randy")
                .lastName("Marsh")
                .email("randy@gmail.com")
                .build();

        Employee updatedEmployee = Employee.builder()
                .firstName("Tony")
                .lastName("Stark")
                .email("tony@gmail.com")
                .build();
        //trebuie sa stab 2 metode, una pentru getEmployeeById cealalta pentru updateEmployee
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.empty());
        given(employeeService.updateEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        //when - action or the behaviour that we are going to test
        ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)));

        //then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());

    }

    //JUnit test for deleteEmployee REST API
    @Test
    public void givenEmployeeId_whenDeleteEmployee_thenReturn200() throws Exception {
        //given - precondition or setup
        //deleteEmployee method returneaza void astfel folosim willDoNothing()
        long employeeId = 1L;
        willDoNothing().given(employeeService).deleteEmployee(employeeId);

        //when - action or the behaviour that we are going to test
        ResultActions response = mockMvc.perform(delete("/api/employees/{id}", employeeId));

        //then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());

    }
}
