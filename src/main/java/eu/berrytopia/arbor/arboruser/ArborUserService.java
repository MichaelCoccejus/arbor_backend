package eu.berrytopia.arbor.arboruser;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class ArborUserService {

    private final ArborUserRepository arborUserRepository;

    public ArborUserService(ArborUserRepository arborUserRepository) { this.arborUserRepository = arborUserRepository; }

    public List<ArborUser> getArborUsers() { return arborUserRepository.findAll(); }

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
