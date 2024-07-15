package user;

import exception.UserNotFoundException;
import user.entity.User;
import user.service.UserService;

public class UserController {
    private static final UserService userService = new UserService();
    private static final UserView view = new UserView();
    private final int FAIL = -1;

    public String[] loginPage() {
        return view.loginView();
    }

    public int login(String[] inputs) {
        if(!validateInputCount(inputs, 2)) {
            loginInputFail();
            return FAIL;
        }

        try {
            String loginId = inputs[0];
            String wp = inputs[1];
            User user = userService.login(loginId, wp);
            loginSuccess(user);

            return user.getId();
        } catch (UserNotFoundException e) {
            loginFail();
            return FAIL;
        }
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

    public boolean validateInputCount(String[] inputs, int requiredInputCount) {
        return inputs.length == requiredInputCount;
    }

    private void loginFail() {
        view.loginFailView();
    }

    private void loginInputFail() {
        view.loginInputFailView();
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
}
