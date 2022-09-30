package eu.berrytopia.arbor.geoobject;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.geoobject.event.Event;
import eu.berrytopia.arbor.geoobject.media.Media;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.organisation.Organisation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

import static javax.persistence.FetchType.EAGER;

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

    //@JsonIgnore
    //cascade={CascadeType.REFRESH,CascadeType.MERGE})
    @ManyToOne
    private Organisation organisation;

    @Transient
    private Long organisationId;


    public Long getOrganisationId() {
        return this.organisation.getId();
    }

    private String name;

    private String userDescription;

    //@JsonIgnore
    @ManyToMany(mappedBy = "geoObjects")
    private Set<ArborUser> relatedUsers = new HashSet<>();

    @OneToMany
    //@JsonIgnore
    private Set<GeoObject> relatedGeoObjects = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gps_position_id")
    private GpsPosition gpsPosition;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
    private Timestamp createdTime;

    @OneToMany(mappedBy = "geoObject", cascade = CascadeType.ALL, fetch = EAGER)
    private Set<Media> mediaSet = new HashSet<>();


    public GeoObject() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }
    public GeoObject(GeoObjectType type) {
        this.type = type;
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

    public GeoObject(GeoObjectType type, Organisation organisation, String name, String userDescription, Set<ArborUser> relatedUsers,
                     Set<GeoObject> relatedGeoObjects, GpsPosition gpsPosition, List<Event> events) {
        this.type = type;
        this.organisation = organisation;
        this.name = name;
        this.userDescription = userDescription;
        this.relatedUsers = relatedUsers;
        this.relatedGeoObjects = relatedGeoObjects;
        this.gpsPosition = gpsPosition;
        this.events = events;
        this.createdTime = new Timestamp(System.currentTimeMillis());
    }

}
