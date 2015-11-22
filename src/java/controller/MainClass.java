package java.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimerTask;
import java.util.Timer;

import java.lang.Override;
import java.util.TimerTask;

@SpringBootApplication
public class MainClass {

    public static void main(String[] args) {

        SpringApplication.run(MainClass.class, args);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<HashT> hasht = db.findAll();
                Long time = System.currentTimeMillis();
                for(HashT h: hasht){
                    if( h.getDateCreate()-time > 600000 ){
                        /* Пока так */
                        DB.delete(h);
                    }
                }
            }
        }
        timer.schedule(task, 600000);
    }

}