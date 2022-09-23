package eu.berrytopia.arbor.arboruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class ArborUserController {

    private final ArborUserService arborUserService;

    @Autowired
    public ArborUserController(ArborUserService arborUserService) { this.arborUserService = arborUserService; }

    @GetMapping
    public List<ArborUser> getArborUsers() { return arborUserService.getArborUsers(); }

    @PostMapping
    public void addNewUser(@RequestBody ArborUser arborUser) { arborUserService.addNewArborUser(arborUser); }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) { arborUserService.deleteArborUser(userId); }

    @PutMapping
    public void updateUser(@RequestBody ArborUser arborUser) { arborUserService.updateArborUser(arborUser);
    }
}
