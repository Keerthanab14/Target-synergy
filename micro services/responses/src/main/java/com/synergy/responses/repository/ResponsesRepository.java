package com.synergy.responses.repository;

import com.synergy.responses.model.Responses;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponsesRepository extends MongoRepository<Responses,String> {
    public Responses findByQuestion(String id);
}
