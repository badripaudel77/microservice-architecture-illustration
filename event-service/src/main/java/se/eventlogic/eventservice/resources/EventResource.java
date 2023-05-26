package se.eventlogic.eventservice.resources;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import se.eventlogic.eventservice.entities.Event;
import se.eventlogic.eventservice.entities.Participant;
import se.eventlogic.eventservice.service.EventService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

@RestController
@RequestMapping("api/v1/events/")
public class EventResource {

    private EventService eventService;
    private Logger logger = LoggerFactory.getLogger(EventResource.class);

    /**
     * @param eventId
     * @return Event
     * This endpoint eventually calls another service for the participants, so here we have chances of being failed.
     * So, need to implement circuit breaker pattern [with the help of resilience4j]l
     * With the help of resilience4j
     * To monitor circuit breaker : http://{host_or_ip:ip}/actuator/circuitbreakers
     * To check the health status : http://{host_or_ip:port}/actuator
     */
    @CircuitBreaker(name = "eventParticipantCircuitBreaker", fallbackMethod = "getParticipantsFallBack")
    @Retry(name = "eventParticipantRetryCircuitBreaker", fallbackMethod = "getParticipantsFallBack") // this seems optional if already configured in yml file.
    @RateLimiter(name = "eventParticipantRateLimiterCircuitBreaker" , fallbackMethod = "getParticipantsFallBack")
    //TODO : time-limiter not working ...
    //@TimeLimiter(name = "eventParticipantTimeLimiterCircuitBreaker", fallbackMethod = "getParticipantsFallBackTimeLimiter")

    @GetMapping("{eventId}")
    public Event getEventDetails(@PathVariable("eventId") Integer eventId) {
        Event event =  eventService.getEventDetails(eventId);
        // make request to another microservice to get the participant list for this event with id
        logger.info("----------- Requesting to participant service.");
        List<Participant> participants = eventService.listParticipantsForEvent(eventId);
        event.setEventParticipants(participants);
        return event;
    }

    public EventResource(EventService eventService) {
        this.eventService = eventService;
    }

    /**
      * Fall back method : getParticipantsFallBack() when participant service fails, return type and parameter
     *  type must be same as calling method plus Throwable.
     */
    public Event getParticipantsFallBack(Integer eventId, Throwable exception) {
        logger.info("\n_________________________________\n" +
                "Something went wrong while calling PARTICIPANT-SERVICE for eventID " + eventId +
                "\nAnd exception message is :: " + exception.getMessage() +
                "\n_________________________________\n");
        // Handle the failure case however you want, such as logging, triggering etc.
        Event event = new Event();
        event.setEventParticipants(new ArrayList<>());
        return event;
    }

    public CompletionStage getParticipantsFallBackTimeLimiter(Integer eventId, Throwable exception) {
        logger.info("\n_________________________________\n" +
                "TIme Limiter Error : Something went wrong while calling PARTICIPANT-SERVICE for eventID " + eventId +
                "\nAnd exception message is :: " + exception.getMessage() +
                "\n_________________________________\n");
        // Handle the failure case however you want, such as logging, triggering etc.
        Event event = new Event();
        event.setEventParticipants(new ArrayList<>());
        return (CompletionStage) event;
    }
}

