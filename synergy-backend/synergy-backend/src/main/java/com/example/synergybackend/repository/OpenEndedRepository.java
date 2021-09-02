package com.example.synergybackend.repository;

import com.example.synergybackend.model.OpenEnded;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OpenEndedRepository extends MongoRepository<OpenEnded,String> {
    public List<OpenEnded> findAllByGoogleId(String id);
}
