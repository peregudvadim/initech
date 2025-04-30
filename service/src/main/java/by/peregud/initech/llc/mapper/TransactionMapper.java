package by.peregud.initech.llc.mapper;

import by.peregud.initech.llc.dto.TransactionCreateDto;
import by.peregud.initech.llc.dto.TransactionDto;
import by.peregud.initech.llc.entity.TransactionEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TransactionMapper extends BaseMapper<TransactionCreateDto, TransactionDto, TransactionEntity>{



}
