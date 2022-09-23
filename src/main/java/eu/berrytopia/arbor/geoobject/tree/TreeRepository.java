package eu.berrytopia.arbor.geoobject.tree;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {

    @Query("SELECT t FROM Tree t WHERE t.name = ?1")
    Optional<Tree> findTreeByName(String name);

}
