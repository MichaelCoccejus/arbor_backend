package eu.berrytopia.arbor.arboruser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArborUserConfig {

    @Bean
    CommandLineRunner arborUserConfigCommandLineRunner(ArborUserRepository arborUserRepository) {
        return args -> {};
    }
}
