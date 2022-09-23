package eu.berrytopia.arbor.geoobject;

import eu.berrytopia.arbor.geoobject.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

import static eu.berrytopia.arbor.config.Config.requestMappingPath;

@RestController
@RequestMapping(path = requestMappingPath + "objects")
public class GeoObjectController {
    private final GeoObjectService geoObjectService;

    @Autowired
    GeoObjectController(GeoObjectService geoObjectService) { this.geoObjectService = geoObjectService; }

    @GetMapping
    public List<GeoObject> getGeoObjects () { return geoObjectService.getGeoObjects(); }

    @GetMapping(path = "{geoObjectId}")
    public GeoObject geoObject(@PathVariable("geoObjectId") Long geoObjectId) { return geoObjectService.getGeoObject(geoObjectId); }


}
