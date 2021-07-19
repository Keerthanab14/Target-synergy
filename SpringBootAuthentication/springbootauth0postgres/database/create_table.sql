-- Create the table
CREATE TABLE IF NOT EXISTS listingsAndReviews(
    id SERIAL PRIMARY KEY NOT NULL,
    listing_url VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    space VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    neighborhood_overview VARCHAR NOT NULL,
    notes VARCHAR NOT NULL,
    transit VARCHAR NOT NULL,
    access VARCHAR NOT NULL,
<<<<<<< HEAD
    interaction VARCHAR,
=======
>>>>>>> 4cb92c801d870332e36a5708130ac6fe01c99397
    house_rules VARCHAR NOT NULL,
    property_type VARCHAR(255) NOT NULL,
    room_type VARCHAR(255) NOT NULL,
    bed_type VARCHAR(255) NOT NULL,
    minimum_nights VARCHAR(255) NOT NULL,
    maximum_nights VARCHAR(255) NOT NULL,
    cancellation_policy VARCHAR NOT NULL,
    last_scraped VARCHAR NOT NULL,
    calendar_last_scraped VARCHAR NOT NULL,
    first_review VARCHAR NOT NULL,
    last_review VARCHAR NOT NULL,
    accommodates INT NOT NULL,
    bedrooms INT NOT NULL,
    beds INT NOT NULL,
    number_of_reviews INT NOT NULL,
    bathrooms VARCHAR(255) NOT NULL,
    price VARCHAR(255) NOT NULL,
    amenities VARCHAR NOT NULL,
    security_deposit VARCHAR(255) NOT NULL,
    cleaning_fee VARCHAR(255) NOT NULL,
    extra_people VARCHAR(255) NOT NULL,
    guests_included INT NOT NULL
);