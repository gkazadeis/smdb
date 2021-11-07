package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {
}
