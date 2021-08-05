package com.example.synergybackend.repository;
import com.example.synergybackend.model.Poll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.synergybackend.model.Poll;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface PollRepository extends  MongoRepository<Poll, String>{


}
