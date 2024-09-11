package org.ritpl.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDto {

    private String fullName;

    private String email;

    private long phone;

    private String technologyType;

    private double salary;


}
