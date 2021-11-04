package com.example.restaurantservices.repository;

import com.example.restaurantservices.model.Restaurant;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> {}
