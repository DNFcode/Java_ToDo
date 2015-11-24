package ru.ifmo.database;

import org.hibernate.annotations.Type;

import java.util.List;
import javax.persistence.*;
@Entity
@Table(name = "TASK_LIST")
public class TaskList extends ObjectsDAO {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "LIST_ID")
    private Long listId;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "IS_PUBLIC")//, nullable = false
    @Type(type = "org.hibernate.type.BooleanType")
    private Boolean isPublic;
    @Column(name = "DATE_CREATE")
    private Long dateCreate;
    @Column(name = "DATE_CHANGE")
    private Long dateChange;
    //mappedBy refers to the property name of the association on the owner side.
    //Т.е. mappedBy = объекту private TaskList list в классе Task.
    //НЕ ТРОГАТЬ
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "taskList")
    private List<Task> listTask;

    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "LIST_USERS",
    joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "LIST_ID"))*/
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "taskListUsers")
    private List<TaskListUsers> usersTaskList;

    @ManyToOne
    @JoinColumn(name = "AUTHOR")
    private User author;

    /*
    public static List<TaskList> getPublicLists(){
        Vector<TaskList> lists = new Vector<TaskList>();
        return lists;
    }

    public static List<TaskList> getAuthorsLists(Long authorId) {
        Vector<TaskList> lists = new Vector<TaskList>();
        return lists;
    }
    public static TaskList getListById(Long listId){
        return new TaskList("list", "author");
    }*/
    public TaskList() {}
    /*
    public TaskList(String title, User author) {
        this.title = title;
        this.isPublic = Boolean.FALSE;
        this.author = author;
        this.dateCreate = System.currentTimeMillis();
        this.dateChange = System.currentTimeMillis();
    }
    */

    public List<TaskListUsers> getUsers() {
        return usersTaskList;
    }

    public void setUsers(List<TaskListUsers> usersTaskList) {
        this.usersTaskList = usersTaskList;
    }

    public Long getListId() {
        return listId;
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

    public User getAuthorId() {
        return author;
    }

    public void setAuthorId(User author) {
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

    public List<Task> getListTask() {
        return listTask;
    }

    public void setListTask(List<Task> listTask) {
        this.listTask = listTask;
    }
}
