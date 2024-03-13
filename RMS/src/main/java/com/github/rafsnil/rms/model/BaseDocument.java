package com.github.rafsnil.rms.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Document
@Data
@Builder
public class BaseDocument implements Serializable {
    @Serial
    private static final long serialVersionUID = 8571261118900116242L;
    @Id
    private Object id;
    private Instant createdAt;
    private Instant updatedAt;
}
