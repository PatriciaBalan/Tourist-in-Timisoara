package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.model.Tourist_spot;
import firstproject.com.example.demo.repository.Tourist_spotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/touristSpots")
@ControllerAdvice
public class Tourist_spotService {

    private final Logger logger = LoggerFactory.getLogger(Tourist_spotService.class);
    private Tourist_spotService touristSpotService;
    private Tourist_spotRepository touristSpotRepository;

    public Tourist_spotService(Tourist_spotService touristSpotService, Tourist_spotRepository touristSpotRepository){
        this.touristSpotService = touristSpotService;
        this.touristSpotRepository = touristSpotRepository;
    }

    @GetMapping
    List<Tourist_spot> getAllTouristsSpots () {
        return touristSpotRepository.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity<?> getTouristSpotById(@PathVariable Integer id){
        Optional<Tourist_spot> touristSpot = touristSpotRepository.findById(id);
        return touristSpot.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/newTouristSpot")
    ResponseEntity<Tourist_spot> createTouristSpot(@RequestBody Tourist_spot touristSpot) throws URISyntaxException {
        logger.info("Request to create new tourist spot: {}", touristSpot);
        Tourist_spot result = touristSpotRepository.save(touristSpot);
        return ResponseEntity.created(new URI("/api/touristSpots/newTouristSpot/" + result.getSpotId()))
                .body(result);
    }

    @PutMapping("/updateTouristSpot/{id}")
    ResponseEntity<Tourist_spot> updateTouristSpot(@RequestBody Tourist_spot touristSpot) {
        logger.info("Request to update tourist spot: {}", touristSpot);
        Tourist_spot result = touristSpotRepository.save(touristSpot);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/deleteTouristSpot/{id}")
    public ResponseEntity<?> deleteTouristSpotById(@PathVariable Integer id) {
        logger.info("Request to delete tourist spot: {}", id);
        touristSpotRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllTouristSpots")
    public void deleteAllTouristSpots(){
         touristSpotRepository.deleteAll();
    }

}
