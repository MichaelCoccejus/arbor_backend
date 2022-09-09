package eu.berrytopia.arbor.tree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class TreeService {

    private final TreeRepository treeRepository;

    public TreeService(TreeRepository treeRepository){
        this.treeRepository = treeRepository;
    }


    public List<Tree> getTrees() {
       return treeRepository.findAll();
    }

    public void addNewTree(Tree tree) {
        Optional<Tree> treeOptional = treeRepository.findTreeByName(tree.getName());
        if (treeOptional.isPresent()){
            throw new IllegalStateException("Name is taken");
        }
        treeRepository.save(tree);
        System.out.println(tree);
    }

    public void deleteTree(Long treeId) {
       boolean exists = treeRepository.existsById(treeId);
       if(!exists) {
           throw new IllegalStateException("Tree with ID " + treeId + " does not exits");
       }
       treeRepository.deleteById(treeId);
    }


    @Transactional
    public void updateTree(Long treeId, String name, LocalDate plantedDate) {
        Tree tree = treeRepository.findById(treeId).orElseThrow(() -> new IllegalStateException(
                "Tree with ID " + treeId + " does not exist."
        ));

        if (name != null && name.length() > 0 && !Objects.equals(tree.getName(), name)){

            tree.setName(name);
        }
    }
}
