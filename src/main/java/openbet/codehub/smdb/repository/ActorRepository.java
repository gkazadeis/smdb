package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
}
