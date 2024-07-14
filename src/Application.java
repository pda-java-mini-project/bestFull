import function.OrderFunction;
import function.UserFunction;
import main.MainController;

public class Application {

    MainController mainController = new MainController();
    UserFunction userFunction = new UserFunction();
    OrderFunction orderFunction = new OrderFunction();

    public void start(){
        int loginUserId = -1;

        while(true){
            int command = mainController.mainPage();
            if(command == 0) mainController.exitPage();

            if(command == 1) loginUserId = userFunction.login();
            if(command == 2) userFunction.join();

            if(loginUserId != -1){

                while(true){









                }
            }


        }

    }

}
