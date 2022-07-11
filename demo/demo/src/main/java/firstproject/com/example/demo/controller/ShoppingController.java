package firstproject.com.example.demo.controller;

import firstproject.com.example.demo.dto.RestaurantCreateDto;
import firstproject.com.example.demo.dto.RestaurantInfoDto;
import firstproject.com.example.demo.dto.ShoppingCreateDto;
import firstproject.com.example.demo.dto.ShoppingInfoDto;
import firstproject.com.example.demo.model.Restaurant;
import firstproject.com.example.demo.model.Shopping;
import firstproject.com.example.demo.repository.ShoppingRepository;
import firstproject.com.example.demo.service.implementation.ShoppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/tourist_in_timisoara/shopping")
@ControllerAdvice
public class ShoppingController {

    private final Logger logger = LoggerFactory.getLogger(ShoppingService.class);
    private ShoppingService shoppingService;
    private ShoppingRepository shoppingRepository;

    private ShoppingController(ShoppingService shoppingService, ShoppingRepository shoppingRepository) {
        this.shoppingService = shoppingService;
        this.shoppingRepository= shoppingRepository;
    }

    @GetMapping
    public List<ShoppingInfoDto> shoppingInfoDtos() {
        return shoppingService.getAllShops();
    }

//    @GetMapping("/{id}")
//    ResponseEntity<?> getShopById(@PathVariable Integer id) {
//        Optional<Shopping> shop = shoppingRepository.findById(id);
//        return shop.map(response -> ResponseEntity.ok().body(response))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @PostMapping(path = "/createShop")
    //ResponseEntity<ShoppingInfoDto> createShop(@RequestBody ShoppingCreateDto shoppingCreateDto)
        //logger.info("Request to create shop : {}", shopping);
       // Shopping result = shoppingRepository.save(shopping);

    ResponseEntity<ShoppingInfoDto> createShop (@RequestBody ShoppingCreateDto shoppingCreateDto ) {
            return ResponseEntity.ok(shoppingService.createShop(shoppingCreateDto));
    }

    @PutMapping("/shopId")
    //ResponseEntity<Shopping> updateShop(@RequestBody Shopping shopping) {
        //logger.info("Request to update shop: {}", shopping);
       // Shopping result = shoppingRepository.save(shopping);
       // return ResponseEntity.ok().body(result);

    public ResponseEntity<ShoppingInfoDto> updateShop(@PathVariable("shopId") int shopId,
                                                             @RequestBody Shopping shopping) {

            shoppingRepository.findById(shopId).get();
            shopping.setShopName(shopping.getShopName());
            shopping.setShopDetail(shopping.getShopDetail());
            shoppingRepository.save(shopping);
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/shopId")
    ResponseEntity<ShoppingInfoDto> deleteShop(@PathVariable int shopId) {
        logger.info("Request to delete shop: {}", shopId);
        shoppingRepository.deleteById(shopId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllShops")
    public void deleteAllShops(){
        shoppingRepository.deleteAll();
    }
}
