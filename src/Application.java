import function.HomeFunction;
import function.OrderFunction;
import function.UserFunction;

public class Application {

    UserFunction userFunction = new UserFunction();
    OrderFunction orderFunction = new OrderFunction();

    HomeFunction homeFunction = new HomeFunction();

    public void start() {
        int loginUserId = -1;

        while (true) {
            loginUserId = homeFunction.start();
            if (loginUserId == 0) break;
            if (loginUserId > 0) {
                while (true) {
                    int command = homeFunction.main();
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
