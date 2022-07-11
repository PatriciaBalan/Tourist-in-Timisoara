package firstproject.com.example.demo.controller;

import firstproject.com.example.demo.dto.Cultural_eventCreateDto;
import firstproject.com.example.demo.dto.Cultural_eventInfoDto;
import firstproject.com.example.demo.dto.RestaurantCreateDto;
import firstproject.com.example.demo.dto.RestaurantInfoDto;
import firstproject.com.example.demo.model.Cultural_event;
import firstproject.com.example.demo.model.Restaurant;
import firstproject.com.example.demo.repository.RestaurantRepository;
import firstproject.com.example.demo.service.implementation.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tourist_in_timisoara/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantService restaurantService, RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<RestaurantInfoDto> restaurantInfoDtoList () {
        return restaurantService.getAllRest();
    }

    @PostMapping(path ="/createRest")
    ResponseEntity<RestaurantInfoDto> createRest (@RequestBody RestaurantCreateDto restaurantCreateDto) {
        return ResponseEntity.ok(restaurantService.createRest(restaurantCreateDto));
    }

    @PutMapping("{/restaurantId}")
    public ResponseEntity<RestaurantInfoDto> updateRest(@PathVariable("restaurantId") int restaurantId,
                                                             @RequestBody Restaurant restaurant) {

        restaurantRepository.findById(restaurantId).get();
        restaurant.setRestaurantName(restaurant.getRestaurantName());
        restaurant.setRestaurantDetails(restaurant.getRestaurantDetails());
        restaurantRepository.save(restaurant);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("{/restaurantId}")
    public ResponseEntity<RestaurantInfoDto> deleteRest (@PathVariable int restaurantId) {
        restaurantRepository.deleteById(restaurantId);
        return ResponseEntity.ok().build();
    }
}
