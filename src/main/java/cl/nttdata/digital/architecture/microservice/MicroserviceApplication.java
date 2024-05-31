package cl.nttdata.digital.architecture.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The MicroserviceApplication class is the entry point of the Spring Boot application.
 * It is responsible for starting the application and initializing the Spring context.
 * The main method calls the SpringApplication.run() method to start the application.
 * The @SpringBootApplication annotation is used to mark this class as a Spring Boot application.
 * This annotation enables auto-configuration and component scanning.
 *
 * @version 1.0
 * @since 1.0
 */
//add annotation to mark this class as a Spring Boot application
@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

}
