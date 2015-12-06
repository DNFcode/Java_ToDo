package java.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.mail.*;
import java.util.Properties;

import java.database.User;
import java.lang.Exception;

@Controller
public class UsersController {


    private void sendVerifyEmail(User user){
        final String username = "login ot gugla";
        final String password = "pass";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("fromSomeone@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject("A testing mail header !!!");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        }

        catch (MessagingException e)
        {
            System.out.println("Username or Password are incorrect ... exiting !");
        }
    }

    //POST
    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public @ResponceBody String newUser(@RequestBody User user){
        String result;
        try {
            Long suchwow = ObjectsDAO.save(user);
            model.addAttribute("result",suchwow)
            return "start_page";
        }
        catch(Exception e) {
            String result = "Oops"
            model.addAttribute("result",result)
            return "registration";
        }

    }

    //GET
    @RequestMapping(value = , method = RequestMethod.GET)
    public void verifyUser(@RequestParam(value="hash") String hash){
        try {
            HashT hash = DB.find(/* Ищем бд по has */);
            User user = DB.find(hash.getId()); /* Ищем юзера по id из has */
            user.setIsVerified(true);
            Long userID = ObjectsDAO.save(user); /* Сохранили юзера */
            ObjectsDAO.delete(userID); /* Снесли запись с хэшом по id юзера */
            Model model = new Model();
            String result = "GJ";
            model.addAttribute("result",result);
            return "start_page"
        }
        catch (Exception ex){
            Model model = new Model();
            String result = "Ошибка при попытке подтверждения";
            model.addAttribute("result",result);
            return "start_page"
        }
    }
    //POST
    @RequestMapping(value = "/addfriend", method = RequestMethod.POST)
    public void addFriend(){

    }
}
