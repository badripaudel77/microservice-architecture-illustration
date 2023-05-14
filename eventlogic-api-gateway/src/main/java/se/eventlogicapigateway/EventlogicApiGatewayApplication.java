package se.eventlogicapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EventlogicApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventlogicApiGatewayApplication.class, args);
		System.out.println("Api Gateway is up and running.");
	}

}
