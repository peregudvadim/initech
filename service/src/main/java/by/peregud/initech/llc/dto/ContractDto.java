package by.peregud.initech.llc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto implements BaseDto{

    private Long id;
    private String contractNumber;
    private String clientName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private BigDecimal totalAmount;
    private LocalDate createdAt;
}
