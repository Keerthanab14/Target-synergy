package com.springbootauth0mongodb.server.Repository;

import com.springbootauth0mongodb.server.Entities.InventoryEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<InventoryEntity, String> {

}