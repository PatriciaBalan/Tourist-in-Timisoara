package firstproject.com.example.demo.component;

import firstproject.com.example.demo.dto.SurroundingCreateDto;
import firstproject.com.example.demo.dto.SurroundingInfoDto;
import firstproject.com.example.demo.model.Surrounding;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SurroundingMapper {

    public static Surrounding toBase (SurroundingCreateDto surroundingCreateDto) {
        Surrounding surrounding =  new Surrounding();
        surrounding.setSurroundingName(surroundingCreateDto.getSurroundingName());
        surrounding.setSurroundingDetail(surroundingCreateDto.getSurroundingDetail());
        return surrounding;
    }

    public static SurroundingInfoDto toDto(Surrounding surrounding) {
        SurroundingInfoDto surroundingInfoDto = new SurroundingInfoDto();
        surroundingInfoDto.setSurroundingId(surrounding.getSurroundingId());
        surroundingInfoDto.setSurroundingName(surrounding.getSurroundingName());
        surroundingInfoDto.setSurroundingDetail(surrounding.getSurroundingDetail());
        return surroundingInfoDto;
    }

    public static List<SurroundingInfoDto> toDtoList(Iterable<Surrounding> surroundings) {
        List<SurroundingInfoDto> results = new ArrayList<>();
        surroundings.forEach(surround -> results.add(toDto(surround)));
        return results;
    }
}
