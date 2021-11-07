package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Director;
import openbet.codehub.smdb.repository.BaseRepository;
import openbet.codehub.smdb.repository.DirectorRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl extends BaseServiceImpl<Director> implements DirectorService {
    private final DirectorRepository directorRepository;

    @Override
    public BaseRepository<Director, Long> getRepository() {
        return directorRepository;
    }

    @Override
    public Director findBySurname(final String surname) {
        return directorRepository.findAll().stream().filter(d -> d.getSurname().equals(surname)).findAny().orElse(null);
    }
}
