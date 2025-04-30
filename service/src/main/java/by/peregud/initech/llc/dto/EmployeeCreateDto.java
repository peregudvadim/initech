package by.peregud.initech.llc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateDto implements BaseCreateDto{

    @NotNull(message = "First name cannot be null")
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name can contain only Latin letters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Last name can contain only Latin letters")
    private String lastName;

    @NotNull(message = "Position cannot be null")
    @Pattern(regexp = "^[A-Za-z-]+$", message = "Position can contain only Latin letters and hyphens")
    private String position;

    @Pattern(regexp = "^[A-Za-z]*$", message = "DepartmentEntity can contain only Latin letters")
    private String department;

    @Pattern(regexp = "^[+\\d]{1,3}[\\d]{1,15}$", message = "Phone number must be a valid phone number")
    private String phoneNumber;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    private LocalDate dateOfBirth;

    private LocalDate hireDate;
}

