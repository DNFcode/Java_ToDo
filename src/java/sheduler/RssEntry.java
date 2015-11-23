package nadja.sheduler;

public class RssEntry implements RssEntryInterface {
    
    private String title = "";
    private String link = "";
    private String description = "";
    private String pubDate = "";
    private String guid = "";

    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public String getLink() {
        return link;
    }
    
    @Override
    public void setLink(String link) {
        this.link = link;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String getPubDate() {
        return pubDate;
    }
    
    @Override
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
    
    @Override
    public String getGuid() {
        return guid;
    }
    
    @Override
    public void setGuid(String guid) {
        this.guid = guid;
    }
    
}
