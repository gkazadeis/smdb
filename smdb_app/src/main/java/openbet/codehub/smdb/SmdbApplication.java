package openbet.codehub.smdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Boot application initializer.
 */
@SpringBootApplication
@EnableJpaRepositories(namedQueriesLocation = "classpath:jpa-named-queries.properties")
public class SmdbApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmdbApplication.class, args);
	}
}
