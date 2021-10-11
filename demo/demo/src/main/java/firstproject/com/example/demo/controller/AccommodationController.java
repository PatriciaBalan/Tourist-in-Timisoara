package firstproject.com.example.demo.controller;


import firstproject.com.example.demo.dto.AccommodationCreateDto;
import firstproject.com.example.demo.dto.AccommodationInfoDto;
import firstproject.com.example.demo.model.Accommodation;
import firstproject.com.example.demo.repository.AccommodationRepository;
import firstproject.com.example.demo.service.implementation.AccommodationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping("/tourist_in_timisoara/accommodation")
public class AccommodationController {

   //private static final Logger LOG = LoggerFactory.getLogger(AccommodationController.class);

    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private AccommodationRepository accommodationRepository;


    public AccommodationController(AccommodationService accommodationService, AccommodationRepository accommodationRepository) {
        this.accommodationRepository=accommodationRepository;
        this.accommodationService=accommodationService;
    }

    @GetMapping
    public List<AccommodationInfoDto> getAllAccommodation() {
        return accommodationService.getAllAccommodation();
    }

    @PostMapping(path = "/create")
    ResponseEntity<AccommodationInfoDto> createAccommodation(@RequestBody AccommodationCreateDto accdb) {
        return ResponseEntity.ok(accommodationService.createAcc(accdb));
    }

    @PutMapping("{/accommodationId}")
    public ResponseEntity<AccommodationInfoDto> updateAccommodation(@PathVariable("accommodationId") int accommodationId,
                                                                    @RequestBody Accommodation accommodation) {
        accommodationRepository.findById(accommodationId).get();
        accommodation.setAccommodationName(accommodation.getAccommodationName());
        accommodation.setAccommodationDetails(accommodation.getAccommodationDetails());
        accommodation.setAccommodationId(accommodation.getAccommodationId());
        accommodationRepository.save(accommodation);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{/accommodationId}")
    public ResponseEntity<AccommodationInfoDto> deleteAccommodation(@PathVariable int accommodationId) {
    accommodationService.deleteAcc(accommodationId);
    return ResponseEntity.ok().build();
    }

}
