package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        List<UserDTO>list=sqlSession.selectList("userSQL.getUserList");
        sqlSession.close();
        return list;
    }

    public UserDTO findId(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.close();
        return sqlSession.selectOne("userSQL.findId", id);

    }


    public boolean update(String name){

    }

}
