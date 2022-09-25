package eu.berrytopia.arbor.geoobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.geoobject.event.Event;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class GeoObject implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private GeoObjectType type;

    @JsonIgnore
    @ManyToOne(cascade={CascadeType.REFRESH,CascadeType.MERGE})
    private Organisation organisation;

    @Transient
    private Long organisationId;



    public Long getOrganisationId() {
        return this.organisation.getId();
    }

    private String name;

    private String userDescription;

    @ManyToMany(mappedBy = "geoObjects")
    @JsonIgnoreProperties("geoObjects")
    private Set<ArborUser> relatedUsers = new HashSet<>();

    @ManyToMany
    @JsonIgnoreProperties("relatedGeoObjects")
    private Set<GeoObject> relatedGeoObjects = new HashSet();

    @OneToOne(mappedBy = "geoObject",cascade = CascadeType.ALL)
    private GpsPosition gpsPosition;

    @OneToMany(mappedBy = "geoObjects", cascade = CascadeType.ALL)
    private List<GpsPosition> area = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
    private Timestamp createdTime;


    public GeoObject() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }
    public GeoObject(GeoObjectType type) {
        this.type = type;
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    public GeoObject(GeoObjectType type, Organisation organisation, String name, String userDescription, Set<ArborUser> relatedUsers,
                     Set<GeoObject> relatedGeoObjects, GpsPosition gpsPosition, List<GpsPosition> area, List<Event> events) {
        this.type = type;
        this.organisation = organisation;
        this.name = name;
        this.userDescription = userDescription;
        this.relatedUsers = relatedUsers;
        this.relatedGeoObjects = relatedGeoObjects;
        this.gpsPosition = gpsPosition;
        this.area = area;
        this.events = events;
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

}
