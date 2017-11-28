package org.dimigo.dao;

import org.dimigo.vo.BulletinVO;

import java.util.ArrayList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;


public class BulletinDao {

    private Connection conn = null;
    public BulletinDao(Connection conn) {
        this.conn = conn;
    }
    public BulletinVO searchBoard(BulletinVO vo)throws Exception{
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM BOARD WHERE BOARDNAME=?";
        ResultSet rs = null;
        try{
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            BulletinVO result = null;
            if(rs.next()){
                result = new BulletinVO();
                //    result.setBoardname(rs.getString(1));
                result.setTitle(rs.getString(1));
                result.setAuthor(rs.getString(2));
                result.setDate(rs.getString(3));
                result.setText(rs.getString(4));
            }

            return result;
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("게시글 조회 시 오류가 발생했습니다.");
        } finally {
            if (rs!=null) rs.close();
            if(preparedStatement!=null) preparedStatement.close();
        }
    }

    public void insertBoard(BulletinVO vo, String author)throws Exception{
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO BOARD(title,author,date,text) VALUES(?,?,now(),?)";
        ResultSet rs = null;
//        Date date=new Date();

        try{
            preparedStatement = conn.prepareStatement(sql);
            //  preparedStatement.setString(1, vo.getBoardname());
            preparedStatement.setString(1, vo.getTitle());
            preparedStatement.setString(2, author);
//            preparedStatement.setString(3, date.toString());
            preparedStatement.setString(3, vo.getText());

            int cnt = preparedStatement.executeUpdate();

            if(cnt == 0) throw new Exception("사용자 등록시 오류가 발생했습니다.");

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("사용자 조회 시 오류가 발생했습니다.");
        } finally {
            if(preparedStatement!=null) preparedStatement.close();
        }
    }


    public List<BulletinVO> searchBoardList() throws Exception {

        String sql = "SELECT title, author, date, text FROM IWADB.BOARD";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            BulletinVO result = null;
            List<BulletinVO> list = new ArrayList<>();

            while (rs.next()) {
                result = new BulletinVO();
                result.setTitle(rs.getString(1));
                result.setAuthor(rs.getString(2));
                result.setDate(rs.getString(3));
                result.setText(rs.getString(4));
                list.add(result);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("사용자 조회 시 오류가 발생하였습니다.");
        }
    }

}
