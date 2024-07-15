package user.service;

import exception.DeleteFailedException;
import exception.SignupFailedException;
import exception.UserNotFoundException;
import user.model.User;
import user.model.UserDAO;

public class UserService {
    private static final UserDAO userDAO = new UserDAO();

    public User login(String loginId, String wp) {
        User user = userDAO.select(loginId, wp);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public void signup(String userName, String loginId, String wp) {
        if (userName.isEmpty() || loginId.isEmpty() || wp.isEmpty()) {
            throw new SignupFailedException("Invalid input for signup.");
        }

        int id = userDAO.generateId();
        User newUser = new User(id, loginId, userName, wp);
        userDAO.insert(newUser);
    }

    public void deleteUser(String loginId, String wp) {
        boolean success = userDAO.deleteUser(loginId, wp);
        if (!success) {
            throw new DeleteFailedException("User not found or invalid credentials.");
        }
    }
}
