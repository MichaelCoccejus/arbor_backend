package eu.berrytopia.arbor.geoobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.event.Event;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.organisation.Organisation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class GeoObject implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private Organisation organisation;

    @Transient
    private Long organisationId;

    public Long getOrganisationId() {
        return this.organisation.getId();
    }

    private String type;

    private String name;

    private String userDescription;

    @ManyToMany(mappedBy = "geoObjects")
    @JsonIgnoreProperties("geoObjects")
    private Set<ArborUser> relatedUsers = new HashSet<>();

    @OneToMany
    @JsonIgnoreProperties("relatedGeoObjects")
    private Set<GeoObject> relatedGeoObjects = new HashSet();


    @OneToOne(mappedBy = "geoObject",cascade = CascadeType.ALL)
    private GpsPosition gpsPosition;

    @OneToMany(mappedBy = "geoObject", cascade = CascadeType.ALL)
    private List<GpsPosition> area = new ArrayList<>();

    @OneToMany(mappedBy = "geoObject", cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
    private Timestamp createdTime;


    public GeoObject(Organisation organisation,String type, String name, String userDescription, GpsPosition gpsPosition, List<GpsPosition> area) {
        this.organisation = organisation;
        this.type = type;
        this.name = name;
        this.userDescription = userDescription;
        this.gpsPosition = gpsPosition;
        this.area = area;
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    public GeoObject() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }
}
