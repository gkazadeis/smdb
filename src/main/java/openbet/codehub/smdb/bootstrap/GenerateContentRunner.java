package openbet.codehub.smdb.bootstrap;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.base.AbstractLogComponent;
import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.service.ActorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class GenerateContentRunner extends AbstractLogComponent implements CommandLineRunner {
    private final ActorService actorService;

    @Override
    public void run(String... args) {
        //@formatter:off
        List<Actor> actors = actorService.createAll(
                Actor.builder().name("Angelina").surname("Jolie").build(),
                Actor.builder().name("Scarlett").surname("Johansson").build(),
                Actor.builder().name("Benedict").surname("Cumberbatch").build()
        );
        //@formatter:on

        logger.info("{} customers created.", actors.size());

        // Get all customers
        actorService.findAll().forEach(c -> logger.info("{}", c));
    }
}
