package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    //GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void mainPage(){
        return "start_page";
    }

}
