package eu.berrytopia.arbor.arboruser;

import eu.berrytopia.arbor.organisation.Organisation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class ArborUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;

    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;


    public ArborUser() {
    }

    public ArborUser(String firstName, String lastName, String nickname, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
    }

}
