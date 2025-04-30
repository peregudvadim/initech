package by.peregud.initech.llc.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements BaseDto{

    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate hireDate;
    private LocalDateTime createdAt;


    private String maskedPhoneNumber;
    private String maskedEmail;


    public void maskSensitiveData() {
        if (this.phoneNumber != null) {
            this.maskedPhoneNumber = "****" + this.phoneNumber.substring(this.phoneNumber.length() - 4);
        }
        if (this.email != null) {
            this.maskedEmail = this.email.substring(0, 3) + "****" + this.email.substring(this.email.indexOf("@"));
        }
    }
}
