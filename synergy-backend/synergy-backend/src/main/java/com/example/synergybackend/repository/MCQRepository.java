package com.example.synergybackend.repository;

import com.example.synergybackend.model.Mcq;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.function.Supplier;

import java.util.List;

public interface MCQRepository extends MongoRepository<Mcq, String> {

    public List<Mcq> findAllByGoogleId(String id);

}
