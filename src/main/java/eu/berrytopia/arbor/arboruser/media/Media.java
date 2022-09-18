package eu.berrytopia.arbor.arboruser.media;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.arboruser.event.Event;
import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.organisation.Organisation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
public class Media extends GeoObject {

    private String previewUri;
    private String fullUri;

    @ManyToOne(cascade = CascadeType.ALL) //owning side
    private Event event;

    public Media(Organisation organisation, String type, String name, String userDescription, GpsPosition gpsPosition, List<GpsPosition> area, String previewUri, String fullUri, Event event) {
        super(organisation, type, name, userDescription, gpsPosition, area);
        this.previewUri = previewUri;
        this.fullUri = fullUri;
        this.event = event;
    }

    public Media(){};

}
