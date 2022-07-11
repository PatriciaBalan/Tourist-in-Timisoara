package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.component.AccommodationMapper;
import firstproject.com.example.demo.dto.AccommodationCreateDto;
import firstproject.com.example.demo.dto.AccommodationInfoDto;
import firstproject.com.example.demo.exception.EntityDoesNotExistsException;
import firstproject.com.example.demo.model.Accommodation;
import firstproject.com.example.demo.repository.AccommodationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService implements firstproject.com.example.demo.service.AccommodationService {

    //private static final Logger LOG = LoggerFactory.getLogger(AccommodationService.class);

    private final AccommodationMapper accommodationMapper;
    private AccommodationRepository accommodationRepository;

    public AccommodationService(AccommodationMapper accommodationMapper,
                                AccommodationRepository accommodationRepository) {
        this.accommodationMapper = accommodationMapper;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public List<AccommodationInfoDto> getAllAccommodation() {
        return accommodationMapper.toDtoList(accommodationRepository.findAll());
    }

    @Override
    public AccommodationInfoDto createAcc(AccommodationCreateDto accommodationCreateDto) {
        return accommodationMapper.toDto(accommodationRepository.save(accommodationMapper.toBase(accommodationCreateDto)));
    }

    @Override
    public void deleteAcc(int accommodationId) {
        accommodationRepository.findById(accommodationId).get();
        accommodationRepository.deleteById(accommodationId);
    }

    @Override
    public void updateAcc(int accommodationId,
                          String accommodationName,
                          String accommodationDetail) {
        Optional<Accommodation> accommodationOptional = accommodationRepository.findById(accommodationId);
        if (!accommodationOptional.isPresent()) throw new EntityDoesNotExistsException("Accommodation with ID = " + accommodationId);

        Accommodation accommodation = accommodationOptional.get();
        accommodation.setAccommodationName(accommodationName);
        accommodation.setAccommodationDetails(accommodationDetail);

        accommodationRepository.save(accommodation);
    }
}
