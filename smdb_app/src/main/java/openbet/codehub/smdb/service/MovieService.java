package openbet.codehub.smdb.service;

import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.domain.Movie;
import openbet.codehub.smdb.transfer.MovieDetails;

import java.util.List;
import java.util.Set;

public interface MovieService extends BaseService<Movie, Long> {
    List<Movie> findByCategory(String category);

    Movie findByTitle(String title);

    List<Movie> findTopRated(int topNumber);

    List<MovieDetails> findAllLazy();
}
