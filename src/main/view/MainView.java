package main.view;

import java.util.Scanner;

public class MainView {

    Scanner scanner = new Scanner(System.in);



    public int mainView(){
        System.out.println("*************************** 시작 페이지 ****************************\n" +
                           "                   BESTful 배민에 오신 것을 환영합니다                 \n" +
                           "                     0. 종료  1. 로그인  2. 회원가입                  \n" +
                           "******************************************************************\n" +
                           "입력: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void errorView(String err){
        System.out.println("입력값이 잘못되었습니다. 다시 시도해주세요." +
                "\n사유: " + err);
    }

    public void exitView(){
        System.out.println("애플리케이션을 종료합니다.");
    }


}
