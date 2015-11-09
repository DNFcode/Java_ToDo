package java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.database.User;

@Controller
public class UsersController {


    private void sendVerifyEmail(User user){

    }

    private void deleteNotVerifiedUser(User user){

    }

    //POST
    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public @ResponceBody Response newUser(@RequestParams Gson data){
        User user = new Gson().fromJson(data.toString(), User.class);
        String result;
        if(/* œ–Œ¬≈– ¿ Õ¿ ”Õ» ¿À‹ÕŒ—“‹ */) {
            DBClass.save(user);
            result = "New user created";
            model.addAttribute("result",result)
            return "start_page";
        }
        else {
            result = "Oops"
            model.addAttribute("result",result)
            return "registration";
        }

    }

    //GET
    @RequestMapping(value = , method = RequestMethod.GET)
    public void verifyUser(){

    }
    //POST
    @RequestMapping(value = "/addfriend", method = RequestMethod.POST)
    public void addFriend(){

    }
}
