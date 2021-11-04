package com.example.restaurantservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection="db_sequence")
@Data
@AllArgsConstructor
public class DatabaseSequence {
    @Id
    private String id;
    private int seq;
}
