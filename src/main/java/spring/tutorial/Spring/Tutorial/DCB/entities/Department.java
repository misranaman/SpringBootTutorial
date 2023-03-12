package spring.tutorial.Spring.Tutorial.DCB.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;

    @NotBlank(message = "Please add department name")
//    @Length(max = 5, min = 1)
//    @Size(max = 10, min = 2)
//    @Email
//    @PositiveOrZero
//    @NegativeOrZero
//    @Past
//    @Future
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
