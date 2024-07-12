package user.entity;

public class User {
    private int id;
    private int loginId;
    private String userName;
    private String wp;

    public User(int id, int loginId, String userName, String wp) {
        this.id = id;
        this.loginId = loginId;
        this.userName = userName;
        this.wp = wp;
    }

    public int getId() {
        return id;
    }

    public int getLoginId() {
        return loginId;
    }

    public String getUserName() {
        return userName;
    }

    public String getWp() {
        return wp;
    }
}
