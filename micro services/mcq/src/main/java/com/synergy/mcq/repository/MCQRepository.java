package com.synergy.mcq.repository;


import com.synergy.mcq.model.Mcq;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MCQRepository extends MongoRepository<Mcq, String> {
    public List<Mcq> findAllByGoogleId(String id);
}
