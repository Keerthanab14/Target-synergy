package com.example.synergybackend.repo;
import com.example.synergybackend.model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotesRepo extends MongoRepository<Vote, Integer>{
}
