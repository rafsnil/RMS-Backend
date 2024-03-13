package com.github.rafsnil.rms.controller;

import com.github.rafsnil.rms.configuration.ApplicationConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApplicationConstants.BaseUrl +"login")
public class LoginController {

}
