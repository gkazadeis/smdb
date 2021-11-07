package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Producer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProducerRepositoryImpl extends AbstractRepository<Producer> implements ProducerRepository{
    List<Producer> producerStorage = new ArrayList<>();

    @Override
    public List<Producer> getStorage() {
        return producerStorage;
    }
}
