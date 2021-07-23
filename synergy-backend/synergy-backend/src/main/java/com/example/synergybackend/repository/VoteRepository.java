package com.example.synergybackend.repository;
import com.example.synergybackend.model.Vote;
import com.example.synergybackend.model.ChoiceCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.synergybackend.model.Vote;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface VoteRepository extends MongoRepository<Vote, Long> {
    @Query("")
    List<ChoiceCount> countByPollIdInGroupByChoiceId(@Param("pollIds") List<Long> pollIds);

    @Query("")
    List<ChoiceCount> countByPollIdGroupByChoiceId(@Param("pollId") Long pollId);

    @Query("")
    List<Vote> findByUserIdAndPollIdIn(@Param("userId") Long userId, @Param("pollIds") List<Long> pollIds);

    @Query("")
    Vote findByUserIdAndPollId(@Param("userId") Long userId, @Param("pollId") Long pollId);

    @Query("")
    long countByUserId(@Param("userId") Long userId);

    @Query("")
    Page<Long> findVotedPollIdsByUserId(@Param("userId") Long userId, Pageable pageable);
}

