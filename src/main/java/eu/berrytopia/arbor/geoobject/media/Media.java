package eu.berrytopia.arbor.geoobject.media;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.geoobject.GeoObjectType;
import eu.berrytopia.arbor.geoobject.event.Event;
import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.organisation.Organisation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Media extends GeoObject {

    private String previewUri;
    private String fullUri;

    @ManyToOne(cascade = CascadeType.ALL) //owning side
    private Event event;

    public Media(Organisation organisation, String name, String userDescription, Set<ArborUser> relatedUsers, Set<GeoObject> relatedGeoObjects, GpsPosition gpsPosition, List<GpsPosition> area, List<Event> events, String previewUri, String fullUri, Event event) {
        super(GeoObjectType.MEDIA, organisation, name, userDescription, relatedUsers, relatedGeoObjects, gpsPosition, area, events);
        this.previewUri = previewUri;
        this.fullUri = fullUri;
        this.event = event;
    }

    public Media(){};

}
