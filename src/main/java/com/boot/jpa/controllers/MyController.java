package com.boot.jpa.controllers;

import com.boot.jpa.entity.Employee;
import com.boot.jpa.exeption_handlers.NoSuchEmployeeException;
import com.boot.jpa.services.EmployeeServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class MyController {
    private final EmployeeServiceInt employeeService;

    @Autowired
    public MyController(EmployeeServiceInt employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getOneEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("Employee with id: " + id + " doesn't exist");
        }

        return employee;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeService.saveEmp(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee) {

        employeeService.saveEmp(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        Employee employee = getOneEmployee(id);
        if(employee == null){
            throw new NoSuchEmployeeException("Employee with id " + id + " doesn't exist");
        }
        employeeService.deleteEmp(id);
        return "Employee with id " + id + " was delete successfully";
    }

}
