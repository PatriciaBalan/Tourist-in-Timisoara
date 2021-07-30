package firstproject.com.example.demo.component;

import firstproject.com.example.demo.dto.ShoppingCreateDto;
import firstproject.com.example.demo.dto.ShoppingInfoDto;
import firstproject.com.example.demo.model.Shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMapper {

    public static Shopping toBase(ShoppingCreateDto shoppingCreateDto) {
        Shopping shopping = new Shopping();
        shopping.setShopName(shoppingCreateDto.getShopName());
        shopping.setShopDetail(shoppingCreateDto.getShopDetail());
        return shopping;
    }

    public static ShoppingInfoDto toDto(Shopping shopping) {
        ShoppingInfoDto shoppingInfoDto = new ShoppingInfoDto();
        shoppingInfoDto.setShopId(shopping.getShopId());
        shoppingInfoDto.setShopName(shopping.getShopName());
        shoppingInfoDto.setShopDetail(shopping.getShopDetail());
        return shoppingInfoDto;
    }

    public static List<ShoppingInfoDto> toDtoList(Iterable<Shopping> shops){
        List<ShoppingInfoDto> results = new ArrayList<>();
        shops.forEach(shop -> results.add(toDto(shop)));
        return results;
    }
}
