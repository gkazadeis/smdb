package openbet.codehub.smdb.bootstrap;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.base.AbstractLogComponent;
import openbet.codehub.smdb.domain.*;
import openbet.codehub.smdb.service.ActorService;
import openbet.codehub.smdb.service.DirectorService;
import openbet.codehub.smdb.service.MovieService;
import openbet.codehub.smdb.service.ProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class GenerateContentRunner extends AbstractLogComponent implements CommandLineRunner {
	private final ActorService actorService;
	private final DirectorService directorService;
	private final ProducerService producerService;
	private final MovieService movieService;
	//private final SeriesService seriesService;

	@Override
	public void run(String... args) {
/*
		//@formatter:off
		List<Movie> movies = movieService.createAll(
				Movie.builder()
					 .title("Tomb Raider")
					 .description("Based on the once popular video game")
					 .category(Category.ACTION)
					 .year(2001)
					 .rating(6.78)
					 .build(),
				Movie.builder()
					 .title("Edward Scissorhands")
					 .description("Modern day dark fairytale")
					 .category(Category.DRAMA)
					 .year(1990)
					 .rating(7.8)
					 .build(),
				Movie.builder()
					 .title("Kill Bill Vol 1")
					 .description("Grindhouse inspired film about revenge")
					 .category(Category.ACTION)
					 .year(2003)
					 .rating(9.5)
					 .build(),
				Movie.builder()
						.title("Pirates of the Caribbean")
						.description("Great pirate movie")
						.category(Category.ACTION)
						.year(2003)
						.rating(8.1)
						.build()
		);
		//@formatter:on

		logger.info("{} movies created.", movies.size());
		// Get all movies
		movieService.findAll().forEach(m -> logger.info("{}", m));

		actorService.createAll(
				Actor.builder()
						.name("Angelina")
						.surname("Jolie")
						.build(),
				Actor.builder()
						.name("Johnny")
						.surname("Depp")
						.build(),
				Actor.builder()
						.name("Winona")
						.surname("Ryder")
						.build()
		);


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


		Actor a1 = actorService.find(2L);
		Actor a2 = actorService.find(3L);
		//Actor a3 = actorService.find(2L);
		Director d1 = directorService.find(1L);
		Movie m1 = movieService.findByTitle("Edward Scissorhands");
		Movie m2 = movieService.findByTitle("Pirates of the Caribbean");

		movieService.addActor(m1, a1);



		/*m1.getActors().add(a1);
		movieService.update(m1);
		m1.getActors().add(a2);
		m1.getDirectors().add(d1);
		movieService.update(m1);

		m2.getActors().add(a1);
		movieService.update(m2);*/

		Actor a1 = actorService.create(
				Actor.builder().name("Johnny").surname("Depp").build()
		);

		Actor a2 =	actorService.create(
				Actor.builder().name("Winona").surname("Ryder").build()
		);

		Director d1 = directorService.create(
				Director.builder().name("Tim").surname("Burton").build()
		);

		Producer p1 = producerService.create(
				Producer.builder().name("Tim").surname("Burton").build()
		);

		movieService.create(
				Movie.builder()
						.title("Edward Scissorhands")
						.description("Modern day dark fairytale")
						.category(Category.DRAMA)
						.year(1990)
						.rating(7.8)
						.actors(Set.of(a1, a2))
						.director(d1)
						.producer(p1)
						.build());

/*
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
