package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.component.SurroundingMapper;
import firstproject.com.example.demo.dto.ShoppingCreateDto;
import firstproject.com.example.demo.dto.ShoppingInfoDto;
import firstproject.com.example.demo.dto.SurroundingCreateDto;
import firstproject.com.example.demo.dto.SurroundingInfoDto;
import firstproject.com.example.demo.exception.EntityDoesNotExistsException;
import firstproject.com.example.demo.model.Shopping;
import firstproject.com.example.demo.model.Surrounding;
import firstproject.com.example.demo.repository.SurroundingRepository;
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
public class SurroundingService implements firstproject.com.example.demo.service.SurroundingService {

    private final Logger logger = LoggerFactory.getLogger(SurroundingService.class);
    private SurroundingMapper surroundingMapper;
    private SurroundingRepository surroundingRepository;

    public SurroundingService(SurroundingMapper surroundingMapper,SurroundingRepository surroundingRepository) {
        this.surroundingMapper = surroundingMapper;
        this.surroundingRepository = surroundingRepository;
    }

    @Override
    public List<SurroundingInfoDto> getAllSurroundings() {
        return surroundingMapper.toDtoList(surroundingRepository.findAll());
    }

    @Override
    public SurroundingInfoDto createSurrounding(SurroundingCreateDto surroundingCreateDto) {
        return surroundingMapper.toDto(surroundingRepository.save(surroundingMapper.toBase(surroundingCreateDto)));
    }

    @Override
    public void deleteSurrounding(int surroundingId) {
        surroundingRepository.findById(surroundingId);
        surroundingRepository.deleteById(surroundingId);
    }

    @Override
    public void updateSurrounding( int surroundingId, String surroundingName, String surroundingDetail) {

        Optional<Surrounding> surroundingOptional = surroundingRepository.findById(surroundingId);

        if(!surroundingOptional.isPresent()) throw  new EntityDoesNotExistsException("Surr id " + surroundingId);

        Surrounding surrounding = surroundingOptional.get();
        surrounding.setSurroundingName(surroundingName);
        surrounding.setSurroundingDetail(surrounding.getSurroundingDetail());

        surroundingRepository.save(surrounding);
    }
}