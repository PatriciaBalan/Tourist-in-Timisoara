package firstproject.com.example.demo.component;

import firstproject.com.example.demo.dto.Tourist_spotCreateDto;
import firstproject.com.example.demo.dto.Tourist_spotInfoDto;
import firstproject.com.example.demo.model.Tourist_spot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Tourist_spotMapper {

    public static Tourist_spot toBase(Tourist_spotCreateDto tourist_spotCreateDto) {
        Tourist_spot tourist_spot = new Tourist_spot();
        tourist_spot.setSpotName(tourist_spotCreateDto.getSpotName());
        tourist_spot.setSpotDetail(tourist_spotCreateDto.getSpotDetail());
        return tourist_spot;
    }

    public static Tourist_spotInfoDto toDto(Tourist_spot tourist_spot) {
        Tourist_spotInfoDto tourist_spotInfoDto = new Tourist_spotInfoDto();
        tourist_spotInfoDto.setSpotId(tourist_spot.getSpotId());
        tourist_spotInfoDto.setSpotName(tourist_spot.getSpotName());
        tourist_spot.setSpotDetail(tourist_spot.getSpotDetail());
        return tourist_spotInfoDto;
    }

    public static List<Tourist_spotInfoDto> toDtoList(Iterable<Tourist_spot> spots) {
        List<Tourist_spotInfoDto> results = new ArrayList<>();
        spots.forEach(spot -> results.add(toDto(spot)));
        return results;
    }
}
