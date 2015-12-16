package controller;

import database.ObjectsDAO;
import database.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.naming.directory.AttributeInUseException;

@RestController
public class MainController {
    //GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage(ModelAndView model, @ModelAttribute("user") User user){
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
