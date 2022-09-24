package eu.berrytopia.arbor.arboruser;

import eu.berrytopia.arbor.organisation.Organisation;
import eu.berrytopia.arbor.organisation.OrganisationRepository;
import eu.berrytopia.arbor.organisation.OrganisationService;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class ArborUserService {

    private final ArborUserRepository arborUserRepository;
    private final OrganisationRepository organisationRepository;



    public ArborUserService(ArborUserRepository arborUserRepository, OrganisationRepository organisationRepository) {
        this.arborUserRepository = arborUserRepository;
        this.organisationRepository = organisationRepository;
    }

    public List<ArborUser> getArborUsers() { return arborUserRepository.findAll(); }

    public ArborUser getArborUser(Long id){
        Optional<ArborUser> arborUserOptional = arborUserRepository.findById(id);
        if (!arborUserOptional.isPresent()){
            throw new IllegalStateException("User with ID " + id + " does not exist");
        }
        return arborUserOptional.get();
    }

    public void addNewArborUser(ArborUser arborUser) {
        Optional<ArborUser> arborUserOptional = arborUserRepository.findByNickname(arborUser.getNickname());
        if (arborUserOptional.isPresent()){
            throw new IllegalStateException("Nickname is taken.");
        }

        arborUserRepository.save(arborUser);
    }

    public void deleteArborUser(Long arborUserId) {
        boolean exists = arborUserRepository.existsById(arborUserId);
        if (!exists) {
            throw new IllegalStateException("User with ID " + arborUserId + " does not exist.");
        }
        arborUserRepository.deleteById(arborUserId);
    }

    @Transactional
    public void updateArborUser(ArborUser arborUser){
        Optional<ArborUser> arborUserOptional = arborUserRepository.findById(arborUser.getId());
        boolean exists = arborUserOptional.isPresent();

        if (!exists) {
            throw new IllegalStateException("User with ID " + arborUser.getId() + " does not exist.");
        }
        else {

            Optional<ArborUser> findUser = arborUserRepository.findByNickname(arborUser.getNickname());
            if (findUser.isPresent() && findUser.get().getId() != arborUser.getId()) {
                throw new IllegalStateException("Nickname " + arborUser.getNickname() + " is taken.");
            }
            else {
                arborUserRepository.save(arborUser);
            }
        }
    }




}
