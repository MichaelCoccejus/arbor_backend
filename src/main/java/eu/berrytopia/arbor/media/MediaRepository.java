package eu.berrytopia.arbor.media;

import eu.berrytopia.arbor.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Event,Long> {
}
