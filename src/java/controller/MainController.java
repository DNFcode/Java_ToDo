package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
    //GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage(){
        return new ModelAndView("hello");
    }

}
