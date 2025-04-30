package by.peregud.initech.llc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto implements BaseDto{

    private Long id;
    private String clientName;
    private String contactPerson;
    private String phoneNumber;
    private String email;
    private String address;
    private String industry;
    private LocalDateTime createdAt;
}
