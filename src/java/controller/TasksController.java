package java.controller;

import java.database.Task;
import java.util.List;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TasksController {
    private List<Task> cachedTasks;
    //POST
    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public void newTask(@RequestParam Gson data){
        Task task = new Gson().fromJson(data.toString(), Task.class);
        /* рср врн-рн ухрпне */
    }
    //POST
    public void editTask(){

    }
    //POST
    public void deleteTask(){

    }
    @
}
