package eu.berrytopia.arbor.geoobject.event;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.geoobject.GeoObjectType;
import eu.berrytopia.arbor.geoobject.media.Media;
import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.organisation.Organisation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Event extends GeoObject {

    private String eventType;

    @OneToMany
    private List<Media> mediaItems;

    public Event(){
        super(GeoObjectType.EVENT);
    }

    public Event(Organisation organisation, String name, String userDescription, Set<ArborUser> relatedUsers, Set<GeoObject> relatedGeoObjects, GpsPosition gpsPosition, List<Event> events, String eventType, List<Media> mediaItems) {
        super(GeoObjectType.EVENT, organisation, name, userDescription, relatedUsers, relatedGeoObjects, gpsPosition, events);
        this.eventType = eventType;
        this.mediaItems = mediaItems;
    }
}
