package firstproject.com.example.demo.service.implementation;

import firstproject.com.example.demo.component.Cultural_eventMapper;
import firstproject.com.example.demo.dto.Cultural_eventCreateDto;
import firstproject.com.example.demo.dto.Cultural_eventInfoDto;
import firstproject.com.example.demo.repository.Cultural_eventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cultural_eventService implements firstproject.com.example.demo.service.Cultural_eventService {

    private static final Logger LOG = LoggerFactory.getLogger(Cultural_eventService.class);

    private final Cultural_eventMapper cultural_eventMapper;
    private Cultural_eventRepository cultural_eventRepository;

    public Cultural_eventService(Cultural_eventService cultural_eventService,
                                Cultural_eventRepository cultural_eventRepository) {
        this.cultural_eventMapper = cultural_eventService.cultural_eventMapper;
        this.cultural_eventRepository = cultural_eventRepository;
    }


    @Override
    public List<Cultural_eventInfoDto> getAllEvents() {
        return null;
    }

    @Override
    public Cultural_eventInfoDto createEvent(Cultural_eventCreateDto event) {
        return null;
    }

    @Override
    public void deleteEvent(int eventId) {

    }

    @Override
    public void updateEvent(int eventId, String eventName, String eventDetail) {

    }
}
