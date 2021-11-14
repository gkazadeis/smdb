package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Actor;
import openbet.codehub.smdb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
    @Query("select distinct a from Actor a join fetch a.movies")
    List<Actor> findAllLazy();
}
