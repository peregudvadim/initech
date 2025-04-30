package by.peregud.initech.llc.service;

import by.peregud.initech.llc.dto.InvoiceCreateDto;
import by.peregud.initech.llc.dto.InvoiceDto;

public interface InvoiceService extends BaseService<InvoiceCreateDto, InvoiceDto>, PageableService<InvoiceDto> {
}
