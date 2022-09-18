package eu.berrytopia.arbor.geoobject;

import java.util.List;

public class GeoObjectService {

    private final GeoObjectRepository geoObjectRepository;

    public GeoObjectService(GeoObjectRepository geoObjectRepository) { this.geoObjectRepository = geoObjectRepository; }

    private List<GeoObject> getGeoObjects() { return geoObjectRepository.findAll(); }



}
