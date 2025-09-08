package com.CODINGWALLAH.Interfaces;

import com.CODINGWALLAH.Model.Employee;

import java.util.List;

public interface employeeService {
    String createEmployee(Employee employee);
    Employee readEmployee(Long id);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id , Employee employee);





}
