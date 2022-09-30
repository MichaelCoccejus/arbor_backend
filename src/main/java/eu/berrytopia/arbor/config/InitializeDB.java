package eu.berrytopia.arbor.config;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.arboruser.ArborUserRepository;
import eu.berrytopia.arbor.arboruser.ArborUserService;
import eu.berrytopia.arbor.geoobject.GeoObjectRepository;
import eu.berrytopia.arbor.geoobject.GeoObjectType;
import eu.berrytopia.arbor.geoobject.event.Event;
import eu.berrytopia.arbor.geoobject.event.EventRepository;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.gpsPosition.GpsPositionRepository;
import eu.berrytopia.arbor.organisation.Organisation;
import eu.berrytopia.arbor.organisation.OrganisationRepository;
import eu.berrytopia.arbor.geoobject.task.Task;
import eu.berrytopia.arbor.geoobject.task.TaskRepository;
import eu.berrytopia.arbor.geoobject.tree.Tree;
import eu.berrytopia.arbor.geoobject.tree.TreeRepository;
import eu.berrytopia.arbor.organisation.OrganisationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class InitializeDB {

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);

    @Autowired
    ArborUserRepository arborUserRepository;

    @Autowired
    GeoObjectRepository geoObjectRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    GpsPositionRepository gpsPositionRepository;

    @Autowired
    TreeRepository treeRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    EventRepository eventRepository;

    @PostConstruct
    public void init()  {

        Organisation organisation = new Organisation("new Organisation");
        ArborUser arborUser = new ArborUser("Max","Muster","maxi","maxi@arbor.de");

        arborUser.setOrganisation(organisation);

       GpsPosition gpsPosition = new GpsPosition(49.48647,7.46546,108.21);

      Tree tree = new Tree();
      tree.setOrganisation(organisation);
      tree.setName("Morus Alba");
      tree.setUserDescription("Traegt weiße Fruechte");
      tree.setPlantedDate(LocalDate.of(2000,01,21));
      tree.setGpsPosition(gpsPosition);

      arborUser.getGeoObjects().add(tree);

      //Reihenfolge beachten
      organisationRepository.save(organisation);
        //gpsPositionRepository.save(gpsPosition)
      treeRepository.save(tree);
      arborUserRepository.save(arborUser);


    }




}
