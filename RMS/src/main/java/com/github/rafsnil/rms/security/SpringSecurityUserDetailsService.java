package com.github.rafsnil.rms.security;

import com.github.rafsnil.rms.model.Users;
import com.github.rafsnil.rms.repository.UserRepository;
import com.github.rafsnil.rms.service.utilities.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpringSecurityUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException(CommonUtils.getMessage("error.user-details-service"));
        }
        List<GrantedAuthority> grantedAuthorities = Arrays.stream(user.getRole())
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
