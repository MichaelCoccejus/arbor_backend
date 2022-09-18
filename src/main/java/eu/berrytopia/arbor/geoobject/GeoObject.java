package eu.berrytopia.arbor.geoobject;

import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.organisation.Organisation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class GeoObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Organisation organisation;

    private String type;

    private String name;

    private String userDescription;

    @OneToOne(mappedBy = "geoObject",cascade = CascadeType.ALL)
    private GpsPosition gpsPosition;

    @OneToMany(mappedBy = "geoObject", cascade = CascadeType.ALL)
    private List<GpsPosition> area = new ArrayList<>();
    private Timestamp createdTime;


    public GeoObject(Organisation organisation,String type, String name, String userDescription, GpsPosition gpsPosition, List<GpsPosition> area, Timestamp createdTime) {
        this.organisation = organisation;
        this.type = type;
        this.name = name;
        this.userDescription = userDescription;
        this.gpsPosition = gpsPosition;
        this.area = area;
        this.createdTime = createdTime;
    }

    public GeoObject() {
    }
}
