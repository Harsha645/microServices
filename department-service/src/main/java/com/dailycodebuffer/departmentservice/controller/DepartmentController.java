package com.dailycodebuffer.departmentservice.controller;

import com.dailycodebuffer.departmentservice.model.Department;
import com.dailycodebuffer.departmentservice.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {
    private static final Logger LOGGER
            =  LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepo departmentRepo;
    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        return departmentRepo.addDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department find : id={} ", id);
        return departmentRepo.findById(id);
    }
    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department fine");
        return departmentRepo.findAll();
    }
}
