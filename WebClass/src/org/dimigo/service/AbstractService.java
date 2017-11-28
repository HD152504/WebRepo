package org.dimigo.service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public abstract class AbstractService {
    public Connection getConnection() throws Exception {
        try {

            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");     //context.lookup(java:comp/env/"context.xml에 지정한 name");
            return dataSource.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("DB Connection Failed");
        }


    }
}
