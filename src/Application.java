import function.MainFunction;
import function.OrderFunction;
import function.UserFunction;
import main.MainController;

public class Application {

    UserFunction userFunction = new UserFunction();
    OrderFunction orderFunction = new OrderFunction();

    MainFunction mainFunction = new MainFunction();

    public void start() {
        int loginUserId = -1;

        while (true) {
            loginUserId = mainFunction.start();
            if (loginUserId == 0) break;
            if (loginUserId > 0) {
                while (true) {
                    int command = mainFunction.main();
                    if (command == 0) {
                        userFunction.logout();
                        break;
                    }

                    if(command == 1){
                        orderFunction.makeOrder(loginUserId);
                    }

                    if(command == 2){
                        orderFunction.checkOrder();
                    }
                }
            }

        }
    }
}
