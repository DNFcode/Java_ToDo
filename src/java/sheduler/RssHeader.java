package nadja.sheduler;

public class RssHeader implements RssHeaderInterface {
    
    private String title = "";
    private String description = "";
    private String link = "";
    private String language = "";

    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public void setTitle(String title) {
        this.title = title;
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
    public String getLink() {
        return link;
    }
    
    @Override
    public void setLink(String link) {
        this.link = link;
    }
    
    @Override
    public String getLanguage() {
        return language;
    }
    
    @Override
    public void setLanguage(String language) {
        this.language = language;
    }
    
}
