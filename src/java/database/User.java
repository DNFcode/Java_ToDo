package java.database;

import java.util.*;

public class User{
    private String username;
    private String email;
    private String password;
    private Boolean isVerified;
    private Boolean isAdmin;
    private Long dateCreate;

    private List<Friends> friendList;
    private List<ListUsers> listUsersList;

    public static User getUserByName(String username){
        return new User("unknown", "email@email.com", "");
    }

    public static List<User> getAllUsers(){
        Vector<User> users = new Vector<User>();
        return users;
    }

    public User(String username, String email, String password) {
        this.dateCreate = System.currentTimeMillis();
        this.isAdmin = Boolean.FALSE;
    }

    public List<Friends> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friends> friendList) {
        this.friendList = friendList;
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

    public long getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Long dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<ListUsers> getListUsersList() {
        return listUsersList;
    }

    public void setListUsersList(List<ListUsers> listUsersList) {
        this.listUsersList = listUsersList;
    }
}