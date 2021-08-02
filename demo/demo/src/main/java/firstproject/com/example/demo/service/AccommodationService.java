package firstproject.com.example.demo.service;

import firstproject.com.example.demo.dto.AccommodationCreateDto;
import firstproject.com.example.demo.dto.AccommodationInfoDto;

import java.util.List;

public interface AccommodationService {

    List<AccommodationInfoDto> getAllAccommodation();

    AccommodationInfoDto createAcc (AccommodationCreateDto accommodation);

    void deleteAcc(int accommodationId);

    void updateAcc(int accommodationId, String accommodationName, String accommodationDetail);

}
