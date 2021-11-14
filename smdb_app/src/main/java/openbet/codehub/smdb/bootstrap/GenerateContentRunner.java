package openbet.codehub.smdb.bootstrap;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.base.AbstractLogComponent;
import openbet.codehub.smdb.domain.*;
import openbet.codehub.smdb.service.*;
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
	private final SeriesService seriesService;

	@Override
	public void run(String... args) {

		//@formatter:off
		Person a1 = actorService.create(Actor.builder().name("Johnny").surname("Depp").build());
		Person a2 =	actorService.create(Actor.builder().name("Winona").surname("Ryder").build());
		Person a3 =	actorService.create(Actor.builder().name("Uma").surname("Thurman").build());
		Person a4 =	actorService.create(Actor.builder().name("Lucy").surname("Liu").build());
		Person a5 =	actorService.create(Actor.builder().name("Matthew").surname("McConaughey").build());
		Person a6 =	actorService.create(Actor.builder().name("Robert").surname("Downey Jr.").build());
		Person a7 =	actorService.create(Actor.builder().name("Scarlett").surname("Johansson").build());
		Person a8 =	actorService.create(Actor.builder().name("Sarah Michelle").surname("Gellar").build());
		Person a9 =	actorService.create(Actor.builder().name("Ethan").surname("Hawke").build());
		Person a10 = actorService.create(Actor.builder().name("Maya").surname("Hawke").build());

		Person d1 = directorService.create(Director.builder().name("Tim").surname("Burton").build());
		Person d2 = directorService.create(Director.builder().name("Quentin").surname("Tarantino").build());
		Person d3 = directorService.create(Director.builder().name("Christopher").surname("Nolan").build());
		Person d4 = directorService.create(Director.builder().name("Joss").surname("Whedon").build());
		Person d5 = directorService.create(Director.builder().name("Matt").surname("Duffer").build());
		Person d6 = directorService.create(Director.builder().name("Ross").surname("Duffer").build());

		Producer p1 = producerService.create(Producer.builder().name("Kevin").surname("Feige").build());

		movieService.createAll(
				Movie.builder()
						.title("Edward Scissorhands")
						.description("Modern day dark fairytale")
						.category(Category.DRAMA)
						.year(1990)
						.rating(7.8)
						.actors(Set.of(a1, a2))
						.director(d1)
						.producer(d1)
						.build(),
				Movie.builder()
						.title("Kill Bill Vol 1")
						.description("Grindhouse inspired film about revenge")
						.category(Category.ACTION)
						.year(2003)
						.rating(9.5)
						.actors((Set.of(a3, a4)))
						.director(d2)
						.build(),
				Movie.builder()
						.title("Pirates of the Caribbean")
						.description("Great pirate movie")
						.category(Category.ACTION)
						.year(2003)
						.rating(8.1)
						.actor(a1)
						.build(),
				Movie.builder()
						.title("Interstellar")
						.description("Space epicness")
						.category(Category.DRAMA)
						.year(2014)
						.rating(8.62)
						.actor(a5)
						.director(d3)
						.build(),
				Movie.builder()
						.title("The Avengers")
						.description("Avengers asseble")
						.category(Category.ACTION)
						.year(2012)
						.rating(8.0)
						.actors(Set.of(a6, a7))
						.director(d4)
						.producer(p1)
						.build(),
				Movie.builder()
						.title("Tomb Raider")
						.description("Based on the once popular video game")
						.category(Category.ACTION)
						.year(2001)
						.rating(6.78)
						.build()
		);

		seriesService.createAll(
                Series.builder()
                        .title("Stranger Things")
                        .description("80s nostalgia epic thriller series")
                        .category(Category.HORROR)
                        .startYear(2016)
                        .seasons(3)
						.rating(8.7)
                        .actors(Set.of(a2, a10))
						.directors(Set.of(d5, d6))
                        .build(),
				Series.builder()
						.title("Buffy the vampire Slayer")
						.description("A young woman slays vampires and fights supernatural beings with the help of her friends.")
						.category(Category.ACTION)
						.startYear(1997)
						.endYear(2003)
						.seasons(7)
						.rating(8.2)
						.actor(a8)
						.director(d4)
						.build()
        );
        //@formatter:on

	}
}
