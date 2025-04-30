package by.peregud.initech.llc.mapper;

import by.peregud.initech.llc.dto.PaymentCreateDto;
import by.peregud.initech.llc.dto.PaymentDto;
import by.peregud.initech.llc.entity.PaymentEntity;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface PaymentMapper extends BaseMapper<PaymentCreateDto, PaymentDto, PaymentEntity>{


}
