# Order Management System – Spring Boot Microservices (Development)

### Core Components:
1. **API Gateway**
    - Entry point for all clients
    - Routing, filtering, and authentication (JWT)
2. **Eureka Server**
    - Service discovery
3. **Spring Cloud Config Server**
    - Centralized configuration for all services
4. **Authentication Service**
    - JWT-based user authentication and authorization
5. **Order, Inventory, Payment Microservices**
    - Each manages its own business logic and database
6. **Kafka / RabbitMQ** _(Optional)_
    - For asynchronous communication between services
7. **Zipkin + Sleuth**
    - Distributed tracing
8. **Resilience4J**
    - Circuit Breakers for fault tolerance
9. **Prometheus + Grafana**
    - Monitoring and alerting
10. **Frontend Clients**
    - Angular / React / Mobile Apps / Postman


