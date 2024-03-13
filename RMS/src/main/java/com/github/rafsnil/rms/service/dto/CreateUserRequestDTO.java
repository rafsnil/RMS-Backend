package com.github.rafsnil.rms.service.dto;

import com.github.rafsnil.rms.model.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDTO {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private Roles role;
}
