package spring.tutorial.Spring.Tutorial.DCB.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import spring.tutorial.Spring.Tutorial.DCB.entities.Department;
import spring.tutorial.Spring.Tutorial.DCB.repositories.DepartmentRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServicesTest {

    @Autowired
    private DepartmentServices departmentServices;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Ahemdabad")
                .departmentCode("IT-06")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {

        String departmentName = "IT";
        Department found = departmentServices.fetchDepartmentByName("IT");
        assertEquals(departmentName, found.getDepartmentName());

    }
}