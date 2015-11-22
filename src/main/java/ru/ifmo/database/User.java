package ru.ifmo.database;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "USER")
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "IS_VERIFIED", nullable = false)
    @Type(type = "org.hibernate.type.BooleanType")
    private Boolean isVerified;
    @Column(name = "IS_ADMIN", nullable = false)
    @Type(type = "org.hibernate.type.BooleanType")
    private Boolean isAdmin;
    @Column(name = "DATE_CREATE")
    private Long dateCreate;
    //Не трогать
    @OneToMany(mappedBy = "user")
    private List<LoginLog> loginList;
    //Не трогать
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "friendRequester")
    private List<Friends> requestedFriends;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "friendReceiver")
    private List<Friends> receivedFriends;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "userListTasks")
    private List<TaskListUsers> taskList;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy = "author")
    private List<TaskList> authoredTasks;
    /*
    public static User getUserByName(String username){
        return new User("unknown", "email@email.com", "");
    }
    public static List<User> getAllUsers() {
        Vector<User> users = new Vector<User>();
        return users;
    }*/
    public User() {}
    /*
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isVerified = Boolean.FALSE;
        this.dateCreate = System.currentTimeMillis();
        this.isAdmin = Boolean.FALSE;
    }*/
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Friends> getRequestedFriends() {
        return requestedFriends;
    }

    public void setRequestedFriends(List<Friends> requestedFriends) {
        this.requestedFriends = requestedFriends;
    }

    public List<Friends> getReceivedFriends() {
        return receivedFriends;
    }

    public void setReceivedFriends(List<Friends> receivedFriends) {
        this.receivedFriends = receivedFriends;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Long getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Long dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<TaskListUsers> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskListUsers> taskList) {
        this.taskList = taskList;
    }

    public List<LoginLog> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<LoginLog> loginList) {
        this.loginList = loginList;
    }
}