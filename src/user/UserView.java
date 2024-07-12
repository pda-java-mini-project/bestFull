package user;

import user.entity.User;

public class UserView {
    public void loginSuccessView(User user){
        System.out.println(String.format("%s님, 안녕하세요.", user.getUserName()));
    }

    public void loginFailView(){
        System.out.println("로그인에 실패하였습니다.");
        System.out.println("아이디와 비밀번호를 정확히 입력해 주세요.");
    }
}
