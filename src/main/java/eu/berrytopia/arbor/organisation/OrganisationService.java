package eu.berrytopia.arbor.organisation;



import eu.berrytopia.arbor.arboruser.ArborUser;
import eu.berrytopia.arbor.arboruser.ArborUserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Component
public class OrganisationService {
    private final OrganisationRepository organisationRepository;
    private final ArborUserService arborUserService;

    public OrganisationService(OrganisationRepository organisationRepository, ArborUserService arborUserService) {
        this.organisationRepository = organisationRepository;
        this.arborUserService = arborUserService;
    }

    public Organisation getOrganisationById(Long id){
        Optional<Organisation> organisationOptional = organisationRepository.findById(id);
        if (!organisationOptional.isPresent()){
            throw new IllegalStateException("Organisation with ID " + id + " not found.");
        }
        return organisationOptional.get();
    }

    public List<Organisation> getOrganisations() { return organisationRepository.findAll(); }

    public Long addNewOrganisation(Organisation organisation) {
        Optional<Organisation> organisationOptional = organisationRepository.findOrganisationByName(organisation.getName());
        if (organisationOptional.isPresent()){
            throw new IllegalStateException("Organisation Name is taken.");
        }

        Set<ArborUser> arborUserSet = organisation.getArborUsers();
        if(!arborUserSet.isEmpty()) {
            arborUserSet.forEach(arborUserService::addNewArborUser); //TO Do: Bug does not work
        }

        organisationRepository.save(organisation);

        return 1l; //To Do: return ID of new Organisation
    }

    public void deleteOrganisation(Long organisationId) {

        Optional<Organisation> organisationOptional = organisationRepository.findById(organisationId);

        boolean exists = organisationOptional.isPresent();
        if(!exists) {
            throw new IllegalStateException("Organisation with ID " + organisationId + "does not exist.");
        }
        Organisation organisation = organisationOptional.get();
        organisation.getArborUsers().forEach( arborUser -> {
                arborUserService.deleteArborUser(arborUser.getId());
        });
        organisationRepository.deleteById(organisationId);
    }

    public void updateOrganisation(Organisation organisation){
       /* Organisation organisationInRepository = organisationRepository.findById(organisation.getId()).orElseThrow(()-> new IllegalStateException(
                "Organisation with ID " + organisation.getId() + " does not exist."
        ));

        if (organisation.getName() != null && organisation.getName().length() > 0 && !Objects.equals(organisationInRepository.getName(), organisation.getName())) {

            organisationInRepository.setName(organisation.getName());
            organisationInRepository.setArborUsers(organisation.getArborUsers());
            organisationRepository.save(organisationInRepository);
        }*/

        organisationRepository.save(organisation);

    }

    /*public void addUserToOrganisation(ArborUser arborUser){
        Long organisationId = arborUser.getOrganisation().getId();
        Optional<Organisation> organisationOptional = organisationRepository.findById(organisationId);
        if (!organisationOptional.isPresent()){
            throw new IllegalStateException("Organisation with ID " + organisationId + " does not exist");
        }
        Organisation organisation = organisationOptional.get();
        organisation.setArborUsers(Set.of(arborUser));
        organisationRepository.save(organisation);
    }*/
}
