package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Producer;
import openbet.codehub.smdb.repository.BaseRepository;
import openbet.codehub.smdb.repository.ProducerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl extends BaseServiceImpl<Producer> implements ProducerService {
    private final ProducerRepository producerRepository;

    @Override
    public BaseRepository<Producer, Long> getRepository() {
        return producerRepository;
    }
}
