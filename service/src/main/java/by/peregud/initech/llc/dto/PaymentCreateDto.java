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
public class PaymentCreateDto implements BaseCreateDto{

    @NotNull(message = "InvoiceEntity ID cannot be null")
    private Long invoiceId;

    @NotNull(message = "PaymentEntity date cannot be null")
    private LocalDate paymentDate;

    @NotNull(message = "PaymentEntity amount cannot be null")
    private BigDecimal paymentAmount;

    private String paymentMethod;
}

