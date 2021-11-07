package openbet.codehub.smdb.service;

import openbet.codehub.smdb.domain.Director;

public interface DirectorService extends BaseService<Director, Long> {
    Director findBySurname(String surname);
}
