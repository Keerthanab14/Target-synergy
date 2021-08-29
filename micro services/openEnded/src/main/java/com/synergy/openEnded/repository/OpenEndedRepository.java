package com.synergy.openEnded.repository;

import com.synergy.openEnded.model.OpenEnded;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenEndedRepository extends MongoRepository<OpenEnded,String> {
}
