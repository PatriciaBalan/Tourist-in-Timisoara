package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.component.RestaurantMapper;
import firstproject.com.example.demo.component.ShoppingMapper;
import firstproject.com.example.demo.dto.RestaurantCreateDto;
import firstproject.com.example.demo.dto.RestaurantInfoDto;
import firstproject.com.example.demo.dto.ShoppingCreateDto;
import firstproject.com.example.demo.dto.ShoppingInfoDto;
import firstproject.com.example.demo.exception.EntityDoesNotExistsException;
import firstproject.com.example.demo.model.Restaurant;
import firstproject.com.example.demo.model.Shopping;
import firstproject.com.example.demo.repository.RestaurantRepository;
import firstproject.com.example.demo.repository.ShoppingRepository;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService implements firstproject.com.example.demo.service.ShoppingService {

    private static final Logger LOG = LoggerFactory.getLogger(RestaurantService.class);

    private ShoppingRepository shoppingRepository;
    private final ShoppingMapper shoppingMapper;

    public ShoppingService(ShoppingMapper shoppingMapper,
                             ShoppingRepository shoppingRepository) {
        this.shoppingMapper = shoppingMapper;
        this.shoppingRepository = shoppingRepository;
    }

    @Override
    public List<ShoppingInfoDto> getAllShops() {
        return shoppingMapper.toDtoList(shoppingRepository.findAll());
    }

    @Override
    public ShoppingInfoDto createShop(ShoppingCreateDto shoppingCreateDto) {
        return shoppingMapper.toDto(shoppingRepository.save(shoppingMapper.toBase(shoppingCreateDto)));
    }

    @Override
    public void deleteShop(int shopId) {
        shoppingRepository.findById(shopId);
        shoppingRepository.deleteById(shopId);
    }

    @Override
    public void updateShop(int shopId,
                           String shopName,
                           String ShopDetail) {

        Optional<Shopping> shoppingOptional = shoppingRepository.findById(shopId);

        if(!shoppingOptional.isPresent()) throw  new EntityDoesNotExistsException("Shop id " + shopId);

        Shopping shopping = shoppingOptional.get();
        shopping.setShopName(shopName);
        shopping.setShopDetail(shopping.getShopDetail());

        shoppingRepository.save(shopping);
    }
}