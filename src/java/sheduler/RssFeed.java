
package nadja.sheduler;

import java.util.List;

public class RssFeed implements RssFeedInterface {
    
    private RssHeaderInterface header;
    private List<RssEntryInterface> entries;

    @Override
    public void setHeader(RssHeaderInterface header){
        this.header = header;
    }

    @Override
    public void setEntries(List entries){
        this.entries = entries;
    }

    @Override
    public RssHeaderInterface getHeader() {
        return header;
    }

    @Override
    public List<RssEntryInterface> getEntries() {
        return entries;
    }
}
