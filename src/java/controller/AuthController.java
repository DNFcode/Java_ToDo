package java.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    //POST
    @RequestMapping(value = "/log_in", method = RequestMethod.POST)
    public @ResponseBody Response authentication(@RequestParam Gson data){
        String result;
        User user = new Gson().fromJson(data.toString(), User.class);
        if(/* ИЩЕМ ЮЗЕРА В БД */ && /* ПРОВЕРЯЕМ ПАСС ? */){
            /* УСТАНОВКА СЕССИИ */
            model.addAtribute("username",user.getUsername());
            return "start_page";
        }
        else {
            result = "Такого пользователя нет либо направильный логин/пароль";
            model.addAtribute("result",result);
            return "start_page";
        }

    }
}
