package firstproject.com.example.demo.service;

import firstproject.com.example.demo.dto.AccommodationCreateDto;
import firstproject.com.example.demo.dto.AccommodationInfoDto;
import firstproject.com.example.demo.dto.Cultural_eventCreateDto;
import firstproject.com.example.demo.dto.Cultural_eventInfoDto;

import java.util.List;

public interface Cultural_eventService {

    List<Cultural_eventInfoDto> getAllEvents();

    Cultural_eventInfoDto createEvent (Cultural_eventCreateDto event);

    void deleteEvent(int eventId);

    void updateEvent(int eventId, String eventName, String eventDetail);
}
