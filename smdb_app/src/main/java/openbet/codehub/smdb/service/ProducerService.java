package openbet.codehub.smdb.service;

import openbet.codehub.smdb.domain.Producer;
import openbet.codehub.smdb.transfer.PersonDetails;

import java.util.List;

public interface ProducerService extends BaseService<Producer, Long> {
    List<PersonDetails> findAllLazy();
}
