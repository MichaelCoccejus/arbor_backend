package eu.berrytopia.arbor.config;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.arboruser.ArborUserRepository;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
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
       /* ArborUser maxi = new ArborUser();
        maxi.setFirstName("Max");
        maxi.setLastName("Mustermann");
        maxi.setNickname("maxi");

        ArborUser hansi = new ArborUser("Hans", "Peter", "Hansi","Hansi@peter.de");



        Organisation organisation = new Organisation();
        organisation.setName("ArborOrganisation");
        organisation.setArborUsers(Set.of(maxi,hansi));
        maxi.setOrganisation(organisation);
        hansi.setOrganisation(organisation);

        Task task = new Task();
        task.setName("Make Arbor bigger");
        task.setOrganisation(organisation);
        organisation.setGeoObjects(Set.of(task));

        Event event = new Event();
        event.setOrganisation(organisation);
        event.setName("DemoEvent");
        event.setRelatedUsers(Set.of(maxi,hansi));

     *//*   Tree tree = new Tree(
                organisation,
                "Morus Alba",
                "Trägt weiße Früchte",
                Set.of(hansi),
                Set.of(task),
                new GpsPosition(23,41,1),
                null,
               null,
                LocalDate.of(2000,01,21)
        );
*//*






        organisationRepository.save(organisation);
        arborUserRepository.save(maxi);
        arborUserRepository.save(hansi);
        eventRepository.save(event);
        //treeRepository.save(tree);
        taskRepository.save(task);*/


    }




}
