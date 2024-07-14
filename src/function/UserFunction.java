package function;

import user.UserController;

public class UserFunction {

    UserController userController = new UserController();

    public void join(){



    }

    public int login(){

        String[] idAndPw = userController.loginPage();
        int userId = userController.login(idAndPw);

        return userId;
    }
}
