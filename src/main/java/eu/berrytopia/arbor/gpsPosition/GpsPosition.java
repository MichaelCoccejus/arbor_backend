package eu.berrytopia.arbor.gpsPosition;

import eu.berrytopia.arbor.geoobject.GeoObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;



@Getter
@Setter
@Entity
@Table
@ToString
public class GpsPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double longitude;
    private double latitude;
    private Long altitude;

    @OneToOne(cascade = CascadeType.ALL) //owning side
    private GeoObject geoObject;

    @ManyToOne
    private GeoObject geoObjects;

    public GpsPosition(){
    }

    public GpsPosition(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public GpsPosition(double longitude, double latitude, long altitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
    }
}

