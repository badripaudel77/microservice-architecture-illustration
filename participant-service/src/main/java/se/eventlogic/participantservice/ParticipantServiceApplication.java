package se.eventlogic.participantservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParticipantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParticipantServiceApplication.class, args);
        System.out.println("Participant Service is Up & Running");
    }

}
