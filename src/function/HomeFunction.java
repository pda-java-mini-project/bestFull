package function;

import home.HomeController;

public class HomeFunction {
    HomeController homeController = new HomeController();
    UserFunction userFunction = new UserFunction();


    public int start(){

        int command = homeController.startPage();

        if(command == 0) {
            homeController.exitPage();
            return 0;
        }
        if(command == 1) return userFunction.login();
        if(command == 2) userFunction.signUp();
        if(command == 3) userFunction.deleteUser();

        return -1;
    }

    public int main(){
        return homeController.mainPage();
    }

}
