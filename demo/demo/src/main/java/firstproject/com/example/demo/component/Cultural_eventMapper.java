package firstproject.com.example.demo.component;

import firstproject.com.example.demo.dto.Cultural_eventCreateDto;
import firstproject.com.example.demo.dto.Cultural_eventInfoDto;
import firstproject.com.example.demo.model.Cultural_event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cultural_eventMapper {

    public static Cultural_event toBase(Cultural_eventCreateDto cultural_eventCreateDto){
        Cultural_event cultural_event = new Cultural_event();
        cultural_event.setEventName(cultural_eventCreateDto.getEventName());
        cultural_event.setEventDetail(cultural_eventCreateDto.getEventDetail());
        cultural_event.setEventDate(cultural_eventCreateDto.getEventDate());
        return cultural_event;
    }

    public static Cultural_eventInfoDto toDto(Cultural_event cultural_event) {
        Cultural_eventInfoDto cultural_eventInfoDto = new Cultural_eventInfoDto();
        cultural_eventInfoDto.setEventId(cultural_event.getEventId());
        cultural_eventInfoDto.setEventName(cultural_event.getEventName());
        cultural_eventInfoDto.setEventDetail(cultural_event.getEventDetail());
        cultural_eventInfoDto.setEventDate(cultural_event.getEventDate());
        return cultural_eventInfoDto;
    }

    public List<Cultural_eventInfoDto> toDoList(Iterable<Cultural_event> events){
        List<Cultural_eventInfoDto> results = new ArrayList<>();
        events.forEach(event -> results.add(toDto(event)));
        return results;
    }
}
