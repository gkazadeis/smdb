package openbet.codehub.smdb.service;

import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.transfer.ActorDetails;

import java.util.List;

public interface ActorService extends BaseService<Actor, Long> {
    Actor findBySurname(String surname);

    List<ActorDetails> findAllLazy();
}
