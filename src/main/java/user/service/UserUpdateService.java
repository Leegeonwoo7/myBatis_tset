package user.service;

import user.dao.UserDAO;

import java.util.Scanner;

public class UserUpdateService  implements UserService {

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);

        System.out.println("찾고자 하는 아이디 입력: ");
        String name = scan.next();

        UserDAO userDAO = UserDAO.getInstance();
        boolean isVal = userDAO.update(name);

//        찾고자 하는 아이디 입력 : angel
//        찾고자 하는 아이디 없습니다.
//
//        또는
//        찾고자 하는 아이디 입력 : hong
//        홍길동	hong	111
//
//        수정할 이름 입력 : 홍당무
//        수정할 비밀번호 입력 : 333
//
//        회원정보 수정완료

    }

}
