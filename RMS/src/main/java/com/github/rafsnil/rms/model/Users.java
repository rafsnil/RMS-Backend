package com.github.rafsnil.rms.model;

import com.github.rafsnil.rms.model.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@EqualsAndHashCode(callSuper = true)

public class Users extends BaseDocument {
    @NotBlank
    @Length(min=3)
    private String firstname;

    @NotBlank
    @Length(min=3)
    private String lastname;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    @Email
    @Indexed(unique = true)
    private String email;

    @Indexed(unique = true)
    @Length(min=5)
    private String username;

    @Length(min=8)
    private String password;

    private Roles[] role;
}
