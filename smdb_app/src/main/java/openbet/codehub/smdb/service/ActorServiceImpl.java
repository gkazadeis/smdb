package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.repository.ActorRepository;
import openbet.codehub.smdb.transfer.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly=true, rollbackFor = Exception.class)
    public List<PersonDetails> findAllLazy() {
        List<PersonDetails> personDetails = new ArrayList<>();
        actorRepository.findAllLazy().forEach(actor -> personDetails.add(
                new PersonDetails(
                        actor,
                        actor.getMovies(),
                        actor.getSeries()
                )
        ));
        return personDetails;
    }
}
