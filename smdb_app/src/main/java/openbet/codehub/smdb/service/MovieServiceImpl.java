package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.domain.Movie;
import openbet.codehub.smdb.repository.MovieRepository;
import openbet.codehub.smdb.transfer.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public List<Movie> findByCategory(final String category) {
        return movieRepository.findAll().stream().filter(m -> m.getCategory().toString().equals(category)).collect(Collectors.toList());
    }

    @Override
    public Movie findByTitle(final String title) {
        return movieRepository.findAll().stream().filter(m -> m.getTitle().equals(title)).findAny().orElse(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly=true, rollbackFor = Exception.class)
    public void addActor(Movie movie, Actor actor) {
        movie.getActors().add(actor);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly=true, rollbackFor = Exception.class)
    public List<MovieDetails> findAllLazy() {
        List<MovieDetails> movieDetails = new ArrayList<>();
        movieRepository.findAllLazy().forEach(movie -> movieDetails.add(
                new MovieDetails(
                        movie,
                        movie.getActors(),
                        movie.getDirectors(),
                        movie.getProducers()
                )
        ));
        return movieDetails;
    }

}
