package eu.berrytopia.arbor;

import eu.berrytopia.arbor.arboruser.media.Media;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ArborApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArborApplication.class, args);
	}

}
