package com.CODINGWALLAH.Service;

import com.CODINGWALLAH.Entity.EmployeeEntity;
import com.CODINGWALLAH.Interfaces.Employeerepository;
import com.CODINGWALLAH.Model.Employee;
import com.CODINGWALLAH.Interfaces.employeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class employeeServiceImpl  implements employeeService {

    @Autowired
    Employeerepository employeerepository;
    List<Employee> employees = new ArrayList<>();
    private long nextId = 1;

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        EmployeeEntity savedEntity = employeerepository.save(employeeEntity);
        return "Saved Successfully with ID " + savedEntity.getId();
    }
    @Override
    public Employee readEmployee(Long id){
        EmployeeEntity employeeEntity = employeerepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }


    @Override
    public List<Employee> readEmployees() {
       List<EmployeeEntity> employeesList =  employeerepository.findAll();
       List<Employee> employees = new ArrayList<>();
        for ( EmployeeEntity employeeEntity : employeesList){
            Employee emp = new Employee();
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            emp.setId(employeeEntity.getId());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Optional<EmployeeEntity> employee = employeerepository.findById(id);
        if (employee.isPresent()) {
            employeerepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existEmp  = employeerepository.findById(id).get();

        existEmp.setEmail(employee.getEmail());
        existEmp.setName(employee.getName());
        existEmp.setPhone(employee.getPhone());

        employeerepository.save(existEmp);
        return "update Successfully";
    }
}
