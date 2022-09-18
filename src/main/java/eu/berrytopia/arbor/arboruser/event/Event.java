package eu.berrytopia.arbor.arboruser.event;

import eu.berrytopia.arbor.arboruser.media.Media;
import eu.berrytopia.arbor.geoobject.GeoObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Event extends GeoObject {

    private String eventType;

    private String eventUserDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    private GeoObject geoObject;

    @OneToMany(mappedBy = "events")
    private List<Media> mediaItems;

}
