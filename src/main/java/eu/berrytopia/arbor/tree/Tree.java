package eu.berrytopia.arbor.tree;

import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.organisation.Organisation;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;


@Getter
@Setter
@Entity
@Table
@ToString
public class Tree extends GeoObject {
    /*@Id
    @SequenceGenerator(
            name = "tree_sequence",
            sequenceName = "tree_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tree_sequence"
    )
    private long id;*/
    private LocalDate plantedDate;

    @Transient
    private Integer age;


    public int getAge(){
        return Period.between(this.plantedDate,LocalDate.now()).getYears();
    }

    public Tree(Organisation organisation, String type, String name, String userDescription, GpsPosition gpsPosition, List<GpsPosition> area, LocalDate plantedDate) {
        super(organisation, type, name, userDescription, gpsPosition, area);
        this.plantedDate = plantedDate;
    }

    public Tree(){
    }
}

