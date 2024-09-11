package org.ritpl.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 3,max= 20 ,message = "FullName should be between 3 char to 20 char max")
    @NotBlank(message = "Full name cannot be blank")
    @Column(name = "full_name")
//    @JsonProperty("full_name")
    private String fullName;

//    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

//    @Pattern(regexp =  "^[6-9]\\d{9}$", message = "Phone number must be 10 digits")
//    @NotNull(message = "Phone number cannot be null")

    @Min(value = 6000000000L, message = "Phone number should be valid")
    @Max(value = 9999999999L, message = "Phone number should be valid")
    private long phone;

    @NotBlank(message = "Technology type cannot be blank")
    @Column(name = "technology_type")
    private String technologyType;

    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be positive")
    private Double salary;

    private LocalDate joinDate;


    // Getters and Setters

}
