package com.github.rafsnil.rms.controller;

import com.github.rafsnil.rms.configuration.ApplicationConstants;
import com.github.rafsnil.rms.service.dto.CreateUserRequestDTO;
import com.github.rafsnil.rms.service.UserHandlerService;
import com.github.rafsnil.rms.service.utilities.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApplicationConstants.BaseUrl +"signup")
public class SignUpController {
    private final UserHandlerService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> executeSignUp(
            @RequestBody CreateUserRequestDTO requestDTO) throws Exception{
        return CommonUtils.sendResponse(
                HttpStatus.CREATED,
                CommonUtils.getMessage("signup.success"),
                userService.executeSignup(requestDTO)
        );
    }
}