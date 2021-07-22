package com.example.synergybackend.repo;

import com.example.synergybackend.model.Book;
import com.example.synergybackend.model.Choice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustRepo extends MongoRepository<Choice, Integer> {
}
