package openbet.codehub.smdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring Boot application initializer.
 */
@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(namedQueriesLocation = "classpath:jpa-named-queries.properties")
public class SmdbApplication {
	public static void main(String[] args) {
		SpringApplication.run(SmdbApplication.class, args);
	}
}
