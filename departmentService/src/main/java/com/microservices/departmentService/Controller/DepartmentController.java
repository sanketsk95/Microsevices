package com.microservices.departmentService.Controller;

import com.microservices.departmentService.Enitity.Department;
import com.microservices.departmentService.Service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
    log.info("inside save department of controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        log.info("inside get Byd id department of controller");
        return departmentService.getDepartmentById(departmentId);

    }

}
