package openbet.codehub.smdb.service;

import openbet.codehub.smdb.domain.Series;
import openbet.codehub.smdb.transfer.SeriesDetails;

import java.util.List;

public interface SeriesService extends BaseService<Series, Long> {
    List<SeriesDetails> findAllLazy();

}
