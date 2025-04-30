package by.peregud.initech.llc.service;

import by.peregud.initech.llc.dto.PaymentCreateDto;
import by.peregud.initech.llc.dto.PaymentDto;

public interface PaymentService extends BaseService<PaymentCreateDto, PaymentDto>, PageableService<PaymentDto> {
}
