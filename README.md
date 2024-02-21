# Spring Security Project

Welcome to my Spring Security Project! This repository is a comprehensive Java backend project designed to enhance skills and understanding in Spring Security and related security practices. It covers a wide range of topics from basic authentication mechanisms to advanced security configurations.

## Topics Covered

- Flow of code in Spring Security
- Password Encoders
- Custom Filters
- CORS (Cross-Origin Resource Sharing) and CSRF (Cross-Site Request Forgery)
- JWT (JSON Web Tokens)
- OAuth 2.0 and OpenID Connect
- Integration with Keycloak for identity and access management

## Project Description
EasyBank is a simple banking application built using Spring Boot and Spring Security. The project focuses on demonstrating various aspects of Spring Security, including authentication, authorization, password encoding, custom filters, CORS, CSRF protection, JWT, OAuth 2.0, and integration with Keycloak.

## Features
Authentication and Authorization: Users can authenticate themselves using email and password. Access to certain endpoints and functionalities is restricted based on user roles.

Password Encoding: Passwords are securely stored using BCrypt password encoding.

Custom Filters: Custom filters are implemented to perform specific tasks such as logging and CORS handling.

Cross-Origin Resource Sharing (CORS): CORS configuration is provided to allow or restrict cross-origin requests to the application.

CSRF Protection: CSRF protection is enabled to prevent cross-site request forgery attacks.

JSON Web Token (JWT): JWT is used for stateless authentication and authorization.

OAuth 2.0 and OpenID: Integration with OAuth 2.0 and OpenID providers, specifically Keycloak, is demonstrated.

## Project Structure
The project structure is organized as follows:

Controllers: Contains REST controllers for handling various HTTP requests.

Services: Business logic and service layer implementations.

Models: Entity classes representing database entities.

Repositories: Spring Data JPA repositories for database interactions.

Security Configurations: Configurations related to Spring Security, including authentication providers, custom filters, CORS, CSRF protection, JWT configuration, OAuth 2.0 setup, etc.

## Getting Started

### Prerequisites

- Java JDK 11 or later
- Maven 3.6 or later
- An IDE of your choice (IntelliJ IDEA, Eclipse, etc.)
- Redis (for session storage, optional)
- Keycloak server (for OAuth2 and OpenID Connect, optional)

### Installation

1. **Clone the repository**

   ```
   git clone https://github.com/tarunKumar0711/SpringSecurity.git
   ```

2. **Navigate to the project directory**

   ```
   cd SpringSecurity
   ```

3. **Build the project using Maven**

   ```
   mvn clean install
   ```

4. **Run the application**

   ```
   mvn spring-boot:run
   ```


## Contributing

Any contributions you made are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


---
