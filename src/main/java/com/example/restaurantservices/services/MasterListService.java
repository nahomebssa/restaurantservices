package com.example.restaurantservices.services;

import java.util.List;

import com.example.restaurantservices.model.Restaurant;
import com.example.restaurantservices.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterListService {
    
    @Autowired
    private RestaurantRepository repository;

    
    public List<Restaurant> GetMasterList() {
        return repository.findAll();
    }

}
