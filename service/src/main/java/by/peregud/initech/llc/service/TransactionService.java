package by.peregud.initech.llc.service;

import by.peregud.initech.llc.dto.TransactionCreateDto;
import by.peregud.initech.llc.dto.TransactionDto;

public interface TransactionService extends BaseService<TransactionCreateDto, TransactionDto>, PageableService<TransactionDto> {
}
