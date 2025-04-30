package by.peregud.initech.llc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto implements BaseDto{

    private Long id;
    private String invoiceNumber;
    private Long contractId;
    private LocalDate invoiceDate;
    private BigDecimal amount;
    private LocalDate dueDate;
    private String status;
    private LocalDateTime createdAt;
}

