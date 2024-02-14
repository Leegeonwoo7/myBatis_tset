package user.service;

import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.Scanner;

public class UserUpdateService  implements UserService {

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        UserDAO userDAO = UserDAO.getInstance();

        System.out.println("찾고자 하는 아이디 입력: ");
        String id = scan.nextLine();
        UserDTO userDTO = userDAO.findId(id);
        if(userDTO == null){
            System.out.println("찾고자 하는 아이디가 없습니다.");
            return;
        } else {
            System.out.print("수정할 이름 입력 : ");
            String newName = scan.nextLine();
            userDTO.setName(newName);

            System.out.print("수정할 비밀번호 입력 : ");
            String newPwd = scan.nextLine();
            userDTO.setPwd(newPwd);

            userDAO.updateUser(userDTO);

            System.out.println("회원정보 수정완료");
            System.out.println(userDTO.getName()
                    + "\t" +userDTO.getId()
                    + "\t" + userDTO.getPwd());
        }




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
