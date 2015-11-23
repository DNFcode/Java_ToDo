package nadja.sheduler;

import java.util.List;

public interface RssFeedInterface {
    
    public void setHeader(RssHeaderInterface header);
  
    public void setEntries(List entries);

    public RssHeaderInterface getHeader();
  
    public List<RssEntryInterface> getEntries();
    
}