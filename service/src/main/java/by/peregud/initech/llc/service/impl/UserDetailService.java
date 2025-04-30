package by.peregud.initech.llc.service.impl;

import by.peregud.initech.llc.entity.UserEntity;
import by.peregud.initech.llc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {


    private final UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = repository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Couldn't find user by provided name!"));

        return new User(userEntity.getUsername(),userEntity.getPassword(),getAuthorities(userEntity));
    }


    private Set<GrantedAuthority> getAuthorities(UserEntity user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return grantedAuthorities;
    }
}
