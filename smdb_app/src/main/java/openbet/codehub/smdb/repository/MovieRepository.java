package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query("select distinct m from Movie m join fetch m.actors join fetch m.directors join fetch m.producers")
    List<Movie> findAllLazy();

}
