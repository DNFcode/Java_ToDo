package java.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class AuthController {
    private String result;
    //POST
    @RequestMapping(value = "/log_in", method = RequestMethod.POST)
    @SessionAttributes("user")
    public @ResponseBody String authentication(User user,HttpServletRequest request){
        User forCheck = ObjectsDAO.getUserByName(user.getUsername());
        if(forCheck.getPassword().equal(user.getPasswor())){
            /* Нашли и совпал */
            /* Должна установиться сессия(?) */
            String ip = request.getRemoteAddr();
            /* Создать объект и запихнуть в него id юзера с ip и датой  */
            model.addObject("user",user);
            return "start_page";
        }
        else {
            result = "Такого пользователя не существует или неправильный логин/пароль";
            model.addAtribute("result",result);
            return "start_page";
        }

    }
}
