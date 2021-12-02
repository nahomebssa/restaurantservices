package com.example.restaurantservices.model;

import lombok.Data;

@Data
public class Location {
    private String address;
    private String city;
    private String state;
    private int zipCode;
}
