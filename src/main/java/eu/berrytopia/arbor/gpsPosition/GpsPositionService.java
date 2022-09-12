package eu.berrytopia.arbor.gpsPosition;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class GpsPositionService {

    private final GpsPositionRepository gpsPositionRepository;

    public GpsPositionService(GpsPositionRepository gpsPositionRepository){
        this.gpsPositionRepository = gpsPositionRepository;
    }

    public List<GpsPosition> getGpsPositions() { return gpsPositionRepository.findAll(); }

    public Optional<GpsPosition> getGpsPosition(long gpsPositionId) {

        return gpsPositionRepository.findGpsPositionById(gpsPositionId);
    }

    public void addNewGpsPosition(GpsPosition gpsPosition) {
        gpsPositionRepository.save(gpsPosition);
    }

    public void deleteGpsPosition(Long gpsPositionId) {
        boolean exists = gpsPositionRepository.existsById(gpsPositionId);
        if (!exists){
            throw new IllegalStateException("GPS Position with ID " + gpsPositionId + " does not exist");
        }
        gpsPositionRepository.deleteById(gpsPositionId);
    }
    @Transactional
    public void updateGpsPosition(Long gpsPositionId, double longitude, double latitude){
        GpsPosition gpsPosition = gpsPositionRepository.findGpsPositionById(gpsPositionId).orElseThrow(() -> new IllegalStateException(
                "GPS Position with ID " + gpsPositionId + "does not exist."
        ));
    };
}
