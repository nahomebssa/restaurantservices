package com.example.restaurantservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Restaurant {

    @Transient
	public static final String SEQUENCE_NAME = "book_sequence";

    @Id
    private long id;
    private String name;
    // private String location;
    // private String cuisine;
    // private int tier;
    // private double rating;
}
