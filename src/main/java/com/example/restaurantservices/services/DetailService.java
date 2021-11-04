package com.example.restaurantservices.services;

import java.util.Optional;

import com.example.restaurantservices.model.Restaurant;
import com.example.restaurantservices.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {

    @Autowired
    private RestaurantRepository repository;

    public Optional<Restaurant> GetDetail(int id) {
        return repository.findById(id);
    }
}
