package com.CODINGWALLAH.Controller;


import com.CODINGWALLAH.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5174/")
public class EmpController {


      // List<Employee> employees = new ArrayList<>();
     //employeeService employeeService  = new employeeServiceImpl();


    // Dependency injection
    @Autowired
    com.CODINGWALLAH.Interfaces.employeeService employeeService;



    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
//        System.out.println("employees"+employees);
        return employeeService.readEmployees();
    }
    @GetMapping("employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.readEmployee(id);
    }


    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee){
//        employees.add(employee);
         return  employeeService.createEmployee(employee);

    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);

        if (deleted) {
            return ResponseEntity.ok("Deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found");
        }
    }
    @PutMapping("employees/{id}")
    public String putMethod(@PathVariable Long id, @RequestBody  Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

}
