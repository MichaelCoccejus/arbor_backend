package eu.berrytopia.arbor.gpsPosition;

import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.gpsPosition.GpsPositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GpsPositionConfig {

    @Bean
    CommandLineRunner gpsPositionConfigCommandLineRunner(GpsPositionRepository gpsPositionRepository){
        return args -> {

            GpsPosition one = new GpsPosition(24.0,9.0);
            GpsPosition two = new GpsPosition(49.0,5.0);
            GpsPosition three = new GpsPosition(51,41,21);

            gpsPositionRepository.saveAll(List.of(one,two,three));

        };

    }


}
