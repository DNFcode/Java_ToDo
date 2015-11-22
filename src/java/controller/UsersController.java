package java.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

import java.database.User;

@Controller
public class UsersController {


    private void sendVerifyEmail(User user){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("mail.host.com");

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(user.getEmail());
        helper.setText("Blablabla <a href='localhost/ok?hash="user.getHash()"'>TOUCH ME</a>");

        sender.send(message);
    }

    //POST
    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public @ResponceBody String newUser(@RequestBody User user){
        String result;
        if(/* Регистрация прошла */) {
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
    public void verifyUser(@RequestParam(value="hash") String hash){
        /* Обернуть в try catch */
        HashT hash = DB.find(/* Ищемв бд по has */);
        User user = DB.find(hash.getId()); /* Ищем юзера по id из has */
        user.setIsVerified(true);
        DB.save(user); /* Сохранили юзера */
        DB.delete(hash); /* Снесли запись с хэшом */

    }
    //POST
    @RequestMapping(value = "/addfriend", method = RequestMethod.POST)
    public void addFriend(){

    }
}
