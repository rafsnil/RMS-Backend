package com.github.rafsnil.rms.repository;

import com.github.rafsnil.rms.model.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, ObjectId> {
   Users findByUsername(String id);
}
