package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.component.AccommodationMapper;
import firstproject.com.example.demo.dto.AccommodationCreateDto;
import firstproject.com.example.demo.dto.AccommodationInfoDto;
import firstproject.com.example.demo.repository.AccommodationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationService implements firstproject.com.example.demo.service.AccommodationService {

    private static final Logger LOG = LoggerFactory.getLogger(AccommodationService.class);

    private final AccommodationMapper accommodationMapper;
    private AccommodationRepository accommodationRepository;

    public AccommodationService(AccommodationMapper accommodationMapper,
                                AccommodationRepository accommodationRepository) {
        this.accommodationMapper = accommodationMapper;
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public List<AccommodationInfoDto> getAllAccommodation() {
        return null;
    }

    @Override
    public AccommodationInfoDto createAcc(AccommodationCreateDto accommodation) {
        return null;
    }

    @Override
    public void deleteAcc(int accommodationId) {

    }

    @Override
    public void updateAcc(int accommodationId, String accommodationName, String accomodationDetail) {

    }
}
