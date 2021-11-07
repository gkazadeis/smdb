package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Long> {
}
