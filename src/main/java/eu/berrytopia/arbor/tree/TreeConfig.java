package eu.berrytopia.arbor.tree;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TreeConfig {

    @Bean
    CommandLineRunner commandLineRunner(TreeRepository repository){
        return args -> {

            Tree alba = new Tree(1,"morus alba",LocalDate.of(1902, Month.JANUARY,4));
            Tree nigra = new Tree(2,"morus nigra",LocalDate.of(2010, Month.JANUARY,4));

            repository.saveAll(List.of(alba,nigra));

        };

    }


}
