package openbet.codehub.smdb.service;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.domain.Series;
import openbet.codehub.smdb.repository.SeriesRepository;
import openbet.codehub.smdb.transfer.SeriesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl extends BaseServiceImpl<Series> implements SeriesService {
    private final SeriesRepository seriesRepository;

    @Override
    public JpaRepository<Series, Long> getRepository() {
        return seriesRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly=true, rollbackFor = Exception.class)
    public List<SeriesDetails> findAllLazy() {
        List<SeriesDetails> seriesDetails = new ArrayList<>();
        seriesRepository.findAllLazy().forEach(series -> seriesDetails.add(
                new SeriesDetails(
                        series,
                        series.getActors(),
                        series.getDirectors(),
                        series.getProducers()
                )
        ));
        return seriesDetails;
    }
}
