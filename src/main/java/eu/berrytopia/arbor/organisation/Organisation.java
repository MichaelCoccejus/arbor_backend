package eu.berrytopia.arbor.organisation;


import eu.berrytopia.arbor.arboruser.ArborUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL)
    //@MapKey(name = "id")
    private Set<ArborUser> arborUsers;

    public Organisation(String name) {
        this.name = name;
    }
    public Organisation() {}
}
