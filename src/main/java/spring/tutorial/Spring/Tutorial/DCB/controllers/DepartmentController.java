package spring.tutorial.Spring.Tutorial.DCB.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.tutorial.Spring.Tutorial.DCB.entities.Department;
import spring.tutorial.Spring.Tutorial.DCB.error.DepartmentNotFoundException;
import spring.tutorial.Spring.Tutorial.DCB.services.DepartmentServices;

import javax.validation.Valid;
import java.util.List;


@RestController
public class DepartmentController {

    @Autowired
    DepartmentServices departmentServices;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {

        LOGGER.info("Inside fetch department of Department controller");

        departmentServices.saveDepartment(department);
        return department;
    }


    //Get request for the department
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentServices.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        return departmentServices.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {

        departmentServices.deleteDepartmentById(departmentId);
        return "Department deleted successfully" + departmentId;

    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {

        return departmentServices.updateDepartment(departmentId, department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {

        return departmentServices.fetchDepartmentByName(departmentName);

    }

}
