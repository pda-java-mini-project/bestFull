package user.model;

import java.util.HashMap;

public class UserDAO {
    private HashMap<Integer, User> userDb = new HashMap<>();
    private int currentId = 0;

    public void insert(User user) {
        userDb.put(user.getId(), user);
    }

    public User select(String loginId, String wp) {
        User userResult = null;

        for (User user : userDb.values()) {
            if (user.getLoginId().equals(loginId) && user.getWp().equals(wp)) {
                userResult = user;
                break;
            }
        }
        return userResult;
    }

    public int generateId() {
        return ++currentId;
    }

    public boolean updateUser(User user) {
        if (userDb.containsKey(user.getId())) {
            userDb.put(user.getId(), user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String loginId, String wp) {
        User userToDelete = select(loginId, wp);
        if (userToDelete != null) {
            userDb.remove(userToDelete.getId());
            return true;
        }
        return false;
    }
}
