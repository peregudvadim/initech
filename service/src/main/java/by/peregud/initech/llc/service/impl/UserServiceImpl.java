package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.dto.UserCreateDto;
import by.peregud.initech.llc.dto.UserDto;
import by.peregud.initech.llc.entity.UserEntity;
import by.peregud.initech.llc.exception.UserExistException;
import by.peregud.initech.llc.mapper.UserMapper;
import by.peregud.initech.llc.model.enums.Role;
import by.peregud.initech.llc.repository.UserRepository;
import by.peregud.initech.llc.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@CacheConfig(cacheNames = "users")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserCreateDto, UserDto, UserEntity> implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;




    public UserServiceImpl(UserRepository repository, UserMapper mapper, PasswordEncoder passwordEncoder) {

        super(repository, mapper);
        this.mapper = mapper;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<UserDto> save(UserCreateDto createDto) {

        isAlreadyExists(createDto);

        UserEntity userEntity = mapper.toEntity(createDto);
        userEntity.setRole(Role.USER);
        userEntity.setPassword(passwordEncoder.encode(createDto.getPassword()));
        UserEntity saved = repository.save(userEntity);
        return Optional.of(mapper.toDto(saved));

    }


    @Override
    protected String getDefaultSortField() {
        return CLIENT_NAME;
    }



    @Override
    public Optional<UserDto> update(UserDto dto) {
        return super.update(dto);
    }

    private void isAlreadyExists(UserCreateDto createDto) {

        boolean userNameExists = repository.existsByUsername(createDto.getUsername());
        boolean emailExists = repository.existsByEmail(createDto.getEmail());

        if (userNameExists && emailExists) {
            throw new UserExistException("Both username and email are already in use.");
        } else if (userNameExists) {
            throw new UserExistException("Username is already taken.");
        } else if (emailExists) {
            throw new UserExistException("Email is already registered.");
        }


    }

}
