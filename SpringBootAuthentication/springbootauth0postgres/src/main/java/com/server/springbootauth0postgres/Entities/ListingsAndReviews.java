package com.server.springbootauth0postgres.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "listingsandreviews")
public class ListingsAndReviews {
	private long id;

	@NotNull(message = "Listing URL cannot be empty")
	@Size(min = 1, message = "Listing URL is too short")
	private String listing_url;

	@NotNull(message = "Name cannot be empty")
	@Size(min = 2, message = "Name is too short")
	private String name;

	@NotNull(message = "Space cannot be empty")
	@Size(min = 1, message = "Space is too short")
	private String space;

	@NotNull(message = "Description cannot be empty")
	@Size(min = 1, message = "Description is too short")
	private String description;

	@NotNull(message = "Neighborhood overview cannot be empty")
	@Size(min = 1, message = "Neighborhood overview is too short")
	private String neighborhood_overview;

	@NotNull(message = "Notes cannot be empty")
	@Size(min = 1, message = "Notes is too short")
	private String notes;

	@NotNull(message = "Transit cannot be empty")
	@Size(min = 1, message = "Transit is too short")
	private String transit;

	@NotNull(message = "Access cannot be empty")
	@Size(min = 1, message = "Access is too short")
	private String access;

	@NotNull(message = "Interaction cannot be empty")
	@Size(min = 1, message = "Interaction is too short")
	private String interaction;

	@NotNull(message = "House rules cannot be empty")
	@Size(min = 1, message = "House rules is too short")
	private String house_rules;

	@NotNull(message = "Property type cannot be empty")
	@Size(min = 1, message = "Property type is too short")
	private String property_type;

	@NotNull(message = "Room type cannot be empty")
	@Size(min = 1, message = "Room type is too short")
	private String room_type;

	@NotNull(message = "Bed type cannot be empty")
	@Size(min = 1, message = "Bed type is too short")
	private String bed_type;

	@NotNull(message = "Minimum nights cannot be empty")
	@Size(min = 1, message = "Minimum nights is too short")
	private String minimum_nights;

	@NotNull(message = "Maximum nights cannot be empty")
	@Size(min = 1, message = "Maximum nights is too short")
	private String maximum_nights;

	@NotNull(message = "Cancellation Policy cannot be empty")
	@Size(min = 1, message = "Cancellation Policy is too short")
	private String cancellation_policy;

	@NotNull(message = "Last scraped cannot be empty")
	@Size(min = 1, message = "Last scraped is too short")
	private String last_scraped;

	@NotNull(message = "Calendar last scraped cannot be empty")
	@Size(min = 1, message = "Calendar last scraped is too short")
	private String calendar_last_scraped;

	@NotNull(message = "First review cannot be empty")
	@Size(min = 1, message = "First review is too short")
	private String first_review;

	@NotNull(message = "Last review cannot be empty")
	@Size(min = 1, message = "Last review is too short")
	private String last_review;

	@NotNull(message = "Accommodates cannot be empty")
	@Min(0)
	private Integer accommodates;

	@NotNull(message = "Bedrooms cannot be empty")
	@Min(0)
	private Integer bedrooms;

	@NotNull(message = "Beds cannot be empty")
	@Min(0)
	private Integer beds;

	@NotNull(message = "Number of reviews cannot be empty")
	@Min(0)
	private Integer number_of_reviews;

	@NotNull(message = "Bathrooms cannot be empty")
	@Size(min = 1, message = "Bathrooms is too short")
	private String bathrooms;

	@NotNull(message = "Price cannot be empty")
	@Size(min = 1, message = "Price is too short")
	private String price;

	@NotNull(message = "Amenities cannot be empty")
	@Size(min = 1, message = "Amenities is too short")
	private String amenities;

	@NotNull(message = "Security cannot be empty")
	@Size(min = 1, message = "Security is too short")
	private String security_deposit;

	@NotNull(message = "Cleaning fee cannot be empty")
	@Size(min = 1, message = "Cleaning fee is too short")
	private String cleaning_fee;

	@NotNull(message = "Extra people cannot be empty")
	@Size(min = 1, message = "Extra people is too short")
	private String extra_people;

	@NotNull(message = "Number of reviews cannot be empty")
	@Min(0)
	private Integer guests_included;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getListing_url() {
		return listing_url;
	}

	public void setListing_url(String listing_url) {
		this.listing_url = listing_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNeighborhood_overview() {
		return neighborhood_overview;
	}

	public void setNeighborhood_overview(String neighborhood_overview) {
		this.neighborhood_overview = neighborhood_overview;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTransit() {
		return transit;
	}

	public void setTransit(String transit) {
		this.transit = transit;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getInteraction() {
		return interaction;
	}

	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}

	public String getHouse_rules() {
		return house_rules;
	}

	public void setHouse_rules(String house_rules) {
		this.house_rules = house_rules;
	}

	public String getProperty_type() {
		return property_type;
	}

	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getBed_type() {
		return bed_type;
	}

	public void setBed_type(String bed_type) {
		this.bed_type = bed_type;
	}

	public String getMinimum_nights() {
		return minimum_nights;
	}

	public void setMinimum_nights(String minimum_nights) {
		this.minimum_nights = minimum_nights;
	}

	public String getMaximum_nights() {
		return maximum_nights;
	}

	public void setMaximum_nights(String maximum_nights) {
		this.maximum_nights = maximum_nights;
	}

	public String getCancellation_policy() {
		return cancellation_policy;
	}

	public void setCancellation_policy(String cancellation_policy) {
		this.cancellation_policy = cancellation_policy;
	}

	public String getLast_scraped() {
		return last_scraped;
	}

	public void setLast_scraped(String last_scraped) {
		this.last_scraped = last_scraped;
	}

	public String getCalendar_last_scraped() {
		return calendar_last_scraped;
	}

	public void setCalendar_last_scraped(String calendar_last_scraped) {
		this.calendar_last_scraped = calendar_last_scraped;
	}

	public String getFirst_review() {
		return first_review;
	}

	public void setFirst_review(String first_review) {
		this.first_review = first_review;
	}

	public String getLast_review() {
		return last_review;
	}

	public void setLast_review(String last_review) {
		this.last_review = last_review;
	}

	public Integer getAccommodates() {
		return accommodates;
	}

	public void setAccommodates(Integer accommodates) {
		this.accommodates = accommodates;
	}

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	public Integer getBeds() {
		return beds;
	}

	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	public Integer getNumber_of_reviews() {
		return number_of_reviews;
	}

	public void setNumber_of_reviews(Integer number_of_reviews) {
		this.number_of_reviews = number_of_reviews;
	}

	public String getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(String bathrooms) {
		this.bathrooms = bathrooms;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getSecurity_deposit() {
		return security_deposit;
	}

	public void setSecurity_deposit(String security_deposit) {
		this.security_deposit = security_deposit;
	}

	public String getCleaning_fee() {
		return cleaning_fee;
	}

	public void setCleaning_fee(String cleaning_fee) {
		this.cleaning_fee = cleaning_fee;
	}

	public String getExtra_people() {
		return extra_people;
	}

	public void setExtra_people(String extra_people) {
		this.extra_people = extra_people;
	}

	public Integer getGuests_included() {
		return guests_included;
	}

	public void setGuests_included(Integer guests_included) {
		this.guests_included = guests_included;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}
}