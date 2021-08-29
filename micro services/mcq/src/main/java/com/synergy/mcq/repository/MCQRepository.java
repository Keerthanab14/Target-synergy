package com.synergy.mcq.repository;


import com.synergy.mcq.model.Mcq;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MCQRepository extends MongoRepository<Mcq, String> {
}
