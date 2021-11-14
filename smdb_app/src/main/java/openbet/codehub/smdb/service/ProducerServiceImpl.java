package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Producer;
import openbet.codehub.smdb.repository.ProducerRepository;
import openbet.codehub.smdb.transfer.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl extends BaseServiceImpl<Producer> implements ProducerService {
    private final ProducerRepository producerRepository;

    @Override
    public JpaRepository<Producer, Long> getRepository() {
        return producerRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly=true, rollbackFor = Exception.class)
    public List<PersonDetails> findAllLazy() {
        List<PersonDetails> personDetails = new ArrayList<>();
        producerRepository.findAllLazy().forEach(producer -> personDetails.add(
                new PersonDetails(
                        producer,
                        producer.getMovies(),
                        producer.getSeries()
                )
        ));
        return personDetails;
    }
}
