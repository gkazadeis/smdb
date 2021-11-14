package openbet.codehub.smdb.service;

import openbet.codehub.smdb.domain.Director;
import openbet.codehub.smdb.transfer.PersonDetails;

import java.util.List;

public interface DirectorService extends BaseService<Director, Long> {
    List<PersonDetails> findAllLazy();
}
