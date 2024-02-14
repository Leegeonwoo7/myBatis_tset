package user.service;

import user.bean.UserDTO;
import user.dao.UserDAO;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserSearchService  implements UserService {
        @Override
        public void execute() {
            String name = "";
            String id = "";

            Scanner sc = new Scanner(System.in);
            System.out.println("1. 이름 검색");
            System.out.println("2. 아이디 검색");
            System.out.print("번호 입력: ");
            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.print("검색할 이름 입력: ");
                name = sc.next();
            }else if (menu == 2){
                System.out.print("검색할 아이디 입력: ");
                id = sc.next();
            }
            Map<String, String> map = new HashMap<>();
            map.put("id", id);
            map.put("name", name);

            UserDAO userDAO = UserDAO.getInstance();
            List<UserDTO> list = userDAO.search(map);

            for (UserDTO userDTO : list) {
                System.out.println(userDTO.getName());
                System.out.println(userDTO.getId());
            }
        }
    }
//            1. 이름 검색
//            2. 아이디 검색
//            번호 입력 : 1
//
//            검색할 이름 입력 : 동
//            홍길동 	hong	111
//            희동이 	hee		111
//
//            검색할 아이디 입력 : n
//            홍길동 	hong	111
//            코난 		conan	111
//
//            1번이건, 2번이건 => userDAO.search() 메소드 처리
//		             => userMapper.xml <select id="search"> 1개만 작성
//            XML에서 if를 검색해서 쓰세요 / if을 안 쓰고 방법도 있다.

