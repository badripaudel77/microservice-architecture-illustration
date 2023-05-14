package se.eventlogic.eventservice.entities;

import java.util.Date;
import java.util.List;

public class Event {

    private Integer eventId;
    private String eventName;
    private String location;
    private Date eventDate;
    private List<Participant> eventParticipants;

    public Event() {
    }

    public Event(Integer eventId, String eventName, String location, Date eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.location = location;
        this.eventDate = eventDate;
    }

    public Event(Integer eventId, String eventName, String location, Date eventDate, List<Participant> eventParticipants) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.location = location;
        this.eventDate = eventDate;
        this.eventParticipants = eventParticipants;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void ListEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void ListEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void ListLocation(String location) {
        this.location = location;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void ListEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public List<Participant> getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(List<Participant> eventParticipants) {
        this.eventParticipants = eventParticipants;
    }
}
