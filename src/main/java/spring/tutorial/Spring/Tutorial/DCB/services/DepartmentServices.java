package spring.tutorial.Spring.Tutorial.DCB.services;

import spring.tutorial.Spring.Tutorial.DCB.entities.Department;
import spring.tutorial.Spring.Tutorial.DCB.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentServices {

    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
