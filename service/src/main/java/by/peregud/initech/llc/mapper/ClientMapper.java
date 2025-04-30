package by.peregud.initech.llc.mapper;

import by.peregud.initech.llc.dto.ClientCreateDto;
import by.peregud.initech.llc.dto.ClientDto;
import by.peregud.initech.llc.entity.ClientEntity;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface ClientMapper extends BaseMapper<ClientCreateDto, ClientDto, ClientEntity>{


}
