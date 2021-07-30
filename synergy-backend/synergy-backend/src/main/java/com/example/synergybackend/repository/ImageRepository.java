package com.example.synergybackend.repository;

import com.example.synergybackend.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
}
