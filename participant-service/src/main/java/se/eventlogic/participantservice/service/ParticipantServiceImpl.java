package se.eventlogic.participantservice.service;

import org.springframework.stereotype.Service;
import se.eventlogic.participantservice.entities.Participant;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    // Just to fake the data, [in real life, this would be coming from db at runtime]
    List<Participant> participants = List.of(
            new Participant(1, "John Doe", "Location 1", new Date(), 1),
            new Participant(2, "Jane Doe", "Location 2", new Date(), 1),
            new Participant(3, "Bob Smith", "Location 3", new Date(), 2),
            new Participant(4, "Alice Johnson", "Location 4", new Date(), 2),
            new Participant(5, "Charlie Brown", "Location 5", new Date(), 3)
    );

    @Override
    public List<Participant> getAllParticipantsForEvent(Integer eventId) throws InterruptedException {
        System.out.println("Going to Sleep 3s   " + System.currentTimeMillis());
        Thread.sleep(3000);
        System.out.println("Going to resume  " + System.currentTimeMillis());

        Stream<Participant> participantStream = participants.stream().filter(participant -> Objects.equals(participant.getEventId(), eventId));
        return participantStream.toList();
    }
}
