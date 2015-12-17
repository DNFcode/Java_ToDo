package controller;

import database.ObjectsDAO;
import database.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.naming.directory.AttributeInUseException;

@RestController
@SessionAttributes(types = User.class)
public class MainController {
    //GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage(ModelAndView model, User user){
        model.setViewName("Mandarin");
        if (user.getUsername() == null){
            model.addObject("user", new User());
        }else {
            model.addObject("user", user);
        }
        return model;
    }

    @PostConstruct
    public void OnStart(){
        System.out.println("youAAAAA");
    }

}
