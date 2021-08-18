package com.example.synergybackend.repository;
import com.example.synergybackend.model.WordCloudResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface WordCloudResponseRespository extends MongoRepository<WordCloudResponse, Long>  {
}
