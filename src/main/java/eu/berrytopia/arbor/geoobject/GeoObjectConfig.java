package eu.berrytopia.arbor.geoobject;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.organisation.Organisation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class GeoObjectConfig {

    @Bean
    CommandLineRunner geoObjectCommandLineRunner(GeoObjectRepository geoObjectRepository) {
        return args -> {

            ArborUser maxi2 = new ArborUser("Max","Muster2","maxi2","max.muster2@gmx.de");
            Set<ArborUser> arborUsers = new HashSet<>();
            arborUsers.add(maxi2);

            GpsPosition gpsPosition = new GpsPosition(23,31,1);
            GpsPosition gpsPosition2 = new GpsPosition(24,32,2);

            GeoObject geoObject1 = new GeoObject(
                    new Organisation("TestOrgConfig"),
                    "Type",
                    "GeoObjectName",
                    "Testobject",
                    gpsPosition,
                    List.of(gpsPosition,gpsPosition2)
            );

            geoObjectRepository.saveAll(List.of(geoObject1));
        };
    }
}
