package by.peregud.initech.llc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCreateDto implements BaseCreateDto{

    @NotNull(message = "InvoiceEntity number cannot be null")
    private String invoiceNumber;

    @NotNull(message = "ContractEntity ID cannot be null")
    private Long contractId;

    @NotNull(message = "InvoiceEntity date cannot be null")
    private LocalDate invoiceDate;

    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;

    @NotNull(message = "Due date cannot be null")
    private LocalDate dueDate;

    @NotNull(message = "Status cannot be null")
    private String status;
}

