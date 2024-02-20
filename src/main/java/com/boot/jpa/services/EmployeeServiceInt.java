package com.boot.jpa.services;





import com.boot.jpa.entity.Employee;

import java.util.List;

public interface EmployeeServiceInt {
    public List<Employee> getAllEmployees();
    public void saveEmp(Employee employee);
    public Employee findById(int id);
    public void deleteEmp(int id);
    public List<Employee> findAllByName(String name);
}
