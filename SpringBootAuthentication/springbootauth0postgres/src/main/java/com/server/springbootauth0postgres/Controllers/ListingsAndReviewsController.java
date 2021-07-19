package com.server.springbootauth0postgres.Controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.server.springbootauth0postgres.Entities.ListingsAndReviews;
import com.server.springbootauth0postgres.Repository.ListingsAndReviewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ListingsAndReviewsController {
    @Autowired
    private ListingsAndReviewsRepository listingsAndReviewsRepostiory;

    // Find all listings
    @GetMapping("/all_listings")
    public List<ListingsAndReviews> getAllListingsAndReviews() {
        return listingsAndReviewsRepostiory.findAll();
    }

    // Find a listing by ID
    @GetMapping("/find_by_id/{id}")
    public ListingsAndReviews findListingsAndReviewsByID(@PathVariable Long id) {
        return listingsAndReviewsRepostiory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find the listing with id " + id));
    }

    // Create a new listing
    @PostMapping("/add_listing")
    public ResponseEntity<String> addListingandReview(@RequestBody ListingsAndReviews newListingAndReview) {
        listingsAndReviewsRepostiory.save(newListingAndReview);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Update a listing's description
    @PutMapping("/update_listing/{id}")
    public ResponseEntity<ListingsAndReviews> updateListingAndReview(@PathVariable Long id,
            @RequestBody ListingsAndReviews changeListingAndReview) {
        // Set the found List/Review to a variable
        ListingsAndReviews updatedValue = listingsAndReviewsRepostiory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find the listing with id " + id));
        // Set the updated description
        updatedValue.setDescription(changeListingAndReview.getDescription());
        final ListingsAndReviews finalUpdatedListingAndReviews = listingsAndReviewsRepostiory.save(updatedValue);
        return ResponseEntity.ok(finalUpdatedListingAndReviews);
    }

    // Delete a listing
    @DeleteMapping("/delete_listing/{id}")
    public ResponseEntity<Long> deleteListingById(@PathVariable Long id) {
        // Set the found List/Review to a variable
        listingsAndReviewsRepostiory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find the listing with id " + id));
        // Delete the listing
        listingsAndReviewsRepostiory.deleteById(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}
