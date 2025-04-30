package by.peregud.initech.llc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreateDto implements BaseCreateDto{

    @NotNull(message = "ClientEntity name cannot be null")
    private String clientName;

    private String contactPerson;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Email(message = "Email should be valid")
    private String email;

    private String address;

    private String industry;
}
