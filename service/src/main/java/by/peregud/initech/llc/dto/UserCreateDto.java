package by.peregud.initech.llc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto implements BaseCreateDto{

    @NotNull(message = "First name cannot be null")
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name can contain only Latin letters")
    private String firstname;

    @NotNull(message = "Last name cannot be null")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Last name can contain only Latin letters")
    private String lastname;

    @NotNull(message = "Username cannot be null")
    @Pattern(regexp = "^[A-Za-z0-9_]+$", message = "Username can contain only letters, numbers and underscores")
    private String username;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Password cannot be null")
    private String password;


}
