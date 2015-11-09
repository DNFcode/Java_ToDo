package java.database;

public class ListUsers {
    private Long listId;
    private String username;
    private Boolean mayEdit;

    private User user;
    private TaskList list;

    public ListUsers(Long listId, String username, Boolean mayEdit) {
        this.listId = listId;
        this.username = username;
        this.mayEdit = mayEdit;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getMayEdit() {
        return mayEdit;
    }

    public void setMayEdit(Boolean mayEdit) {
        this.mayEdit = mayEdit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskList getList() {
        return list;
    }

    public void setList(TaskList list) {
        this.list = list;
    }
}
