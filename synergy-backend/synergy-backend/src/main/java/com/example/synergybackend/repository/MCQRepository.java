package com.example.synergybackend.repository;

import com.example.synergybackend.model.Mcq;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MCQRepository extends MongoRepository<Mcq, String> {

    public List<Mcq> findAllByGoogleId(String id);

}
