package edu.hbuas.demo1;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpDemo1 {
    public static void main(String[] args) throws SQLException {
        Connection con=null;
        PreparedStatement sta=null;
        ResultSet rs=null;
        try{
            //创建属性对象类
            Properties pro=new Properties();
            //加载连接池配置文件
            pro.load(DbcpDemo1.class.getResourceAsStream("/jdbc.properties"));
            //实例化数据源对象
            DataSource ds= BasicDataSourceFactory.createDataSource(pro);
            //从数据源获取连接
            con=ds.getConnection();
            sta=con.prepareStatement("select * from user ;");
            rs=sta.executeQuery();

            System.out.println("连接成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.printf("连接失败");
        }finally {
           // sta.close();
           // con.close();
        }

        while (rs.next()){
            User user=new User();
            user.setId(rs.getLong(1));
            user.setUname(rs.getString(2));
            user.setPwd(rs.getString(3));
            System.out.println(user.toString());
        }

       // System.out.printf(rs.toString());


    }
}
