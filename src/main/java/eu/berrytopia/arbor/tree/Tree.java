package eu.berrytopia.arbor.tree;

import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Getter
@Setter
@Entity
@Table
@ToString
public class Tree {
    @Id
    @SequenceGenerator(
            name = "tree_sequence",
            sequenceName = "tree_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tree_sequence"
    )
    private long id;
    private String name;
    private LocalDate plantedDate;

    @Transient
    private Integer age;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "gpsposition_id")
    private GpsPosition gpsPosition;

    public int getAge(){
        return Period.between(this.plantedDate,LocalDate.now()).getYears();
    }

    public Tree(long id, String name, LocalDate plantedDate) {
        this.id = id;
        this.name = name;
        this.plantedDate = plantedDate;
    }

    public Tree(long id, String name, LocalDate plantedDate, GpsPosition gpsPosition) {
        this.id = id;
        this.name = name;
        this.plantedDate = plantedDate;
        this.gpsPosition = gpsPosition;
    }

    public Tree(){
    }
}

