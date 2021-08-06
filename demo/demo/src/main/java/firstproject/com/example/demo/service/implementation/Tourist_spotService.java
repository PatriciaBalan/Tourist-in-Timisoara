package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.dto.Tourist_spotCreateDto;
import firstproject.com.example.demo.dto.Tourist_spotInfoDto;

import java.util.List;

public class Tourist_spotService implements firstproject.com.example.demo.service.Tourist_spotService {
    @Override
    public List<Tourist_spotInfoDto> getAllSpots() {
        return null;
    }

    @Override
    public Tourist_spotInfoDto createSpot(Tourist_spotCreateDto tourist_spotCreateDto) {
        return null;
    }

    @Override
    public void updateSpot(int spotId, String spotName, String spotDetail) {

    }

    @Override
    public void deleteSpot(int spotId) {

    }
}
