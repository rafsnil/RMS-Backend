package com.github.rafsnil.rms.service;

import com.github.rafsnil.rms.service.dto.CreateUserRequestDTO;
import com.github.rafsnil.rms.service.dto.CreateUserResponseDTO;
import com.github.rafsnil.rms.service.dto.LoginRequestDTO;
import com.github.rafsnil.rms.service.dto.UserDataDTO;

public interface UserHandlerService {
    CreateUserResponseDTO executeSignup(CreateUserRequestDTO requestDTO) throws Exception;
    UserDataDTO getUser(String userId) throws Exception;
    boolean deleteUser(String userId) throws Exception;
    CreateUserResponseDTO updateUser(CreateUserRequestDTO updateDTO) throws Exception;
    String executeLogin(LoginRequestDTO requestDTO) throws Exception;
}
