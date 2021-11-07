package openbet.codehub.smdb.service;

import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.domain.Director;
import openbet.codehub.smdb.domain.Series;

public interface SeriesService extends BaseService<Series, Long> {
    void addActor(Series movie, Actor actor);

    void addDirector(Series movie, Director director);

    void removeActor(Series movie, Actor actor);

    void removeDirector(Series movie, Director director);

}
