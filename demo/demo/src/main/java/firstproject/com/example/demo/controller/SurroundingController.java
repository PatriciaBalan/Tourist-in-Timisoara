package firstproject.com.example.demo.controller;

import firstproject.com.example.demo.component.SurroundingMapper;
import firstproject.com.example.demo.dto.ShoppingInfoDto;
import firstproject.com.example.demo.dto.SurroundingCreateDto;
import firstproject.com.example.demo.dto.SurroundingInfoDto;
import firstproject.com.example.demo.model.Shopping;
import firstproject.com.example.demo.model.Surrounding;
import firstproject.com.example.demo.repository.SurroundingRepository;
import firstproject.com.example.demo.service.implementation.SurroundingService;
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
@RequestMapping("/tourist_in_timisoara/surrounding")
@ControllerAdvice
public class SurroundingController {

    private final Logger logger = LoggerFactory.getLogger(SurroundingService.class);
    private SurroundingService surroundingService;
    private SurroundingRepository surroundingRepository;

    public SurroundingController(SurroundingService surroundingService,SurroundingRepository surroundingRepository) {
        this.surroundingService = surroundingService;
        this.surroundingRepository = surroundingRepository;
    }

    @GetMapping
    List<SurroundingInfoDto> getAllSurroundings(){
        return surroundingService.getAllSurroundings();
    }

//    @GetMapping("{id}")
//    ResponseEntity<?> getSurroundingById(@PathVariable Integer id) {
//        Optional<Surrounding> surrounding = surroundingRepository.findById(id);
//        return surrounding.map(response -> ResponseEntity.ok().body(response))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @PostMapping(path="/createSurrounding")
    ResponseEntity<SurroundingInfoDto> createSurrounding(@RequestBody SurroundingCreateDto surroundingCreateDto) {
        return ResponseEntity.ok(surroundingService.createSurrounding(surroundingCreateDto));
    }

    @PutMapping("/surroundingId")
//    ResponseEntity<Surrounding> updateSurrounding(@RequestBody Surrounding surrounding) {
//        logger.info("Request to update surrounding: {}", surrounding);
//        Surrounding result = surroundingRepository.save(surrounding);
//        return ResponseEntity.ok().body(result);

    public ResponseEntity<SurroundingInfoDto> updateSurrounding(@PathVariable("surroundingId") int surroundingId,
                                                      @RequestBody Surrounding surrounding) {

        surroundingRepository.findById(surroundingId).get();
        surrounding.setSurroundingName(surrounding.getSurroundingName());
        surrounding.setSurroundingDetail(surrounding.getSurroundingDetail());
        surroundingRepository.save(surrounding);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/surroundingId")
    ResponseEntity<SurroundingInfoDto> deleteSurrounding(@PathVariable("surroundingId") int surroundingId){
        logger.info("Request to delete surrounding: {}", surroundingId);
        surroundingRepository.deleteById(surroundingId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllSurroundings")
    public void deleteAllSurroundings(){
        surroundingRepository.deleteAll();
    }
}

