package user;

import user.entity.User;

import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);

    public String[] loginView() {
        StringBuilder view = new StringBuilder();
        view.append("*************************** 로그인 페이지 ****************************")
            .append("            아이디와 비밀번호를 스페이스 간격을 두고 입력해주세요")
            .append("********************************************************************");
        System.out.println(view);

        return getInput();
    }

    public void loginSuccessView(User user){
        System.out.printf("%s님, 안녕하세요.%n", user.getUserName());
    }

    public void loginFailView(){
        System.out.println("로그인에 실패하였습니다.");
        System.out.println("아이디와 비밀번호를 정확히 입력해 주세요.");
    }

    public String[] getInput(){
        return scanner.nextLine().split(" ");
    }
}
