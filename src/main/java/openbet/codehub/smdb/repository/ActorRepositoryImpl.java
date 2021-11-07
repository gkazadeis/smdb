package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Actor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepositoryImpl extends AbstractRepository<Actor> implements ActorRepository{
    List<Actor> customerStorage = new ArrayList<>();

    @Override
    public List<Actor> getStorage() {
        return customerStorage;
    }
}
