package ru.ifmo.mandrain.database;

import java.util.List;
import java.time.LocalDateTime;
/**
 * Выполнение запросов к базе данных
 * @author Nadja K.
 */
public class DBQueries implements DBQueriesInterface {
    
    //Подключение к бд 
    
    private List<Task> newTasks;
    /**
     * Получение списка последних обновленных тасков (или списков тасков, пока неясно)
     * @param timeBoundary дата и время обновления/создания таска должны превосходить значение этого параметра даты и времени
     * @return список с тасками, которые были добавлены/обновлены за какой-то определенный промежуток времени
     */
    public List<Task> getNewTasks(LocalDateTime timeBoundary){
        //Запрос к бд
        //newTasks = ;
        return newTasks;
    }
    
}
