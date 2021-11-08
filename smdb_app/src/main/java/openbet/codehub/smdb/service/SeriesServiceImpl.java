package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.domain.Director;
import openbet.codehub.smdb.domain.Series;
import openbet.codehub.smdb.repository.SeriesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl extends BaseServiceImpl<Series> implements SeriesService {
    private final SeriesRepository seriesRepository;

    @Override
    public JpaRepository<Series, Long> getRepository() {
        return seriesRepository;
    }

    /*@Override
    public void addActor(Series series, Actor actor) {
        series.getActors().add(actor);
    }

    @Override
    public void addDirector(Series series, Director director) {
        series.getDirectors().add(director);
    }

    @Override
    public void removeActor(Series series, Actor actor) {
        series.getActors().remove(actor);
    }

    @Override
    public void removeDirector(Series series, Director director) {
        series.getDirectors().remove(director);
    }*/
}
