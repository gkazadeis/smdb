package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.repository.ActorRepository;
import openbet.codehub.smdb.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl extends BaseServiceImpl<Actor> implements ActorService {
    private final ActorRepository actorRepository;

    @Override
    public BaseRepository<Actor, Long> getRepository() {
        return actorRepository;
    }

    @Override
    public Actor findBySurname(final String surname) {
        return actorRepository.findAll().stream().filter(a -> a.getSurname().equals(surname)).findAny().orElse(null);
    }
}
