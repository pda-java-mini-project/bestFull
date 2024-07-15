package function;

import exception.SignupFailedException;
import exception.UserNotFoundException;
import user.UserController;

public class UserFunction {

    UserController userController = new UserController();

    public void signUp() {
        try {
            String[] idAndPwAndName = userController.signUpPage();
            userController.signup(idAndPwAndName);
        } catch (SignupFailedException e) {
            System.out.println("Signup failed: " + e.getMessage());
        }
    }

    public int login() {
        try {
            String[] idAndPw = userController.loginPage();
            return userController.login(idAndPw);
        } catch (UserNotFoundException e) {
            System.out.println("Login failed: " + e.getMessage());
            return -1;
        }
    }

    public void logout() {
        userController.logout();
    }

    public void deleteUser(){
        String[] idAndPw = userController.deleteUserPage();
        userController.deleteUser(idAndPw);
    }
}
