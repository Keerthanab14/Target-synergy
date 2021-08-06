package com.example.synergybackend.repository;

import com.example.synergybackend.model.Mcq;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MCQRepository extends MongoRepository<Mcq, String> {
}
