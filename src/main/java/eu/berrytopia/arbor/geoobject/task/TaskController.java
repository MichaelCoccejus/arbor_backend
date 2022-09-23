package eu.berrytopia.arbor.geoobject.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static eu.berrytopia.arbor.config.Config.requestMappingPath;

@RestController
@RequestMapping(path = requestMappingPath + "tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    TaskController(TaskService taskService) { this.taskService = taskService; }

    @GetMapping
    public List<Task> getTasks() { return taskService.getTasks(); }

    @GetMapping(path = "{taskId}")
    public Task getTask(@PathVariable("taskId") Long taskId) {
        return taskService.getTask(taskId);
    }

}
