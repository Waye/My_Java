package database;

import java.sql.*;

public class connectDB{

    //数据库链接
    public static Connection getConnection()
    {
        Connection conn=null;
        String url="jdbc:mysql://localhost:3306/otherExample";

        try{
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取链接数据库
            conn=DriverManager.getConnection(url,"root","2239weiyijie");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;

    }

    //数据库断开
    public static void closeConnection(Connection conn)
    {
        //判断conn是否已连接对象
        if(conn!=null)
            try{
                //关闭连接
                conn.close();
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
    }


}
