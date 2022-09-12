package eu.berrytopia.arbor.gpsPosition;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;



@Getter
@Setter
@Entity
@Table
@ToString
@EqualsAndHashCode
public class GpsPosition {
    @Id
    @SequenceGenerator(
            name = "gpsposition_sequence",
            sequenceName = "gpsposition_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gpsposition_sequence"
    )
    private long id;
    private double longitude;
    private double latitude;


    public GpsPosition(){
    }

    public GpsPosition(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

