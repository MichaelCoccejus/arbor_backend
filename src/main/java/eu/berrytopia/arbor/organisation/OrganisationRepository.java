package eu.berrytopia.arbor.organisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

    //@Query("SELECT n FROM Name n WHERE n.name = ?1")
    Optional<Organisation> findOrganisationByName(String name);
}
