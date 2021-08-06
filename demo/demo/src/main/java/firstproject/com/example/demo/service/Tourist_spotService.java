package firstproject.com.example.demo.service;

import firstproject.com.example.demo.dto.Tourist_spotCreateDto;
import firstproject.com.example.demo.dto.Tourist_spotInfoDto;

import java.util.List;

public interface Tourist_spotService {

    List<Tourist_spotInfoDto> getAllSpots();

    Tourist_spotInfoDto createSpot(Tourist_spotCreateDto tourist_spotCreateDto);

    void updateSpot(int spotId, String spotName, String spotDetail);

    void deleteSpot(int spotId);
}
