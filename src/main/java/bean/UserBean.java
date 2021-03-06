package main.java.bean;

/**
 * Created by Sheffy on 2018/3/27.
 */
public class UserBean {
    private String userId;
    private String password;
    private String favicon;

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean [userId=" + userId + ", password=" + password +",favicon="+favicon+ "]";
    }
}
