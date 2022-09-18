package eu.berrytopia.arbor.arboruser.task;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.geoobject.GeoObject;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Task extends GeoObject {


    /*@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;*/

    private String taskName;
    private Date startTime;
    private Date endTime;

    private List<ArborUser> relatedUsers;
    private List<GeoObject> relatedGeoObjects;

    public Task() {
    }
}
