package eu.berrytopia.arbor.arboruser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.berrytopia.arbor.geoobject.GeoObject;
import eu.berrytopia.arbor.organisation.Organisation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class ArborUser{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;


    //@JsonIgnoreProperties("arborUsers")
    @JsonIgnore
    @ManyToOne //owning Side
    private Organisation organisation;

    //@JsonIgnoreProperties("relatedUsers")
    @JsonIgnore
    @ManyToMany
    private Set<GeoObject> geoObjects = new HashSet<>();


    public ArborUser() {
    }

    public ArborUser(String firstName, String lastName, String nickname, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
    }

}
