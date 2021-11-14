package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,Long> {
    @Query("select distinct p from Producer p left join fetch p.movies left join fetch p.series")
    List<Producer> findAllLazy();
}
