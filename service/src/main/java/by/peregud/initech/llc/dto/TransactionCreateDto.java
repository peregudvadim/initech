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
public class TransactionCreateDto implements BaseCreateDto{

    @NotNull(message = "PaymentEntity ID cannot be null")
    private Long paymentId;

    @NotNull(message = "TransactionEntity date cannot be null")
    private LocalDate transactionDate;

    @NotNull(message = "TransactionEntity amount cannot be null")
    private BigDecimal transactionAmount;

    @NotNull(message = "TransactionEntity status cannot be null")
    private String transactionStatus;
}
