package eu.berrytopia.arbor.geoobject.media;

import eu.berrytopia.arbor.geoobject.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Event,Long> {
}
