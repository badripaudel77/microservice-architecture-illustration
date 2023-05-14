package se.eventlogic.eventservice.entities;

import java.util.Date;

public class Participant {
    private Integer participantId;
    private String participantName;
    private String participantLocation;
    private Date registeredDate;
    private Integer eventId;

    public Participant() {

    }

    public Participant(Integer participantId, String participantName, String participantLocation,
                       Date registeredDate, Integer eventId) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.participantLocation = participantLocation;
        this.registeredDate = registeredDate;
        this.eventId = eventId;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantLocation() {
        return participantLocation;
    }

    public void setParticipantLocation(String participantLocation) {
        this.participantLocation = participantLocation;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
}
