package eu.berrytopia.arbor.config;

import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.arboruser.ArborUserRepository;
import eu.berrytopia.arbor.geoobject.GeoObjectRepository;
import eu.berrytopia.arbor.gpsPosition.GpsPosition;
import eu.berrytopia.arbor.gpsPosition.GpsPositionRepository;
import eu.berrytopia.arbor.organisation.Organisation;
import eu.berrytopia.arbor.organisation.OrganisationRepository;
import eu.berrytopia.arbor.task.Task;
import eu.berrytopia.arbor.task.TaskRepository;
import eu.berrytopia.arbor.tree.Tree;
import eu.berrytopia.arbor.tree.TreeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
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


    @PostConstruct
    public void init()  {
        ArborUser arborUser = new ArborUser();
        arborUser.setFirstName("Max");
        arborUser.setLastName("Mustermann");
        arborUser.setNickname("maxi");

        Organisation organisation = new Organisation();
        organisation.setName("Arbor");
        organisation.setArborUsers(Set.of(arborUser));
        arborUser.setOrganisation(organisation);

        arborUserRepository.save(arborUser);
        organisationRepository.save(organisation);

        Tree tree = new Tree(organisation,"Morus","Morus Alba","User Description",new GpsPosition(13,31,1), null,LocalDate.of(2000,01,21));
        treeRepository.save(tree);


        Task task = new Task();
        task.setName("Make Arbor bigger");
        task.setOrganisation(organisation);




        taskRepository.save(task);
        organisationRepository.save(organisation);

    }




}
