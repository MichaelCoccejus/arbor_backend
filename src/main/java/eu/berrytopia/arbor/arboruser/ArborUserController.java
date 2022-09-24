package eu.berrytopia.arbor.arboruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static eu.berrytopia.arbor.config.Config.requestMappingPath;

@RestController
@RequestMapping(path = requestMappingPath + "users")
public class ArborUserController {

    private final ArborUserService arborUserService;

    @Autowired
    public ArborUserController(ArborUserService arborUserService) { this.arborUserService = arborUserService; }

    @GetMapping
    public List<ArborUser> getArborUsers() { return arborUserService.getArborUsers(); }

    @GetMapping(path = "{userId}")
    public ArborUser getArborUser(@PathVariable("userId") Long userId){
        return arborUserService.getArborUser(userId);
    }

    @PostMapping
    public void addNewUser(@RequestBody ArborUser arborUser) { arborUserService.addNewArborUser(arborUser); }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) { arborUserService.deleteArborUser(userId); }

    @PutMapping
    public void updateUser(@RequestBody ArborUser arborUser) { arborUserService.updateArborUser(arborUser);
    }



}
