package com.github.rafsnil.rms.service.impl;

import com.github.rafsnil.rms.service.dto.CreateUserRequestDTO;
import com.github.rafsnil.rms.service.dto.CreateUserResponseDTO;
import com.github.rafsnil.rms.service.dto.LoginRequestDTO;
import com.github.rafsnil.rms.service.dto.UserDataDTO;
import com.github.rafsnil.rms.service.UserHandlerService;
import org.springframework.stereotype.Service;

@Service
//TODO
public class UserHandlerServiceImpl implements UserHandlerService {
    @Override
    public CreateUserResponseDTO executeSignup(CreateUserRequestDTO requestDTO) throws Exception {
        return null;
    }

    @Override
    public UserDataDTO getUser(String userId) throws Exception {
        return null;
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
