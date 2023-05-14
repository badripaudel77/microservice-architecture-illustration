package se.eventlogic.eventservice.service;

import org.springframework.stereotype.Service;
import se.eventlogic.eventservice.entities.Event;
import se.eventlogic.eventservice.entities.Participant;

import java.util.List;

public interface EventService {

     Event getEventDetails(Integer eventId);

     List<Participant> listParticipantsForEvent(Integer eventId);
}
