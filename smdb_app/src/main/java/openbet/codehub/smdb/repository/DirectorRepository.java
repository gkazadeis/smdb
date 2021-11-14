package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {
    @Query("select distinct d from Director d left join fetch d.movies left join fetch d.series")
    List<Director> findAllLazy();
}
