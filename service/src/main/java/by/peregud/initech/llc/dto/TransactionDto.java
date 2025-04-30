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
public class TransactionDto implements BaseDto{

    private Long id;
    private Long paymentId;
    private LocalDate transactionDate;
    private BigDecimal transactionAmount;
    private String transactionStatus;
    private LocalDateTime createdAt;
}

