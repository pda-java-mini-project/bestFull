package user.entity;

import java.util.HashMap;

public class UserDAO {
    private HashMap<Integer, User> userDb = new HashMap<>();
    private int currentId = 0; // 유니크한 ID를 생성하기 위한 필드 추가

    public void insert(User user) {
        userDb.put(user.getId(), user);
    }

    public User select(String loginId, String wp) {
        User userResult = null;

        for (User user : userDb.values()) {
            if (user.getLoginId().equals(loginId)) {
                if (user.getWp().equals(wp)) {
                    userResult = user;
                }
                break;
            }
        }
        return userResult;
    }

    public int generateId() {
        return ++currentId; // 유니크한 ID 생성
    }
}
