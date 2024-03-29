package com.github.rafsnil.rms.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponseDTO {
    private String id;
    private String username;
    private String token;
}
