package user;

import exception.DeleteFailedException;
import exception.SignupFailedException;
import exception.UserNotFoundException;
import user.model.User;
import user.model.UserService;

public class UserController {
    private static final UserService userService = new UserService();
    private static final UserView view = new UserView();
    private final int FAIL = -1;

    public String[] loginPage() {
        return view.loginView();
    }

    public int login(String[] inputs) {
        if (!validateInputCount(inputs, 2)) {
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

    public String[] signUpPage() {
        return view.signupView();
    }

    public int signup(String[] inputs) {
        if (!validateInputCount(inputs, 3)) {
            signupFail();
            return FAIL;
        }

        try {
            String userName = inputs[0];
            String loginId = inputs[1];
            String wp = inputs[2];
            userService.signup(userName, loginId, wp);
            signupSuccess();
            return 1;
        } catch (SignupFailedException e) {
            signupFail();
            return FAIL;
        }
    }

    public String[] deleteUserPage(){
        return view.deleteUserView();
    }

    public int deleteUser(String[] inputs) {
        if (!validateInputCount(inputs, 2)) {
            deleteFail();
            return FAIL;
        }

        try {
            String loginId = inputs[0];
            String wp = inputs[1];
            userService.deleteUser(loginId, wp);
            deleteSuccess();
            return 1;
        } catch (DeleteFailedException e) {
            deleteFail();
            return FAIL;
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

    private void deleteSuccess() {
        view.deleteSuccessView();
    }

    private void deleteFail() {
        view.deleteFailView();
    }
}
