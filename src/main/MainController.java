package main;

import main.view.MainView;

public class MainController {

    MainView view = new MainView();

    public int startPage(){
        int command;

        while(true){
            try{
                command = view.startView();
            } catch (NumberFormatException e){
                view.errorView("입력 값이 숫자가 아님");
                continue;
            }

            if(command > 3 || command < 0){
                view.errorView("0~2 사이 숫자가 아님");
                continue;
            }
            break;
        }

        return command;
    }

    public void exitPage(){
        view.exitView();
    }

    public int mainPage() {
        int command;

        while(true){
            try{
                command = view.mainView();
            } catch (NumberFormatException e){
                view.errorView("입력 값이 숫자가 아님");
                continue;
            }

            if(command > 3 || command < 0){
                view.errorView("0~2 사이 숫자가 아님");
                continue;
            }
            break;
        }

        return command;
    }
}
