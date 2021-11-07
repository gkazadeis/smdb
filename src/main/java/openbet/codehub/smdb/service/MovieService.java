package openbet.codehub.smdb.service;

import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.domain.Category;
import openbet.codehub.smdb.domain.Director;
import openbet.codehub.smdb.domain.Movie;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {
    List<Movie> findByCategory(String category);

    void addActor(Movie movie, Actor actor);

    void addDirector(Movie movie, Director director);

    void removeActor(Movie movie, Actor actor);

    void removeDirector(Movie movie, Director director);

}
