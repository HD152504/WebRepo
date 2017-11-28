package org.dimigo.service;

import org.dimigo.dao.UserDao;
import org.dimigo.vo.UserVO;

import java.sql.Connection;
import java.util.List;

public class UserService extends AbstractService {
    public UserVO login (UserVO user) throws Exception {
        Connection connection = null;

        try {
            connection = getConnection();

            UserDao dao = new UserDao(connection);
            UserVO res = dao.searchUser(user);

            if(res == null) {
                throw new Exception("Invalid id or password!");
            }

            return res;

        } finally {
            if(connection != null) connection.close();
        }

    }

    public List<UserVO> searchUserList() throws Exception {

        Connection connection = null;

        try {
            connection = getConnection();

            UserDao dao = new UserDao(connection);
            return dao.searchUserList();
        } finally {
            if(connection != null) connection.close();
        }
    }

    public void signup(UserVO userVO) throws Exception{

        Connection connection = null;

        try {
            connection = getConnection();

            UserDao dao = new UserDao(connection);
            // 사용중인 아이디인지 체크

            UserVO result = dao.searchUserById(userVO);

            if(result != null) {
                throw new Exception("이미 사용중인 아이디입니다.");
            }

            dao.insertUser(userVO);


        } finally {
            if(connection != null) connection.close();
        }


    }


}
