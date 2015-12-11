package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;

@Configuration
@EnableAutoConfiguration
@ComponentScan("controller")
public class MainClass {

    public static void main(String[] args) {

        SpringApplication.run(MainClass.class, args);
        Timer timer = new Timer();
        /*TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<UserVerify> userHash = ObjectsDAO.findAll();
                Long time = System.currentTimeMillis();
                for(UserVerify h: userHash){
                    if( h.getDateCreate()-time > 600000 ){
                        ObjectsDAO.delete(ObjectsDAO.select(User,h.getUserId()));
                        ObjectsDAO.delete(h);
                    }
                }
            }
        };
        timer.schedule(task, 600000);*/
    }

}