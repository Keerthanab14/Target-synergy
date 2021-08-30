package com.synergy.openEnded.repository;

import com.synergy.openEnded.model.OpenEnded;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpenEndedRepository extends MongoRepository<OpenEnded,String> {
    public List<OpenEnded> findAllByGoogleId(String id);
}
