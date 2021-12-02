package com.example.restaurantservices.restcontroller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.restaurantservices.model.DatabaseSequence;
import com.example.restaurantservices.model.Restaurant;
import com.example.restaurantservices.repository.RestaurantRepository;
import com.example.restaurantservices.services.DetailService;
import com.example.restaurantservices.services.MasterListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantServiceController {
    
    @Autowired
    private MasterListService masterListService;
    
    @Autowired
    private DetailService detailService;
    
    //#region testing
    @Autowired
    private RestaurantRepository repository;
    @PostMapping("/restaurants/add")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        //generate sequence 
		int id = getSequenceNumber(Restaurant.SEQUENCE_NAME);
		restaurant.setId(id);
		repository.save(restaurant);
        return restaurant;
    }
    @PostMapping("/restaurants/add-all")
    public List<Restaurant> addRestaurantAll(@RequestBody List<Restaurant> restaurants) {
        for (Restaurant restaurant : restaurants) {
            //generate sequence 
            int id = getSequenceNumber(Restaurant.SEQUENCE_NAME);
            restaurant.setId(id);
            repository.save(restaurant);
        }
        return restaurants;
    }
    //#endregion

    @GetMapping("/restaurants")
    public List<Restaurant> GetRestaurantList() {
        return masterListService.GetMasterList();
    }
    
    @GetMapping("/restaurants/{id}")
    public Optional<Restaurant> GetDetail(@PathVariable int id) {
        return detailService.GetDetail(id);
    }
    
    @Autowired
    private MongoOperations mongoOperations;
	private static final String ID = "id";
    private static final String SEQUENCE = "seq";
    public int getSequenceNumber(String sequenceName) {
        
        // get sequence no
        Query query = new Query(Criteria.where(ID).is(sequenceName));
        
        // update the sequence no
        Update update = new Update().inc(SEQUENCE, 1);
        
        // modify in document
        DatabaseSequence counter = mongoOperations.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), DatabaseSequence.class);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

}
