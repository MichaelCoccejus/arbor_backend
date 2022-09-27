package eu.berrytopia.arbor.geoobject.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.berrytopia.arbor.attachment.entity.Attachment;
import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.geoobject.event.Event;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Media implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //@ManyToOne@JsonIgnore
    //@JoinColumn(name = "attachment_preview_id")
    //private Attachment attachmentPreview;

    @ManyToOne@JsonIgnore
    @JoinColumn(name = "attachment_full_id")
    private Attachment attachmentFull;

    @ManyToOne
    @JoinColumn(name = "geo_object_id")
    GeoObject geoObject;

    String contentType;


    //@ManyToOne(cascade = CascadeType.ALL) //owning side
    //private Event event;

    public Media(){};

}
