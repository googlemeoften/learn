package cn.edu.learn.interview.thread.communication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description: ʹ��threadLocalʵ�����ݿ������
 * @author: hey
 * @date 2016/3/28
 * @version: 1.0
 */
public class ConnectionManager {
    private static Log log = LogFactory.getLog(ConnectionManager.class);
    private static ThreadLocal<Connection> connections = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            Connection con = null;

            try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                log.debug("�Ҳ���������");
            }
            return con;
        }
    };

    public static Connection getConnection() {
        return connections.get();
    }

    public void setConnection(Connection con) {
        connections.set(con);
    }

}
