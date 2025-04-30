package by.peregud.initech.llc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractCreateDto implements BaseCreateDto{

    @NotNull(message = "ContractEntity number cannot be null")
    @Pattern(regexp = "^[A-Za-z0-9-]+$", message = "ContractEntity number can contain only Latin letters, numbers, and hyphens")
    private String contractNumber;

    @NotNull(message = "ClientEntity name cannot be null")
    private String clientName;

    @NotNull(message = "Start date cannot be null")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null")
    private LocalDate endDate;

    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Status can contain only Latin letters")
    private String status;

    @NotNull(message = "Total amount cannot be null")
    private BigDecimal totalAmount;
}
