package se.eventlogic.eventservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EventServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventServiceApplication.class, args);
        System.out.println("Event Service Is Up & Running.");
    }

    /**
     When you annotate a RestTemplate or WebClient instance with @LoadBalanced, Spring Cloud will intercept any
     outgoing HTTP requests from that instance and replace the service name in the URL with a dynamically
     resolved hostname and port number.
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
