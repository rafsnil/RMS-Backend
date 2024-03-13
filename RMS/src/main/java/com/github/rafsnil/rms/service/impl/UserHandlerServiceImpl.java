package com.github.rafsnil.rms.service.impl;

import com.github.rafsnil.rms.model.Users;
import com.github.rafsnil.rms.repository.UserRepository;
import com.github.rafsnil.rms.security.JWTService;
import com.github.rafsnil.rms.security.SpringSecurityUserDetailsService;
import com.github.rafsnil.rms.service.dto.CreateUserRequestDTO;
import com.github.rafsnil.rms.service.dto.CreateUserResponseDTO;
import com.github.rafsnil.rms.service.dto.LoginRequestDTO;
import com.github.rafsnil.rms.service.dto.UserDataDTO;
import com.github.rafsnil.rms.service.UserHandlerService;
import com.github.rafsnil.rms.service.utilities.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;

@Service
@RequiredArgsConstructor
//TODO
public class UserHandlerServiceImpl implements UserHandlerService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final SpringSecurityUserDetailsService userDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public CreateUserResponseDTO executeSignup(CreateUserRequestDTO requestDTO) throws Exception {
        Users user = CreateUserRequestDTO.mapToUserModel(requestDTO);
        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
        Users addedUser = userRepository.insert(user);
        String jwtToken = jwtService.generateToken(userDetailsService.loadUserByUsername(addedUser.getUsername()));
        return CreateUserResponseDTO.builder()
                .id(addedUser.getId().toString())
                .username(addedUser.getUsername())
                .token(jwtToken)
                .build();
    }

    @Override
    public UserDataDTO getUser(String userId) throws Exception {
        Users user = userRepository.findById(new ObjectId(userId))
                .orElseThrow(() -> new Exception(CommonUtils.getMessage("user.does-not-exist")));
        return UserDataDTO.builder()
                .id(user.getId().toString())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    @Override
    public boolean deleteUser(String userId) throws Exception {
        return false;
    }

    @Override
    public CreateUserResponseDTO updateUser(CreateUserRequestDTO updateDTO) throws Exception {
        return null;
    }

    @Override
    public String executeLogin(LoginRequestDTO requestDTO) throws Exception {
        return null;
    }
}
