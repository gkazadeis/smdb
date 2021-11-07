package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.*;
import openbet.codehub.smdb.repository.BaseRepository;
import openbet.codehub.smdb.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public BaseRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public List<Movie> findByCategory(final String category) {
        return movieRepository.findAll().stream().filter(m -> m.getCategory().toString().equals(category)).collect(Collectors.toList());
    }

    @Override
    public void addActor(Movie movie, Actor actor) {
        movie.getActors().add(actor);
    }

    @Override
    public void addDirector(Movie movie, Director director) {
        movie.getDirectors().add(director);
    }

    @Override
    public void removeActor(Movie movie, Actor actor) {
        movie.getActors().remove(actor);
    }

    @Override
    public void removeDirector(Movie movie, Director director) {
        movie.getDirectors().remove(director);
    }
}
