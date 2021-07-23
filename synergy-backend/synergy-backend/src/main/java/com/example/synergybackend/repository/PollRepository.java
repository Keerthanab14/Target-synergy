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
public interface PollRepository extends  MongoRepository<Poll, Long>{
    Optional<Poll> findById(Long pollId);
    Page<Poll> findByCreatedBy(Long userId, Pageable pageable);

    long countByCreatedBy(Long userId);

    List<Poll> findByIdIn(List<Long> pollIds);

    List<Poll> findByIdIn(List<Long> pollIds, Sort sort);

}
