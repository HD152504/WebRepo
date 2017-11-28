package org.dimigo.dao;

import org.dimigo.vo.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection connection = null;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public UserVO searchUser(UserVO vo) throws Exception {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM IWADB.USER WHERE ID =? AND PWD=?";
        ResultSet rs = null;

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vo.getId());
            preparedStatement.setString(2, vo.getPwd());

            rs = preparedStatement.executeQuery();

            UserVO result = null;

            if(rs.next()) {
                result = new UserVO();
                result.setId(rs.getString(1));
                result.setPwd(vo.getPwd());
                result.setName(rs.getString(3));
            }

            System.out.println(result.getName());
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
        } finally {
            if(rs != null) rs.close();
            if(preparedStatement != null) rs.close();
        }


    }

    public List<UserVO> searchUserList() throws Exception {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID, NAME FROM IWADB.USER";
        ResultSet rs = null;

        try {

            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            UserVO result = null;
            List<UserVO> list = new ArrayList<>();

            while(rs.next()) {
                result = new UserVO(rs.getString("id"), rs.getString("name"));
                list.add(result);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("사용자 목록 조회 시 오류가 발생하였습니다.");
        } finally {
            if(rs != null) rs.close();
            if(preparedStatement != null) preparedStatement.close();
        }


    }

    public UserVO searchUserById(UserVO user) throws Exception {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM IWADB.USER WHERE ID = ?";
        ResultSet rs = null;

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getId());


            //
            rs = preparedStatement.executeQuery();

            UserVO result = null;

            if(rs.next()) {
                result = new UserVO(rs.getString("id"), rs.getString("name"));
            }

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
        } finally {
            if(rs != null) rs.close();
            if(preparedStatement != null) preparedStatement.close();
        }


    }


    public void insertUser(UserVO user) throws Exception {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO IWADB.USER(ID, PWD, NAME) VALUES(?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPwd());
            preparedStatement.setString(3, user.getName());

            // INSERT, UPDATE, DELETE   executeUpdate
            int cnt = preparedStatement.executeUpdate();

            if (cnt == 0) throw new Exception("사용자 등록에 실패하였습니다.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("사용자 등록 시 오류가 발생하였습니다.");
        } finally {
            if (preparedStatement != null) preparedStatement.close();
        }
    }


}
