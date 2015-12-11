package controller;

import database.ObjectsDAO;
import database.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@SessionAttributes("user")
public class AuthController {
    private String result;
    //POST
    @RequestMapping(value = "/log_in", method = RequestMethod.POST)
    public @ResponseBody
    String authentication(User user,HttpServletRequest request, Model model){
        User forCheck = ObjectsDAO.getUserByName(user.getUsername());
        if(forCheck.getPassword().equals(user.getPassword())){
            /* Нашли и совпал */
            /* Должна установиться сессия(?) */
            String ip = request.getRemoteAddr();
            /* Создать объект и запихнуть в него id юзера с ip и датой  */
            model.addAttribute("user",user);
            return "start_page";
        }
        else {
            result = "Такого пользователя не существует или неправильный логин/пароль";
            model.addAttribute("result",result);
            return "start_page";
        }

    }
}
