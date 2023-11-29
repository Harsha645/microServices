package com.dailycodebuffer.departmentservice.repo;

import com.dailycodebuffer.departmentservice.model.Department;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepo {

    private List<Department> departments = new ArrayList<>();
    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }
    public Department findById(Long id) {
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll() {
        return departments;
    }
}
