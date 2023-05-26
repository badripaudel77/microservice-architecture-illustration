package se.eventlogic.participantservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.eventlogic.participantservice.entities.Participant;
import se.eventlogic.participantservice.service.ParticipantService;

import java.util.List;

@RestController
@RequestMapping("api/v1/participants/")
public class ParticipantResource {

    private ParticipantService participantService;

    public ParticipantResource(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/{eventId}")
    public List<Participant> getAllParticipantsForEvent(@PathVariable("eventId") Integer eventId) throws InterruptedException {
        return participantService.getAllParticipantsForEvent(eventId);
    }
}
