package eu.berrytopia.arbor.organisation;

import eu.berrytopia.arbor.arboruser.ArborUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

public class OrganisationConfig {
    @Bean
    CommandLineRunner commandLineRunner(OrganisationRepository organisationRepository){
        return args -> {
            Organisation organisation1 = new Organisation("Test1",
                    Set.of(new ArborUser("Max","Mistermann","maxi","max@gmx.de")));
            organisationRepository.saveAll(List.of(organisation1));
        };
    }
}
