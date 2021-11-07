package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.repository.ActorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl extends BaseServiceImpl<Actor> implements ActorService {
    private final ActorRepository actorRepository;

    @Override
    public JpaRepository<Actor, Long> getRepository() {
        return actorRepository;
    }

    @Override
    public Actor findBySurname(final String surname) {
        return actorRepository.findAll().stream().filter(a -> a.getSurname().equals(surname)).findAny().orElse(null);
    }
}
