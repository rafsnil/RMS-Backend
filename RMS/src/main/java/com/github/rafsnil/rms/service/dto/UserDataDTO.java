package com.github.rafsnil.rms.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDTO {
    private String id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String username;
}
