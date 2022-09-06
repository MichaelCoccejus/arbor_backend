package eu.berrytopia.arbor.tree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/trees")
public class TreeController {
    private final TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService){
        this.treeService = treeService;
    }
    @GetMapping
    public List<Tree> getTrees(){
        return treeService.getTrees();
    }

    @PostMapping
    public void registerNewTree(@RequestBody Tree tree){
        treeService.addNewTree(tree);
    }

    @DeleteMapping(path = "{treeId}")
    public void deleteTree(@PathVariable("treeId") Long treeId){
        treeService.deleteTree(treeId);
    }

    @PutMapping(path = "{treeId}")
    public void updateTree(
            @PathVariable("treeId") Long treeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) LocalDate plantedDate) {
        treeService.updateTree(treeId, name, plantedDate);

    }
}
