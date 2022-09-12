package eu.berrytopia.arbor.organisation;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class OrganisationService {
    private final OrganisationRepository organisationRepository;

    public OrganisationService(OrganisationRepository organisationRepository) { this.organisationRepository = organisationRepository; }

    public List<Organisation> getOrganisations() { return organisationRepository.findAll(); }

    public void addNewOrganisation(Organisation organisation) {
        Optional<Organisation> organisationOptional = organisationRepository.findOrganisationByName(organisation.getName());
        if (organisationOptional.isPresent()){
            throw new IllegalStateException("Organisation Name is taken.");
        }
        organisationRepository.save(organisation);
    }

    public void deleteOrganisation(Long organisationId) {
        boolean exists = organisationRepository.existsById(organisationId);
        if(!exists) {
            throw new IllegalStateException("Organisation with ID " + organisationId + "does not exist.");
        }
        organisationRepository.deleteById(organisationId);
    }

    public void updateOrganisation(Organisation organisation){
        Organisation organisationInRepository = organisationRepository.findById(organisation.getId()).orElseThrow(()-> new IllegalStateException(
                "Organisation with ID " + organisation.getId() + " does not exist."
        ));

        if (organisation.getName() != null && organisation.getName().length() > 0 && !Objects.equals(organisationInRepository.getName(), organisation.getName())) {

            organisationInRepository.setName(organisation.getName());
        }

    }
}
