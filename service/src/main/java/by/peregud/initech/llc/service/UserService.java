package by.peregud.initech.llc.service;

import by.peregud.initech.llc.dto.UserCreateDto;
import by.peregud.initech.llc.dto.UserDto;


import java.util.Optional;



public interface UserService extends BaseService<UserCreateDto,UserDto>, PageableService<UserDto> {
    Optional<UserDto> save(UserCreateDto createDto);

    Optional<UserDto> update(UserDto userDto);
}