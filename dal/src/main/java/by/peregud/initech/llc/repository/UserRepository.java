package by.peregud.initech.llc.repository;

import by.peregud.initech.llc.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity>{


    boolean existsByUsername(String name);
    boolean existsByEmail(String email);

    Optional<UserEntity> findByUsername(String username);
}
