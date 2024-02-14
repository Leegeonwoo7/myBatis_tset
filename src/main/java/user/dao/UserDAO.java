package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
    private SqlSessionFactory sqlSessionFactory;

    private static UserDAO userDAO = new UserDAO();

    public static UserDAO getInstance() {
        return userDAO;
    }
    public UserDAO() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write(UserDTO userDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();//생성
        sqlSession.insert("userSQL.write",userDTO);
        sqlSession.commit();
        sqlSession.close();

    }
    public List<UserDTO> getUserList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();//생성
        List<UserDTO> list=sqlSession.selectList("userSQL.getUserList");
        sqlSession.close();
        return list;
    }

    public UserDTO findId(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDTO userDTO = sqlSession.selectOne("userSQL.findId", id);
        sqlSession.close();
        return userDTO;
    }

    public void updateUser(UserDTO userDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("userSQL.update", userDTO);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(UserDTO userDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("userSQL.delete", userDTO);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<UserDTO> search(Map<String, String> map){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserDTO> list= sqlSession.selectList("userSQL.search", map);
        sqlSession.close();
        return list;
    }
}

