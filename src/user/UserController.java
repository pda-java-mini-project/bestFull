package user;

import user.entity.User;
import user.service.UserService;

public class UserController {
    private static final UserService userService = new UserService();
    private static final UserView view = new UserView();

    public int login(String loginId, String wp) {
        return 0;
    }

    public void logout() {
    }

    public String signup() {
        return "";
    }

    private void loginFail() {
    }

    private void loginSuccess() {
    }

    private void logoutSuccess() {
    }

    private void signupSuccess() {
    }

    private void signupFail() {
    }
}
