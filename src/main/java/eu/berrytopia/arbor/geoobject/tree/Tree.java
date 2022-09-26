package eu.berrytopia.arbor.geoobject.tree;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.geoobject.GeoObjectType;
import eu.berrytopia.arbor.geoobject.event.Event;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.organisation.Organisation;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@ToString
public class Tree extends GeoObject {

    private LocalDate plantedDate;

    @Transient
    private Integer age;

    public int getAge(){
        return Period.between(this.plantedDate,LocalDate.now()).getYears();
    }

    public Tree(Organisation organisation, String name, String userDescription, Set<ArborUser> relatedUsers, Set<GeoObject> relatedGeoObjects, GpsPosition gpsPosition, List<GpsPosition> area, List<Event> events, LocalDate plantedDate) {
        super(GeoObjectType.TREE, organisation, name, userDescription, relatedUsers, relatedGeoObjects, gpsPosition, area, events);
        this.plantedDate = plantedDate;
    }

    public Tree(){
        super(GeoObjectType.TREE);
    }
}

