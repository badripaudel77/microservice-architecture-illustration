package se.eventlogic.eventservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.eventlogic.eventservice.entities.Event;
import se.eventlogic.eventservice.entities.Participant;
import se.eventlogic.eventservice.service.EventService;

import java.util.List;

@RestController
@RequestMapping("api/v1/events/")
public class EventResource {

    private EventService eventService;

    public EventResource(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("{eventId}")
    public Event getEventDetails(@PathVariable("eventId") Integer eventId) {
       Event event =  eventService.getEventDetails(eventId);
       // make request to another microservice to get the participant list for this event with id
       List<Participant> participants = eventService.listParticipantsForEvent(event.getEventId());
       event.setEventParticipants(participants);
       return event;
    }
}

