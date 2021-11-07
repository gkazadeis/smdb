package openbet.codehub.smdb.bootstrap;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.base.AbstractLogComponent;
import openbet.codehub.smdb.domain.*;
import openbet.codehub.smdb.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class GenerateContentRunner extends AbstractLogComponent implements CommandLineRunner {
    private final ActorService actorService;
    private final DirectorService directorService;
    private final ProducerService producerService;
    private final MovieService movieService;
    private final SeriesService seriesService;

    @Override
    public void run(String... args) {
        //@formatter:off
        List<Actor> actors = actorService.createAll(
                Actor.builder().name("Angelina").surname("Jolie").build(),
                Actor.builder().name("Scarlett").surname("Johansson").build(),
                Actor.builder().name("Benedict").surname("Cumberbatch").build(),
                Actor.builder().name("Daniel").surname("Craig").build(),
                Actor.builder().name("Johnny").surname("Depp").build(),
                Actor.builder().name("Winona").surname("Ryder").build()
        );
        //@formatter:on

        logger.info("{} actors created.", actors.size());

        // Get all actors
        actorService.findAll().forEach(a -> logger.info("{}", a));

        //@formatter:off
        List<Director> directors = directorService.createAll(
                Director.builder().name("Tim").surname("Burton").build(),
                Director.builder().name("Quentin").surname("Tarantino").build(),
                Director.builder().name("Christopher").surname("Nolan").build()
        );
        //@formatter:on

        logger.info("{} directors created.", directors.size());

        //@formatter:off
        List<Producer> producers = producerService.createAll(
                Producer.builder().name("Kevin").surname("Feige").build()
        );
        //@formatter:on

        logger.info("{} producers created.", producers.size());

        // Get all directors
        producerService.findAll().forEach(p -> logger.info("{}", p));

        //@formatter:off
       movieService.create(
                Movie.builder()
                        .title("Tomb Raider")
                        .description("Based on the popular video game")
                        .category(Category.ACTION)
                        .year(2001)
                        .actor(actorService.findBySurname("Jolie"))
                        .actor(actorService.findBySurname("Craig"))
                        .build()
        );
        //@formatter:on

       movieService.create(
                Movie.builder()
                        .title("Edward Scissorhands")
                        .description("Modern day fairytale")
                        .category(Category.DRAMA)
                        .year(1990)
                        .actor(actorService.findBySurname("Depp"))
                        .actor(actorService.findBySurname("Ryder"))
                        .director(directorService.findBySurname("Burton"))
                        .build()
        );
        //@formatter:on

        // Get all movies
        movieService.findAll().forEach(m -> logger.info("{}", m));

        //@formatter:off
        Series series1 = seriesService.create(
                Series.builder()
                        .title("Stranger Things")
                        .description("80s nostalgia epic thriller series")
                        .category(Category.HORROR)
                        .startYear(2016)
                        .seasons(3)
                        .actor(actorService.findBySurname("Ryder"))
                        .build()
        );

        //@formatter:on

        // Get all series
        seriesService.findAll().forEach(s -> logger.info("{}", s));

    }
}
