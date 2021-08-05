package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.model.Surrounding;
import firstproject.com.example.demo.repository.SurroundingRepository;
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
@RequestMapping("/api/surrounding")
@ControllerAdvice
public class SurroundingService {

    private final Logger logger = LoggerFactory.getLogger(SurroundingService.class);
    private SurroundingService surroundingService;
    private SurroundingRepository surroundingRepository;

    public SurroundingService(SurroundingService surroundingService,SurroundingRepository surroundingRepository) {
        this.surroundingService = surroundingService;
        this.surroundingRepository = surroundingRepository;
    }

    @GetMapping
    List<Surrounding> getAllSurroundings(){
        return surroundingRepository.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity<?> getSurroundingById(@PathVariable Integer id) {
        Optional<Surrounding> surrounding = surroundingRepository.findById(id);
        return surrounding.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/newSurrounding")
    ResponseEntity<Surrounding> createSurrounding(@RequestBody Surrounding surrounding) throws URISyntaxException {
        logger.info("Request to create surrounding: {}", surrounding);
        Surrounding result = surroundingRepository.save(surrounding);
        return ResponseEntity.created(new URI("/api/surrounding/newSurrounding/" + result.getSurroundingId()))
                .body(result);
    }

    @PutMapping("/updateSurrounding/{id}")
    ResponseEntity<Surrounding> updateSurrounding(@RequestBody Surrounding surrounding) {
        logger.info("Request to update surrounding: {}", surrounding);
        Surrounding result = surroundingRepository.save(surrounding);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/deleteSurrounding/{id}")
    ResponseEntity<?> deleteSurroundingById(@RequestParam Integer id){
        logger.info("Request to delete surrounding: {}", id);
        surroundingRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllSurroundings")
    public void deleteAllSurroundings(){
        surroundingRepository.deleteAll();
    }
}
