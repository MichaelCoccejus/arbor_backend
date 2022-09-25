package eu.berrytopia.arbor.organisation;

import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

import static eu.berrytopia.arbor.config.Config.requestMappingPath;

@RestController
@RequestMapping(path = requestMappingPath + "organisations")
public class OrganisationController {
    private final OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping
    public List<Organisation> getOrganisations(){ return organisationService.getOrganisations(); }

    @PostMapping
    public long addOrganisation(@RequestBody Organisation organisation) { return organisationService.addNewOrganisation(organisation); }

    @DeleteMapping(path = "{organisationId}")
    public void deleteOrganisation(@PathVariable("organisationId") Long organisationId) { organisationService.deleteOrganisation(organisationId); }

}
