package by.peregud.initech.llc.mapper;


import by.peregud.initech.llc.dto.InvoiceCreateDto;
import by.peregud.initech.llc.dto.InvoiceDto;
import by.peregud.initech.llc.entity.InvoiceEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface InvoiceMapper extends BaseMapper<InvoiceCreateDto, InvoiceDto, InvoiceEntity> {


}
