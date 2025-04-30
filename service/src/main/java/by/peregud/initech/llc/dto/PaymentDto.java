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
public class PaymentDto implements BaseDto{

    private Long id;
    private Long invoiceId;
    private LocalDate paymentDate;
    private BigDecimal paymentAmount;
    private String paymentMethod;
    private LocalDateTime createdAt;
}
