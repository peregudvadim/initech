package by.peregud.initech.llc.service;

import by.peregud.initech.llc.dto.ClientCreateDto;
import by.peregud.initech.llc.dto.ClientDto;

public interface ClientService extends BaseService<ClientCreateDto, ClientDto>, PageableService<ClientDto> {

}
