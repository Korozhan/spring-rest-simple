package com.jax.rs.controller;

import com.jax.rs.model.Employee;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

public class TestEmployeeController {

    public static void main(String[] args) {

        testCreateEmployee();
        testGetEmployee();
        testGetAll();

    }

    private static void testCreateEmployee() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Johnnn");
        RestTemplate restEmp = new RestTemplate();
        Employee response = restEmp.postForObject("http://localhost:9090/SpringRest/rest/emp/create", emp, Employee.class);
        System.out.println(response);
        System.out.println("John created!");
    }

    private static void testGetEmployee() {
        RestTemplate restEmp = new RestTemplate();
        Employee employee = restEmp.getForObject("http://localhost:56088/SpringRest/rest/emp/1", Employee.class);
        System.out.println(employee);
        System.out.println("Employee 1");
    }

    private static void testGetAll() {
        RestTemplate restEmp = new RestTemplate();
        List<LinkedHashMap> employees = restEmp.getForObject("http://localhost:8080/springRest/rest/emps", List.class);
        for (LinkedHashMap emp : employees) {
            System.out.println("id = " + emp.get("id") + " name = " + emp.get("name") + "date = " + emp.get("date"));
        }
    }

}