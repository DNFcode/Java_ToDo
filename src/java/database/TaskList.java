package java.database;

import java.util.List;
import java.util.Vector;

public class TaskList {
    private Long listId;
    private String title;
    private Boolean isPublic;
    private String author;
    private Long dateCreate;
    private Long dateChange;

    private List<Task> tasksList;

    public static List<TaskList> getPublicLists(){
        Vector<TaskList> lists = new Vector<TaskList>();
        return lists;
    }

    public static List<TaskList> getAuthorsLists(String author){
        Vector<TaskList> lists = new Vector<TaskList>();
        return lists;
    }

    public static TaskList getListById(Long listId){
        return new TaskList("list", "author");
    }

    public TaskList(String title, String author) {
        this.title = title;
        this.isPublic = Boolean.FALSE;
        this.author = author;
        this.dateCreate = System.currentTimeMillis();
        this.dateChange = System.currentTimeMillis();
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Long dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Long getDateChange() {
        return dateChange;
    }

    public void setDateChange(Long dateChange) {
        this.dateChange = dateChange;
    }

    public List<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Task> tasksList) {
        this.tasksList = tasksList;
    }
}
