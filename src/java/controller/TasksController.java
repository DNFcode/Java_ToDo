package java.controller;

import java.database.Task;
import java.util.List;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TasksController {
    private List<Task> cachedTasks;
    //POST
    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public @ResponseBody Task newTask(@ResponseBody Task task){
        TaskList ts = new TaskList();
        task.setListId(ts.getListId());
    }
    //POST
    public void editTask(@RequestBody Task task){
        DB.save(task);
    }
    //POST
    public void deleteTask(){

    }

}
