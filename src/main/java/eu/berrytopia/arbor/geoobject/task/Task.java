package eu.berrytopia.arbor.geoobject.task;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.geoobject.GeoObjectType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Task extends GeoObject {


    /*@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;*/

    private String taskName;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;




    public Task() {
        super(GeoObjectType.TASK);
    }
}
