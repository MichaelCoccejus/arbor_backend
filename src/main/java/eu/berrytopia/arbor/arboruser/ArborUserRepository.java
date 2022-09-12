package eu.berrytopia.arbor.arboruser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArborUserRepository extends JpaRepository<ArborUser, Long> {

    @Query("SELECT u FROM ArborUser u WHERE u.nickname = ?1")
    Optional<ArborUser> findByNickname(String nickname);
}
