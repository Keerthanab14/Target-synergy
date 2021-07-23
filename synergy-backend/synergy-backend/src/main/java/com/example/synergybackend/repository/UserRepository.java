package com.example.synergybackend.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.synergybackend.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {
    @Override
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
}
