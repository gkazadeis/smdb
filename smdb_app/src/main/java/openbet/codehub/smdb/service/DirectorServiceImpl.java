package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Director;
import openbet.codehub.smdb.repository.DirectorRepository;
import openbet.codehub.smdb.transfer.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl extends BaseServiceImpl<Director> implements DirectorService {
    private final DirectorRepository directorRepository;

    @Override
    public JpaRepository<Director, Long> getRepository() {
        return directorRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly=true, rollbackFor = Exception.class)
    public List<PersonDetails> findAllLazy() {
        List<PersonDetails> personDetails = new ArrayList<>();
        directorRepository.findAllLazy().forEach(director -> personDetails.add(
                new PersonDetails(
                        director,
                        director.getMovies(),
                        director.getSeries()
                )
        ));
        return personDetails;
    }
}
