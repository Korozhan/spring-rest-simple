package com.jax.rs.controller;

import com.jax.rs.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by intel on 21.09.2016.
 */
@Controller
public class EmployeeController {

    Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

    @RequestMapping(value = "/rest/epm/create", method = RequestMethod.POST)
    public @ResponseBody Employee createEmployee(@RequestBody Employee employee) {
        employee.setDate(new Date());
        employees.put(employee.getId(), employee);
        return employee;

    }

    @RequestMapping(value = "/rest/emp/{id}", method = RequestMethod.GET)
    public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
        return employees.get(empId);

    }

    @RequestMapping(value = "/rest/emp/delete/{id}", method = RequestMethod.PUT)
    public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
        Employee emp = employees.get(empId);
        employees.remove(empId);
        return emp;
    }

    @RequestMapping(value = "/rest/emps", method = RequestMethod.GET)
    public @ResponseBody List<Employee> getAllEmployee() {
        Set<Integer> employeesId = employees.keySet();
        List<Employee> employeesList= new ArrayList<Employee>();
        for(int i:employeesId){
            employeesList.add(employees.get(i));
        }
        return employeesList;
    }
}

