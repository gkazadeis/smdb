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
        /*
        //@formatter:off
        List<Actor> actors = actorService.createAll(
                Actor.builder().name("Angelina").surname("Jolie").build(),
                Actor.builder().name("Scarlett").surname("Johansson").build(),
                Actor.builder().name("Benedict").surname("Cumberbatch").build(),
                Actor.builder().name("Daniel").surname("Craig").build(),
                Actor.builder().name("Johnny").surname("Depp").build(),
                Actor.builder().name("Winona").surname("Ryder").build(),
                Actor.builder().name("Uma").surname("Thurman").build()
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

        // Get all producers
        producerService.findAll().forEach(p -> logger.info("{}", p));

        //@formatter:off
        List<Movie> movies = movieService.createAll(
                Movie.builder()
                        .title("Tomb Raider")
                        .description("Based on the once popular video game")
                        .category(Category.ACTION)
                        .year(2001)
                        .actor(actorService.findBySurname("Jolie"))
                        .actor(actorService.findBySurname("Craig"))
                        .build(),
                Movie.builder()
                        .title("Edward Scissorhands")
                        .description("Modern day dark fairytale")
                        .category(Category.DRAMA)
                        .year(1990)
                        .actor(actorService.findBySurname("Depp"))
                        .actor(actorService.findBySurname("Ryder"))
                        .director(directorService.findBySurname("Burton"))
                        .build(),
                Movie.builder()
                        .title("Kill Bill Vol 1")
                        .description("Grindhouse inspired film about revenge")
                        .category(Category.ACTION)
                        .year(2003)
                        .actor(actorService.findBySurname("Thurman"))
                        .director(directorService.findBySurname("Tarantino"))
                        .build()
        );
        //@formatter:on

        logger.info("{} movies created.", movies.size());
        // Get all movies
        movieService.findAll().forEach(m -> logger.info("{}", m));

        //@formatter:off
        List<Series> series = seriesService.createAll(
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

        logger.info("{} series created.", series.size());
        // Get all series
        seriesService.findAll().forEach(s -> logger.info("{}", s));
*/
    }
}
