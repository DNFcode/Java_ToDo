package nadja.sheduler;

/**
 * Интерфейс класса для работы c RSS
 * @author Nadja K.
 */
public interface RssWokerInterface {
    /**
     * Обновление rss-файла
     */
    public void updateRss();
    
    public void setdataBaseQueries(DBQueriesInterface dataBaseQueries);
    
    public DBQueriesInterface getdataBaseQueries();
     
    public void setwriter(RssWriterInterface writer);
    
    public RssWriterInterface getwriter();
     
    public void setfeed(RssFeedInterface feed);
    
    public RssFeedInterface getfeed();
    
    public void setheader(RssHeaderInterface header);
    
    public RssHeaderInterface getheader();
    
    public void setentry(RssEntryInterface entry);
    
    public RssEntryInterface getentry();
}
