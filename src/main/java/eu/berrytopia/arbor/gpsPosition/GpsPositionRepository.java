package eu.berrytopia.arbor.gpsPosition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GpsPositionRepository extends JpaRepository<GpsPosition, Long> {

    @Query("SELECT t FROM GpsPosition t WHERE t.id = ?1")
    Optional<GpsPosition> findGpsPositionById(Long id);

}
