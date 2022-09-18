package eu.berrytopia.arbor.arboruser.media;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Media extends GeoObject {

    private String previewUri;
    private String fullUri;


   /* public Media(String type, String name, String userDescription, GpsPosition gpsPosition,
                 LinkedList<GpsPosition> area, Timestamp createdTime,String previewUri, String fullUri) {
        super(type,name,userDescription,gpsPosition,area,createdTime);
        this.previewUri = previewUri;
        this.fullUri = fullUri;
    }*/

    public Media(){};

}
