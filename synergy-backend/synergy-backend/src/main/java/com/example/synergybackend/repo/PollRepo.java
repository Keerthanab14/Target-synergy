package com.example.synergybackend.repo;


import com.example.synergybackend.model.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollRepo extends MongoRepository<Poll, Integer> {
}
