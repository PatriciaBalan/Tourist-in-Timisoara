package firstproject.com.example.demo.service;

import firstproject.com.example.demo.dto.RestaurantCreateDto;
import firstproject.com.example.demo.dto.RestaurantInfoDto;
import firstproject.com.example.demo.dto.ShoppingCreateDto;
import firstproject.com.example.demo.dto.ShoppingInfoDto;

import java.util.List;

public interface ShoppingService  {

    List<ShoppingInfoDto> getAllShops();

    ShoppingInfoDto createShop(ShoppingCreateDto shoppingCreateDto);

    void deleteShop(int shopId);

    void updateShop(int shopId, String shopName, String shopDetail);

}
