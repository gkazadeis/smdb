package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl extends AbstractRepository<Movie> implements MovieRepository {
    List<Movie> movieStorage = new ArrayList<>();

    @Override
    public List<Movie> getStorage() {
        return movieStorage;
    }
}
