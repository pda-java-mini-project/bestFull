package main.view;

import java.util.Scanner;

public class MainView {

    Scanner scanner = new Scanner(System.in);



    public int startView(){
        System.out.print("*************************** 시작 페이지 ****************************\n" +
                           "                   BESTful 배민에 오신 것을 환영합니다                 \n" +
                           "                0. 종료  1. 로그인  2. 회원가입 3. 회원탈퇴            \n" +
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


    public int mainView(){
        System.out.print("*************************** 시작 페이지 ****************************\n" +
                           "                   BESTful 배민에 오신 것을 환영합니다                 \n" +
                           "                0. 로그아웃 1. 주문하기  2. 주문내역 확인하기            \n" +
                           "******************************************************************\n" +
                           "입력: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
