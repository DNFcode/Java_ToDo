package ru.ifmo.mandrain.sheduler;

import java.time.LocalDateTime;
import java.util.List;
import ru.ifmo.mandrain.database.DBQueriesInterface;
import ru.ifmo.mandrain.database.Task;
/**
 * Класс, отвечающий за работу с RSS
 * возможно, новые таски в файл будут добавляться, старые удаляться, а не весь контент заново помещать в файл
 * @author Nadja K.
 */
public class RssWoker implements RssWokerInterface {
    
    /**
     * Текущее время
     */
    private LocalDateTime currentTime;
    
    /**
     * Интервал, по которому смотреть обновление тасков
     * =0000-00-00T01:00:00, задать в конфигурации spring
     */
    private LocalDateTime distinctionTime;
    
    /**
     * Время, величину которого должна превосходить дата обновления таска
     */
    private LocalDateTime boundaryTime;
    
    private DBQueriesInterface dataBaseQueries;
    
    private List<Task> addTasks;
    
    public RssWoker(LocalDateTime distinctionTime) {
        this.distinctionTime = distinctionTime;
    }
    
    
    
    /**
     * Обновление rss-файла
     */    
    public void updateRss(){
        
        currentTime = LocalDateTime.now();
        boundaryTime = currentTime.minus(distinctionTime.getLong(null), null);
        addTasks = dataBaseQueries.getNewTasks(boundaryTime);
        //здесь должно быть обновление файла
    } 
}
