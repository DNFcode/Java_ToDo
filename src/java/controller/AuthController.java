package controller;

import database.ObjectsDAO;
import database.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@SessionAttributes(types = User.class)
public class AuthController {
    private String result;
    //POST
    @RequestMapping(value = "/log_in", method = RequestMethod.POST)
    public ModelAndView authentication(User user, HttpServletRequest request){
        User dbUser = ObjectsDAO.getUserByName(user.getUsername());
        ModelAndView model = new ModelAndView("redirect:/");
        if(dbUser.getPassword().equals(user.getPassword())){
            String ip = request.getRemoteAddr();
            model.addObject("user", dbUser);
        }
        return model;
    }
}
