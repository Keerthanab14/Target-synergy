package com.example.synergybackend.repo;

import com.example.synergybackend.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Book, Integer>{

}