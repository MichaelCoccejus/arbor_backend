package eu.berrytopia.arbor.gpsPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/gpspositions")
public class GpsPositionController {

    private final GpsPositionService gpsPositionService;

    @Autowired
    public  GpsPositionController(GpsPositionService gpsPositionService) { this.gpsPositionService = gpsPositionService; }

    @GetMapping(path = "{gpsPositionId}")
    public GpsPosition getGpsPosition(@PathVariable("gpsPositionId") Long gpsPositionId) {

        Optional<GpsPosition> gpsPositionOptional = gpsPositionService.getGpsPosition(gpsPositionId);

        return gpsPositionOptional.orElseThrow( () -> new IllegalStateException("GPS Position with ID " + gpsPositionId + " does not exist."));
    }

}
