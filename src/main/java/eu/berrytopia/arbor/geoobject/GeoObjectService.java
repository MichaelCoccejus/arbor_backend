package eu.berrytopia.arbor.geoobject;

import eu.berrytopia.arbor.geoobject.event.EventRepository;
import eu.berrytopia.arbor.geoobject.tree.Tree;
import eu.berrytopia.arbor.geoobject.tree.TreeRepository;
import eu.berrytopia.arbor.organisation.OrganisationRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GeoObjectService {

    private final GeoObjectRepository geoObjectRepository;

    private final OrganisationRepository organisationRepository;

    private final EventRepository eventRepository;

    private final TreeRepository treeRepository;

    public GeoObjectService(GeoObjectRepository geoObjectRepository, EventRepository eventRepository, OrganisationRepository organisationRepository, TreeRepository treeRepository) {
        this.geoObjectRepository = geoObjectRepository;
        this.eventRepository = eventRepository;
        this.organisationRepository = organisationRepository;
        this.treeRepository = treeRepository;
    }


    public List<GeoObject> getGeoObjects() { return geoObjectRepository.findAll(); }

    public GeoObject getGeoObject(Long id) {

        Optional<GeoObject> geoObjectOptional = geoObjectRepository.findById(id);
        if (!geoObjectOptional.isPresent()) {
            throw new IllegalStateException("Object with ID " + id + " does not exist.");
        }

        return geoObjectOptional.get();
    }

    public void updateGeobject(GeoObject geoObject ){

        if(geoObject instanceof Tree){
            treeRepository.save((Tree)geoObject);
        }

        //To Do andere Objetypen berücksichtigen
    }
}
