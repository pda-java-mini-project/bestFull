package user;

import user.model.User;
import java.util.Scanner;

public class UserView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StringBuilder view = new StringBuilder();

    public String[] loginView() {
        view.setLength(0);
        view.append("*************************** 로그인 페이지 ****************************\n")
            .append("            아이디와 비밀번호를 스페이스 간격을 두고 입력해주세요\n")
            .append("********************************************************************\n");
        System.out.print(view);
        view.setLength(0);

        return getInput();
    }

    public void loginSuccessView(User user) {
        System.out.printf("%s님, 안녕하세요.\n", user.getUserName());
    }

    public void loginFailView() {
        System.out.println("로그인에 실패하였습니다.");
        System.out.println("아이디와 비밀번호를 정확히 입력해 주세요.");
    }

    public void loginInputFailView() {
        System.out.println("로그인에 실패하였습니다.");
        System.out.println("아이디와 비밀번호를 스페이스 간격을 두고 입력해주세요.");
    }

    public void logoutSuccessView() {
        System.out.println("로그아웃 되었습니다.");
    }

    public String[] signupView() {
        view.setLength(0);
        view.append("*************************** 회원가입 페이지 ****************************\n")
            .append("        가입할 이름, 아이디, 비밀번호를 스페이스 간격을 두고 입력해주세요 \n")
            .append("********************************************************************\n");
        System.out.print(view);
        view.setLength(0);

        return getInput();
    }

    public void signupSuccessView() {
        System.out.println("회원가입 되었습니다.");
    }

    public void signupFailView() {
        System.out.println("회원가입에 실패하였습니다.");
        System.out.println("가입할 이름, 아이디, 비밀번호를 스페이스 간격을 두고 정확히 입력해 주세요.");
    }

    public String[] deleteUserView() {
        view.setLength(0);
        view.append("*************************** 회원탈퇴 페이지 ****************************\n")
            .append("  탈퇴할 아이디와 비밀번호를 입력해주세요 \n")
            .append("********************************************************************\n");
        System.out.print(view);
        view.setLength(0);

        return getInput();
    }

    public void deleteSuccessView() {
        System.out.println("회원탈퇴 되었습니다.");
    }

    public void deleteFailView() {
        System.out.println("회원탈퇴에 실패하였습니다.");
        System.out.println("입력한 아이디와 비밀번호를 확인해 주세요.");
    }

    public String[] getInput() {
        System.out.print("입력: ");
        return scanner.nextLine().split(" ");
    }
}
