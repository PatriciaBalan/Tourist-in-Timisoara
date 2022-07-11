package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.component.Tourist_spotMapper;
import firstproject.com.example.demo.dto.Tourist_spotCreateDto;
import firstproject.com.example.demo.dto.Tourist_spotInfoDto;
import firstproject.com.example.demo.exception.EntityDoesNotExistsException;
import firstproject.com.example.demo.model.Surrounding;
import firstproject.com.example.demo.model.Tourist_spot;
import firstproject.com.example.demo.repository.Tourist_spotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class Tourist_spotService implements firstproject.com.example.demo.service.Tourist_spotService {

    private final Logger logger = LoggerFactory.getLogger(SurroundingService.class);
    private Tourist_spotRepository touristSpotRepository;
    private Tourist_spotMapper tourist_spotMapper;

    public Tourist_spotService(Tourist_spotMapper tourist_spotMapper, Tourist_spotRepository touristSpotRepository){
        this.tourist_spotMapper=tourist_spotMapper;
        this.touristSpotRepository=touristSpotRepository;
    }

    @Override
    public List<Tourist_spotInfoDto> getAllSpots() {
        return tourist_spotMapper.toDtoList(touristSpotRepository.findAll());
    }

    @Override
    public Tourist_spotInfoDto createSpot(Tourist_spotCreateDto tourist_spotCreateDto) {
        return tourist_spotMapper.toDto(touristSpotRepository.save(tourist_spotMapper.toBase(tourist_spotCreateDto)));
    }

    @Override
    public void updateSpot(int spotId, String spotName, String spotDetail) {

        Optional<Tourist_spot> touristSpot = touristSpotRepository.findById(spotId);

        if(!touristSpot.isPresent()) throw  new EntityDoesNotExistsException("Spot id " + spotId);

        Tourist_spot tourist_spot = touristSpot.get();
        tourist_spot.setSpotName(spotName);
        tourist_spot.setSpotDetail(tourist_spot.getSpotDetail());
        touristSpotRepository.save(tourist_spot);
    }

    @Override
    public void deleteSpot(int spotId) {
        touristSpotRepository.findById(spotId);
        touristSpotRepository.deleteById(spotId);

    }
}
