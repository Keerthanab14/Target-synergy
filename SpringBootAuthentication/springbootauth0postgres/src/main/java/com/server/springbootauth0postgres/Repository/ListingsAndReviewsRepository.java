package com.server.springbootauth0postgres.Repository;

import com.server.springbootauth0postgres.Entities.ListingsAndReviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingsAndReviewsRepository extends JpaRepository<ListingsAndReviews, Long> {

}