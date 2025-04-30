package by.peregud.initech.llc.mapper;


import by.peregud.initech.llc.dto.UserCreateDto;
import by.peregud.initech.llc.dto.UserDto;
import by.peregud.initech.llc.entity.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserCreateDto, UserDto,UserEntity>{


}

