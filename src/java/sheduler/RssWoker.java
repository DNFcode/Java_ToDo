package nadja.sheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nadja.sheduler.DBQueriesInterface;
import nadja.sheduler.TaskList;
/**
 * Класс, отвечающий за работу с RSS
 * возможно, новые таски в файл будут добавляться, старые удаляться, а не весь контент заново помещать в файл
 * @author Nadja K.
 */
public class RssWoker implements RssWokerInterface {
    
    private static String RSSFEED;
    
    private RssFeedInterface feed;
        
    private RssWriterInterface writer;
    
    private RssHeaderInterface header;
    
    private RssEntryInterface entry;
    
    /**
     * Текущее время
     */
    private LocalDateTime currentTime;
    
    /**
     * Интервал, по которому смотреть обновление тасков
     * =0000-00-00T01:00:00, задать в конфигурации spring
     */
    private int distinctionTime;
    
    /**
     * Время, величину которого должна превосходить дата обновления таска
     */
    private LocalDateTime boundaryTime;
    
    private DBQueriesInterface dataBaseQueries;
   
    private List<TaskList> addTasks;
    
    public RssWoker(String distinctionTime, String RSSFEED) {
        this.distinctionTime = Integer.parseInt(distinctionTime);
        this.RSSFEED = RSSFEED;        
    }
    
    @Override
    public void setdataBaseQueries(DBQueriesInterface dataBaseQueries){
        this.dataBaseQueries = dataBaseQueries;
    }
    
    @Override
    public DBQueriesInterface getdataBaseQueries(){
        return this.dataBaseQueries;
    }
    
    @Override 
    public void setwriter(RssWriterInterface writer){
        this.writer = writer;
    }
    
    @Override
    public RssWriterInterface getwriter(){
        return this.writer;
    }
    
    @Override 
    public void setfeed(RssFeedInterface feed){
        this.feed = feed;
    }
    
    @Override
    public RssFeedInterface getfeed(){
        return this.feed;
    }
    
    @Override
    public void setheader(RssHeaderInterface header){
        this.header = header;
    }
    
    @Override
    public RssHeaderInterface getheader(){
        return this.header;
    }
    
    @Override
    public void setentry(RssEntryInterface entry){
        this.entry = entry;
    }
    
    @Override
    public RssEntryInterface getentry(){
        return this.entry;
    }
    
    /**
     * Обновление rss-файла
     */    
    
    @Override
    public void updateRss(){
        
        currentTime = LocalDateTime.now();
        boundaryTime = currentTime.minusSeconds(distinctionTime);
        addTasks = dataBaseQueries.getNewTasks(boundaryTime);
        header.setTitle("Mandrain");
        header.setDescription("Последние обновления в списках задач");
        header.setLanguage("ru");
        header.setLink("http://www.mandrain.ru");
        feed.setHeader(header);
        List<RssEntryInterface> entries = new ArrayList<RssEntryInterface>();
//        TODO добавить все записи из addTasks
            entry.setTitle("Test");
            entry.setDescription("Test");
            entry.setGuid("Test");
            entry.setLink("Test");
            entry.setPubDate("Test");
            entries.add(entry);
        feed.setEntries(entries);
        try {
            writer.write(feed, RSSFEED);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
