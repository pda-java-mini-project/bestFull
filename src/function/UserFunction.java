package function;

import user.UserController;

public class UserFunction {

    UserController userController = new UserController();

    public void signUp(){
        String[] idAndPwAndName = userController.signUpPage();
        userController.signup(idAndPwAndName);
    }

    public int login(){
        String[] idAndPw = userController.loginPage();
        int userId = userController.login(idAndPw);
        return userId;
    }

    public void logout(){
        userController.logout();
    }

    public void deleteUser(){
        String[] idAndPw = userController.deleteUserPage();
        userController.deleteUser(idAndPw);
    }
}
