package firstproject.com.example.demo.service;

import firstproject.com.example.demo.dto.SurroundingCreateDto;
import firstproject.com.example.demo.dto.SurroundingInfoDto;

import java.util.List;

public interface SurroundingService {

    List<SurroundingInfoDto> getAllSurroundings();

    SurroundingInfoDto createSurrounding(SurroundingCreateDto surroundingCreateDto);

    void updateSurrounding(int surroundingId, String surroundingName, String surroundingDetail);

    void deleteSurrounding(int surroundingId);
}
