package firstproject.com.example.demo.service;

import firstproject.com.example.demo.dto.RestaurantCreateDto;
import firstproject.com.example.demo.dto.RestaurantInfoDto;

import java.util.List;

public interface RestaurantService {

    List<RestaurantInfoDto> getAllRest();

    RestaurantInfoDto createRest(RestaurantCreateDto restaurant);

    void deleteRest(int restaurantId);

    void updateRest(int restaurantId, String restaurantName, String restaurantDetails);


}
