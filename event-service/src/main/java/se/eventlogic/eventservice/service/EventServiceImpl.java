package se.eventlogic.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.eventlogic.eventservice.entities.Event;
import se.eventlogic.eventservice.entities.Participant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private RestTemplate restTemplate;

    // Just to fake the data, [in real life, this would be coming from db at runtime]
    List<Event> events = List.of(
            new Event(1, "Event 1", "Location 1", new Date()),
            new Event(2, "Event 2", "Location 2", new Date()),
            new Event(3, "Event 3", "Location 3", new Date()),
            new Event(4, "Event 4", "Location 4", new Date()),
            new Event(5, "Event 5", "Location 5", new Date())
    );

    @Override
    public Event getEventDetails(Integer eventId) {
        Stream<Event> eventStream = events.stream().filter(e -> Objects.equals(e.getEventId(), eventId));
        return  eventStream
                .findFirst()
                .orElse(null);
    }

    // making call to another microservice url
    @Override
    public List<Participant> listParticipantsForEvent(Integer eventId) {
        if(eventId == null) {
            return new ArrayList<>();
        }
        /**
         * URL is hard coded, so we can communicate by microservice name instead of url
         * List<Participant> participants = restTemplate.getForObject("http://localhost:9001/api/v1/participants/" + eventId, List.class);
         */
        List<Participant> participants = restTemplate.getForObject("http://PARTICIPANT-SERVICE/api/v1/participants/" + eventId, List.class);
        return participants;
    }
}
