package org.dimigo.service;

import org.dimigo.dao.BulletinDao;
import org.dimigo.vo.BulletinVO;

import java.sql.Connection;
import java.util.List;

public class BulletinService extends AbstractService{
    public void write(BulletinVO vo, String author) throws Exception{
        Connection conn = null;
        try{
            conn = getConnection();
            BulletinDao dao = new BulletinDao(conn);
            dao.insertBoard(vo,author);


        } finally {
            if(conn != null)conn.close();
        }
    }
    public List<BulletinVO> searchDiaryList() throws Exception{
        Connection conn = null;

        try {
            conn = getConnection();

            BulletinDao dao = new BulletinDao(conn);

            return dao.searchBoardList();

        }finally {
            if(conn != null) conn.close();
        }
    }
}
