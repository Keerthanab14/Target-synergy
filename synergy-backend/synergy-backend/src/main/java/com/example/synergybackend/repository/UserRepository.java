package com.example.synergybackend.repository;
import com.example.synergybackend.model.OpenEnded;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.synergybackend.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByGoogleId(String googleId);
}
