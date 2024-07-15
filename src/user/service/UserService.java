package user.service;

import exception.UserNotFoundException;
import user.entity.User;
import user.entity.UserDAO;

public class UserService {
    private static final UserDAO userDAO = new UserDAO();

    public User login(String loginId, String wp) throws UserNotFoundException {
        User user = userDAO.select(loginId, wp);
        if(user == null)
            throw new UserNotFoundException();
        return user;
    }

    public boolean signup(String userName, String loginId, String wp) {
        if (userName.isEmpty() || loginId.isEmpty() || wp.isEmpty()) {
            return false; // 입력값이 유효하지 않을 경우 false 반환
        }

        int id = userDAO.generateId();
        User newUser = new User(id, loginId, userName, wp);
        userDAO.insert(newUser);
        return true; // 회원가입 성공 시 true 반환
    }
}
