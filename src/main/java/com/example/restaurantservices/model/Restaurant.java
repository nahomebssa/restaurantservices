package com.example.restaurantservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Restaurant")
public class Restaurant {

    @Transient
	public static final String SEQUENCE_NAME = "restaurant_sequence";

    @Id
    private long id;
    private String name;
    private Location location;
    private String cuisine;
    private Tier tier;
    private double rating;
}
