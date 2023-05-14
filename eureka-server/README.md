## Eureka Server  

### This is also a microservice where all of our other microservices are registered later.

### To make it eureka server, we can use annotation @EnableEurekaServer to the main application

##### Client Registration
To make microservices client for eureka server, we have to add eureka client dependency in the 
respective application [microservice]
In Eureka server, you can perform the following tasks:

- Register services: Eureka server allows you to register services with it. 
  When a service is registered with Eureka server, it provides metadata about the service, such as its hostname, IP address, port number, and other attributes that can be used to identify the service.

- Discover services: Eureka server provides a way to discover services registered with it. 
  This allows services to find and communicate with each other without knowing the specific details of the location or configuration of the other services.

- Monitor service health: Eureka server monitors the health of services registered with it by 
  periodically sending heartbeat messages to the services and checking their responses. 
  If a service fails to respond to the heartbeat messages, Eureka server marks it as unavailable 
  and removes it from its registry.

- Load balancing: Eureka server can also be used for load balancing by distributing requests 
  to services based on their availability and capacity.

- Secure communication: Eureka server provides support for secure communication between 
  services by using HTTPS and SSL/TLS encryption.

- Dynamic configuration: Eureka server allows for dynamic configuration of service instances, 
  including adding, updating, and removing instances on-the-fly.

Overall, Eureka server provides a centralized and dynamic way for services to register and discover each other, and helps to simplify the complexities of service discovery and communication in a microservices architecture.


