package com.example.synergybackend.repository;

import com.example.synergybackend.model.Responses;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ResponsesRepository extends MongoRepository<Responses,String> {
}
