package com.github.rafsnil.rms.controller;

import com.github.rafsnil.rms.configuration.ApplicationConstants;
import com.github.rafsnil.rms.security.JWTService;
import com.github.rafsnil.rms.security.SpringSecurityUserDetailsService;
import com.github.rafsnil.rms.service.dto.LoginRequestDTO;
import com.github.rafsnil.rms.service.utilities.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApplicationConstants.BaseUrl +"login")
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private SpringSecurityUserDetailsService userDetailsService;
    private final JWTService jwtService;

    @PostMapping
    public ResponseEntity<?> executeLogin(
            @RequestBody LoginRequestDTO loginRequestDTO
            ){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getUsername());
            String jwtToken = jwtService.generateToken(userDetails);
            return CommonUtils.sendResponse(
                    HttpStatus.OK,
                    CommonUtils.getMessage("login.success"),
                    jwtToken
            );
        } catch (Exception e){
            return CommonUtils.sendResponse(
                    HttpStatus.UNAUTHORIZED,
                    e.getMessage(),
                    null
            );
        }
    }
}
