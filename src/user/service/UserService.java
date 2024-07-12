package user.service;

import user.entity.User;
import user.entity.UserDAO;

public class UserService {
    private static final UserDAO userDAO = new UserDAO();

    public User login(String loginId, String wp) {
        return userDAO.select(loginId, wp);
    }
}
