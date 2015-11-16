package ru.ifmo.mandrain.sheduler;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Работа планировщика, надо потом в главный класс перенести
 * @author Nadja K.
 */
public class TasksRssSheduler {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context.xml");
        ctx.refresh();

        while (true) {
        }
    }
}
