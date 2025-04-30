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
public class DepartmentDto implements BaseDto{

    private Long id;
    private String departmentName;
    private Long managerId;
    private LocalDateTime createdAt;
}

