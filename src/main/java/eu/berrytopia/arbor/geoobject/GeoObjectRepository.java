package eu.berrytopia.arbor.geoobject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeoObjectRepository extends JpaRepository<GeoObject, Long> {

}
