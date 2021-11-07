package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Series;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeriesRepositoryImpl extends AbstractRepository<Series> implements SeriesRepository {
    List<Series> seriesStorage = new ArrayList<>();

    @Override
    public List<Series> getStorage() {
        return seriesStorage;
    }
}
