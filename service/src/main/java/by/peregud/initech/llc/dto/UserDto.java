package by.peregud.initech.llc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements BaseDto{

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String role;

}

