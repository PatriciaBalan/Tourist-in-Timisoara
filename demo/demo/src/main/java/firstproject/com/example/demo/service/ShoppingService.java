package firstproject.com.example.demo.service;

import firstproject.com.example.demo.dto.ShoppingCreateDto;
import firstproject.com.example.demo.dto.ShoppingInfoDto;

import java.util.List;

public interface ShoppingService {

    List<ShoppingInfoDto> getAllShopping();

    ShoppingInfoDto createShop(ShoppingCreateDto shoppingCreateDto);

    void updateShop(int shopId, String shopName, String shopDetail);

    void deleteShop(int shopId);

}
