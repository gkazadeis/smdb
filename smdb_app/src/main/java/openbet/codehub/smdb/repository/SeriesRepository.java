package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Long> {
    @Query("select distinct s from Series s left join fetch s.actors left join fetch s.directors left join fetch s.producers")
    List<Series> findAllLazy();
}
