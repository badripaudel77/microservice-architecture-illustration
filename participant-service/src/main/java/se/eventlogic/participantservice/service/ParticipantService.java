package se.eventlogic.participantservice.service;

import se.eventlogic.participantservice.entities.Participant;

import java.util.List;


public interface ParticipantService {

     List<Participant> getAllParticipantsForEvent(Integer eventId) throws InterruptedException;
}
