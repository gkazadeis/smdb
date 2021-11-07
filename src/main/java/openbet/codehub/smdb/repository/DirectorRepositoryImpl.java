package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Director;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DirectorRepositoryImpl extends AbstractRepository<Director> implements DirectorRepository{
    List<Director> directorStorage = new ArrayList<>();

    @Override
    public List<Director> getStorage() {
        return directorStorage;
    }
}
