package java.database;

public class LoginLog{
    private String username;
    private Long loginTime;
    private Long logoutTime;
    private String ip;

    private User user;

    public LoginLog(String username, Long loginTime, Long logoutTime, String ip) {
        this.username = username;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Long logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}