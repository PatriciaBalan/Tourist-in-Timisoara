package firstproject.com.example.demo.controller;

import firstproject.com.example.demo.component.Cultural_eventMapper;
import firstproject.com.example.demo.dto.AccommodationCreateDto;
import firstproject.com.example.demo.dto.Cultural_eventCreateDto;
import firstproject.com.example.demo.dto.Cultural_eventInfoDto;
import firstproject.com.example.demo.model.Accommodation;
import firstproject.com.example.demo.model.Cultural_event;
import firstproject.com.example.demo.repository.Cultural_eventRepository;
import firstproject.com.example.demo.service.implementation.Cultural_eventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tourist_in_timisoara/event")
public class Cultural_eventController {

    @Autowired
    private Cultural_eventService cultural_eventService;

    @Autowired
    private Cultural_eventRepository cultural_eventRepository;

    public Cultural_eventController(Cultural_eventService cultural_eventService, Cultural_eventRepository cultural_eventRepository) {
        this.cultural_eventRepository = cultural_eventRepository;
        this.cultural_eventService = cultural_eventService;
    }

    @GetMapping
    public List<Cultural_eventInfoDto> getAllEvents() {
        return cultural_eventService.getAllEvents();
    }

    @PostMapping(path="/create")
    ResponseEntity<Cultural_eventInfoDto> createEvent (@RequestBody Cultural_eventCreateDto createDto){
        return ResponseEntity.ok(cultural_eventService.createEvent(createDto));
    }

    @PutMapping("{/eventId}")
    public ResponseEntity<Cultural_eventInfoDto> updateEvent(@PathVariable("eventId") int eventId,
                                                      @RequestBody Cultural_event culturalEvent) {

        cultural_eventRepository.findById(eventId).get();
        culturalEvent.setEventName(culturalEvent.getEventName());
        culturalEvent.setEventDate(culturalEvent.getEventDate());
        culturalEvent.setEventDetail(culturalEvent.getEventDetail());
        cultural_eventRepository.save(culturalEvent);
        return  ResponseEntity.ok().build();
    }

    @DeleteMapping("{/eventId}")
    public ResponseEntity<Cultural_eventInfoDto> deleteEv (@PathVariable int eventId) {
        cultural_eventRepository.deleteById(eventId);
        return ResponseEntity.ok().build();
    }
}
