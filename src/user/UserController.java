package user;

import user.entity.User;
import user.service.UserService;

public class UserController {
    private static final UserService userService = new UserService();
    private static final UserView view = new UserView();

    public String[] loginPage() {
        return view.loginView();
    }

    public int login(String[] inputs) {
        // 입력 개수 예외처리
        if (inputs.length != 2) {
            return -1;
        }

        String loginId = inputs[0];
        String wp = inputs[1];

        User user = userService.login(loginId, wp);

        if (user == null) {
            loginFail();
            return -1;
        }

        loginSuccess(user);

        return user.getId();
    }

    public void logout() {
        logoutSuccess();
    }


    public String[] signUpPage(){
        return view.signupView();
    }

    public int signup(String[] inputs) {
        // 입력 개수 예외처리
        if (inputs.length != 3) {
            signupFail();
            return -1;
        }

        String userName = inputs[0];
        String loginId = inputs[1];
        String wp = inputs[2];

        boolean success = userService.signup(userName, loginId, wp);

        if (success) {
            signupSuccess();
            return 1; // 회원가입 성공
        } else {
            signupFail();
            return -1; // 회원가입 실패
        }
    }

    public int deleteUser(String[] inputs) {
        if (inputs.length != 2) {
            deleteFail();
            return -1;
        }

        String loginId = inputs[0];
        String wp = inputs[1];

        boolean success = userService.deleteUser(loginId, wp);

        if (success) {
            deleteSuccess();
            return 1;
        } else {
            deleteFail();
            return -1;
        }
    }

    private void loginFail() {
        view.loginFailView();
    }

    private void loginSuccess(User user) {
        view.loginSuccessView(user);
    }

    private void logoutSuccess() {
        view.logoutSuccessView();
    }

    private void signupSuccess() {
        view.signupSuccessView();
    }

    private void signupFail() {
        view.signupFailView();
    }

    private void deleteSuccess() {
        view.deleteSuccessView();
    }

    private void deleteFail() {
        view.deleteFailView();
    }
}
