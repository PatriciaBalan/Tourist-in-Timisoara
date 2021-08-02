package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.component.AccommodationMapper;
import firstproject.com.example.demo.component.RestaurantMapper;
import firstproject.com.example.demo.dto.RestaurantCreateDto;
import firstproject.com.example.demo.dto.RestaurantInfoDto;
import firstproject.com.example.demo.repository.AccommodationRepository;
import firstproject.com.example.demo.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public RestaurantInfoDto createRest(RestaurantCreateDto restaurant) {
        return null;
    }

    @Override
    public void deleteRest(int restaurantId) {

    }

    @Override
    public void updateRest(int restaurantId, String restaurantName, String restaurantDetail) {

    }
}
