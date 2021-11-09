package openbet.codehub.smdb.service;

import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.domain.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {
    List<Movie> findByCategory(String category);

    Movie findByTitle(String title);
}
