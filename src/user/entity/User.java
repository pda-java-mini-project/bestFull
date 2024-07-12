package user.entity;

public class User {
    private int id;
    private String loginId;
    private String userName;
    private String wp;

    public User(int id, String loginId, String userName, String wp) {
        this.id = id;
        this.loginId = loginId;
        this.userName = userName;
        this.wp = wp;
    }

    public int getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getUserName() {
        return userName;
    }

    public String getWp() {
        return wp;
    }
}
