package com.dailycodebuffer.employeeservice.controller;

import com.dailycodebuffer.employeeservice.model.Employee;
import com.dailycodebuffer.employeeservice.repo.EmployeeRepo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;


@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    private static final Logger LOGGER
            =  LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping
    public Employee addDepartment(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}", employee);
        return employeeRepo.addEmployee(employee);
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee find : id={} ", id);
        return employeeRepo.findById(id);
    }
    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employee find");
        return employeeRepo.findAll();
    }
    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return employeeRepo.findByDepartment(departmentId);
    }
}
