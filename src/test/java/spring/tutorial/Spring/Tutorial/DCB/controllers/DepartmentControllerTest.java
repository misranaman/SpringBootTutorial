package spring.tutorial.Spring.Tutorial.DCB.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import spring.tutorial.Spring.Tutorial.DCB.entities.Department;
import spring.tutorial.Spring.Tutorial.DCB.error.DepartmentNotFoundException;
import spring.tutorial.Spring.Tutorial.DCB.services.DepartmentServices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentServices departmentServices;

    private Department department;

    @BeforeEach
    void setup() {

        department = Department.builder()
                .departmentName("Instrumental")
                .departmentCode("IS-08")
                .departmentAddress("New Delhi")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {

        Department inputDepartment = Department.builder()
                .departmentName("Instrumental")
                .departmentCode("IS-08")
                .departmentAddress("New Delhi")
                .build();

        Mockito.when(departmentServices.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"Instrumental\",\n" +
                        "    \"departmentAddress\": \"Begalore\",\n" +
                        "    \"departmentCode\": \"IS-08\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {

        Mockito.when(departmentServices.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }

    @Test
    void fetchDepartmentList() {

    }
}