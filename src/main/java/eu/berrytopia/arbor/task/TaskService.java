package eu.berrytopia.arbor.task;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) { this.taskRepository = taskRepository; }

    public List<Task> getTasks() { return taskRepository.findAll(); }

    public Task getTask(Long id) {

        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()){
            throw new IllegalStateException("Task with ID " + id + " doesn not exist.");
        }
        return taskOptional.get();
    }

    public void addTask(Task task) {
        Optional<Task> taskOptional = taskRepository.findById(task.getId());
        if (taskOptional.isPresent()) {
            throw new IllegalStateException("Task with ID " + task.getId() + " exists.");
        }
        taskRepository.save(task);
     }

     public void deleteTask(Long id){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(!taskOptional.isPresent()) {
            throw new IllegalStateException("Task with ID " + id + "does not exist");
        }
        taskRepository.deleteById(id);
     }

     @Transactional
     public void updateTask(Task task){
        Optional<Task> taskOptional = taskRepository.findById(task.getId());
         if (!taskOptional.isPresent()) {
             throw new IllegalStateException("Task with ID " + task.getId() + " does not exists.");
         }
         taskRepository.save(task);

     }

}
