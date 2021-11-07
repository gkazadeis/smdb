package openbet.codehub.smdb.repository;

import openbet.codehub.smdb.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer,Long> {
}
