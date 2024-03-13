package com.github.rafsnil.rms.configuration;

import com.mongodb.client.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import java.util.Objects;

@Configuration
@AllArgsConstructor
public class MongoDBConfig {
    private final MongoClient mongoClient;
    private final Environment environment;

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient, Objects.requireNonNull(environment.getProperty("spring.data.mongodb.database")));
    }

    @Autowired
    public void setMapKeyDotReplacement(MappingMongoConverter mongoConverter){
        mongoConverter.setMapKeyDotReplacement("#");
    }
}
