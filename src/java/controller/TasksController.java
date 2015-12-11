package controller;

import java.util.List;

import database.ObjectsDAO;
import database.Task;
import database.TaskList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TasksController {
    private List<Task> cachedTasks;
    //POST
    @RequestMapping(value = "/addTaskList", method = RequestMethod.POST)
    public @ResponseBody Long newTaskList(@RequestBody TaskList taskList){
        Long blablabla = ObjectsDAO.save(taskList);
        return blablabla;
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public ResponseEntity newTask(@RequestBody Task task){
        try {
            ObjectsDAO.save(task);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //POST
    public void editTaskList(@RequestBody Task task){
        //200 ili ne 200
    }
    //POST
    public void deleteTaskList(){
        //200 ili ne 200
    }

}
