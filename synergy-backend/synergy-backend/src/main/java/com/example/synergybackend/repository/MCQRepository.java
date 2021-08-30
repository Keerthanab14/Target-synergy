package com.example.synergybackend.repository;

import com.example.synergybackend.model.Mcq;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.function.Supplier;

import java.util.List;

public interface MCQRepository extends MongoRepository<Mcq, String> {
<<<<<<< HEAD

=======
    public List<Mcq> findAllByGoogleId(String id);
>>>>>>> 5048b93294c2074950f7ed36b18fd1e5c240a372
}
