package com.server.springbootauth0mysql.Repository;

import com.server.springbootauth0mysql.Entities.Todos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todos, Long> {
}