package user;

import user.entity.User;
import user.service.UserService;

public class UserController {
    private static final UserService userService = new UserService();
    private static final UserView view = new UserView();

    public int login(String loginId, String wp) {
        User user = userService.login(loginId, wp);

        if(user == null) {
            loginFail();
            return -1;
        }

        loginSuccess(user);

        return user.getId();
    }

    public void logout() {
    }

    public String signup() {
        return "";
    }

    private void loginFail() {
        view.loginFailView();
    }

    private void loginSuccess(User user) {
        view.loginSuccessView(user);
    }

    private void logoutSuccess() {
    }

    private void signupSuccess() {
    }

    private void signupFail() {
    }
}
