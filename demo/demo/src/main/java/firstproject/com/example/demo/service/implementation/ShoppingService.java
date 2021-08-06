package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.dto.ShoppingCreateDto;
import firstproject.com.example.demo.dto.ShoppingInfoDto;

import java.util.List;

public class ShoppingService implements firstproject.com.example.demo.service.ShoppingService {

    @Override
    public List<ShoppingInfoDto> getAllShopping() {
        return null;
    }

    @Override
    public ShoppingInfoDto createShop(ShoppingCreateDto shoppingCreateDto) {
        return null;
    }

    @Override
    public void updateShop(int shopId, String shopName, String shopDetail) {

    }

    @Override
    public void deleteShop(int shopId) {

    }
}
