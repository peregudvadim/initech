package by.peregud.initech.llc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentCreateDto implements BaseCreateDto{

    @NotNull(message = "DepartmentEntity name cannot be null")
    private String departmentName;

    @NotNull(message = "Manager ID cannot be null")
    private Long managerId;
}
