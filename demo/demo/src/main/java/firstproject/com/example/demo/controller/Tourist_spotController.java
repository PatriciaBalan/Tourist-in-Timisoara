package firstproject.com.example.demo.controller;

import firstproject.com.example.demo.component.Tourist_spotMapper;
import firstproject.com.example.demo.dto.Tourist_spotCreateDto;
import firstproject.com.example.demo.dto.Tourist_spotInfoDto;
import firstproject.com.example.demo.model.Surrounding;
import firstproject.com.example.demo.model.Tourist_spot;
import firstproject.com.example.demo.repository.Tourist_spotRepository;
import firstproject.com.example.demo.service.implementation.Tourist_spotService;
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
@RequestMapping("/tourist_in_timisoara/touristSpots")
@ControllerAdvice
public class Tourist_spotController {

    private final Logger logger = LoggerFactory.getLogger(Tourist_spotService.class);
    private Tourist_spotService touristSpotService;
    private Tourist_spotRepository touristSpotRepository;

    public Tourist_spotController(Tourist_spotService tourist_spotService, Tourist_spotRepository touristSpotRepository){
        this.touristSpotService = tourist_spotService;
        this.touristSpotRepository = touristSpotRepository;
    }

    @GetMapping
    List<Tourist_spotInfoDto> getAllTouristsSpots () {
        return touristSpotService.getAllSpots();
    }

//    @GetMapping("{id}")
//    ResponseEntity<?> getTouristSpotById(@PathVariable Integer id){
//        Optional<Tourist_spot> touristSpot = touristSpotRepository.findById(id);
//        return touristSpot.map(response -> ResponseEntity.ok().body(response))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @PostMapping(path="/createSpot")
    ResponseEntity<Tourist_spotInfoDto> createSpot(@RequestBody Tourist_spotCreateDto tourist_spotCreateDto) throws URISyntaxException {
//        logger.info("Request to create new tourist spot: {}", touristSpot);
//        Tourist_spot result = touristSpotRepository.save(touristSpot);
//        return ResponseEntity.created(new URI("/api/touristSpots/newTouristSpot/" + result.getSpotId()))
//                .body(result);
        return ResponseEntity.ok(touristSpotService.createSpot(tourist_spotCreateDto));
    }

    @PutMapping("/spotId")
    ResponseEntity<Tourist_spotInfoDto> updateSpot(@PathVariable("spotId") int touristSpotId,
                                                   @RequestBody Tourist_spot tourist_spot) {
//        logger.info("Request to update tourist spot: {}", touristSpot);
//        Tourist_spot result = touristSpotRepository.save(touristSpot);
//        return ResponseEntity.ok().body(result);

        touristSpotRepository.findById(touristSpotId).get();
        tourist_spot.setSpotName(tourist_spot.getSpotName());
        tourist_spot.setSpotDetail(tourist_spot.getSpotDetail());
        touristSpotRepository.save(tourist_spot);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/spotId")
    public ResponseEntity<Tourist_spotInfoDto> deleteSpot(@PathVariable("spotId") int spotId) {
        logger.info("Request to delete tourist spot: {}", spotId);
        touristSpotRepository.deleteById(spotId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllTouristSpots")
    public void deleteAllTouristSpots(){
        touristSpotRepository.deleteAll();
    }
}
