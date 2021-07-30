package firstproject.com.example.demo.component;

import firstproject.com.example.demo.dto.AccommodationCreateDto;
import firstproject.com.example.demo.dto.AccommodationInfoDto;
import firstproject.com.example.demo.model.Accommodation;

import java.util.ArrayList;
import java.util.List;

public class AccommodationMapper {

    public static Accommodation toBase(AccommodationCreateDto accommodationCreateDto) {
        Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationName(accommodationCreateDto.getAccommodationName());
        accommodation.setAccommodationDetails(accommodationCreateDto.getAccommodationDetail());
    return accommodation;
    }


    public static AccommodationInfoDto toDto(Accommodation accommodation) {
        AccommodationInfoDto accommodationInfoDto = new AccommodationInfoDto();
        accommodationInfoDto.setAccommodationId(accommodation.getAccommodationId());
        accommodationInfoDto.setAccommodationName(accommodation.getAccommodationName());
        accommodationInfoDto.setAccommodationDetail(accommodation.getAccommodationDetails());
        return accommodationInfoDto;
    }

    public static List<AccommodationInfoDto> toDtoList(Iterable<Accommodation> entities) {
        List<AccommodationInfoDto> results = new ArrayList<>();
        entities.forEach(entity -> results.add(toDto(entity)));
        return results;
    }
}
