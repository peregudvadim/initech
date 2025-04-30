package by.peregud.initech.llc.mapper;

import by.peregud.initech.llc.dto.ContractCreateDto;
import by.peregud.initech.llc.dto.ContractDto;
import by.peregud.initech.llc.entity.ContractEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ContractMapper extends BaseMapper<ContractCreateDto, ContractDto, ContractEntity> {

}
