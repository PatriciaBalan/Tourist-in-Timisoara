package firstproject.com.example.demo.component;

import firstproject.com.example.demo.dto.RestaurantCreateDto;
import firstproject.com.example.demo.dto.RestaurantInfoDto;
import firstproject.com.example.demo.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantMapper {

    public static Restaurant toBase(RestaurantCreateDto restaurantCreateDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantCreateDto.getRestaurantName());
        restaurant.setRestaurantName(restaurantCreateDto.getRestaurantDetail());
        return restaurant;
    }

    public static RestaurantInfoDto toDto(Restaurant restaurant) {
        RestaurantInfoDto restaurantInfoDto = new RestaurantInfoDto();
        restaurantInfoDto.setRestaurantId(restaurant.getRestaurantId());
        restaurantInfoDto.setRestaurantName(restaurant.getRestaurantName());
        restaurantInfoDto.setRestaurantDetail(restaurant.getRestaurantDetails());
        return restaurantInfoDto;
    }

    public static List<RestaurantInfoDto> toDtoList(Iterable<Restaurant> rest){
        List<RestaurantInfoDto> results = new ArrayList<>();
        rest.forEach(res -> results.add(toDto(res)));
        return results;
    }
}
