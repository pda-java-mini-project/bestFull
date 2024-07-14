package function;

import main.MainController;

public class MainFunction {
    MainController mainController = new MainController();
    UserFunction userFunction = new UserFunction();


    public int start(){

        int command = mainController.startPage();

        if(command == 0) {
            mainController.exitPage();
            return -1;
        }
        if(command == 1) return userFunction.login();
        if(command == 2) userFunction.join();

        return 0;
    }

    public int main(){
        return mainController.mainPage();
    }

}
