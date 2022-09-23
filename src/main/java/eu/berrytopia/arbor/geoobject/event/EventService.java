package eu.berrytopia.arbor.geoobject.event;

import eu.berrytopia.arbor.organisation.OrganisationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventService {

    private final  EventRepository eventRepository;
    private final OrganisationRepository organisationRepository;

    public EventService(EventRepository eventRepository, OrganisationRepository organisationRepository) {
        this.eventRepository = eventRepository;
        this.organisationRepository = organisationRepository;
    }

    public List<Event> getEvents() { return eventRepository.findAll(); }

    public void addEvent(Event event) {
        Event newEvent = new Event(
                organisationRepository.getReferenceById(event.getOrganisationId()),
                event.getName(),
                event.getUserDescription(),
                event.getRelatedUsers(),
                event.getRelatedGeoObjects(),
                event.getGpsPosition(),
                event.getArea(),
                event.getEvents(),
                event.getEventType(),
                event.getMediaItems()
        );
        eventRepository.save(newEvent);
    }
}
