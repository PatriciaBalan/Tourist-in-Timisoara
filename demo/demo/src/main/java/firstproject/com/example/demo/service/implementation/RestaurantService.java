package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.component.RestaurantMapper;
import firstproject.com.example.demo.dto.RestaurantCreateDto;
import firstproject.com.example.demo.dto.RestaurantInfoDto;
import firstproject.com.example.demo.exception.EntityDoesNotExistsException;
import firstproject.com.example.demo.model.Restaurant;
import firstproject.com.example.demo.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService implements firstproject.com.example.demo.service.RestaurantService {

    private static final Logger LOG = LoggerFactory.getLogger(RestaurantService.class);

    private RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantMapper restaurantMapper,
                                RestaurantRepository restaurantRepository) {
        this.restaurantMapper = restaurantMapper;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<RestaurantInfoDto> getAllRest() {
        return restaurantMapper.toDtoList(restaurantRepository.findAll());
    }

    @Override
    public RestaurantInfoDto createRest(RestaurantCreateDto restaurant) {
        return restaurantMapper.toDto(restaurantRepository.save(restaurantMapper.toBase(restaurant)));
    }

    @Override
    public void deleteRest(int restaurantId) {
        restaurantRepository.findById(restaurantId);
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public void updateRest(int restaurantId,
                           String restaurantName,
                           String restaurantDetails) {

        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);

         if(!restaurantOptional.isPresent()) throw  new EntityDoesNotExistsException("Restaurant id " + restaurantId);

         Restaurant restaurant = restaurantOptional.get();
         restaurant.setRestaurantName(restaurantName);
         restaurant.setRestaurantDetails(restaurant.getRestaurantDetails());

         restaurantRepository.save(restaurant);
    }
}
