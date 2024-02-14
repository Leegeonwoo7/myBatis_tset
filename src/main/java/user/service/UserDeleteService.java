package user.service;

import user.bean.UserDTO;
import user.dao.UserDAO;

import java.util.Scanner;

public class UserDeleteService implements UserService {

    @Override
    public void execute() {
            Scanner scan = new Scanner(System.in);
            UserDAO userDAO = UserDAO.getInstance();

            System.out.println("삭제 하려는 아이디 입력 : ");
            String id = scan.next();

            UserDTO userDTO = userDAO.findId(id);
            if (userDTO == null) {
                System.out.println("찾고자 하는 아이디 없습니다.");
                return;
            }
            System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
            userDAO.deleteUser(userDTO);
            System.out.println("삭제되었습니다.");

        }

    }
