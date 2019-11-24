# Spring Microservices PoC

This is a simple Board/Cards application to test microservices with Spring.
The idea is to add as many Spring Cloud components as possible.

## Services

* cards: microservice to manage cards, storing card details and participants
* boards: boards to organize the cards into label groups
* discovery-service: Eureka server to allow service registration and discovery

## Spring Cloud Components

* Feign, to create proxies between services, mapping URLs to Java methods
* Ribbon, to allow load balancing when we add multiple service instances
* Eureka, to allow for service discovery
* Sleuth and Zipkin Client, to enable distributed tracing with to a Zipkin server

## Testing/Development Tools

For testing and usage, please refer to the postman collection in the postman folder.
