package edu.hbuas.demo2;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import edu.hbuas.demo1.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class  DBUtil {
    /**
     * 获取连接
     * @return
     */
    public static Connection getcon(){
        DataSource ds=null;
        Connection con=null;
        try {
            ds=new ComboPooledDataSource("mysql");
            con=ds.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 通用增删改方法
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql,Object[] params){
        Connection con=null;
        PreparedStatement pre=null;
        int r=-1;
        try {
            con=getcon();
            pre=con.prepareStatement(sql);
            //给占位符传值
            if (params!=null){
                for (int i=0;i<params.length;i++){
                    pre.setObject(i+1,params[i]);
                }
            }
            r=pre.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    /**
     * 通用查询方法
     * @param sql
     * @param params
     * @return
     */
    public static List<User> Querybyuser(String sql,Object... params){
        List<User> users=new ArrayList<>();
        Connection con=null;
        PreparedStatement pre=null;
        try {
            con=getcon();
            pre=con.prepareStatement(sql);
            if (params!=null){
                for (int i=0;i<params.length;i++){
                    pre.setObject(i+1,params[i]);
                }
            }
            ResultSet rs=pre.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setId(rs.getLong("id"));
                user.setUname(rs.getString("uname"));
                user.setPwd(rs.getString("pwd"));
                System.out.println(user.toString());
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    /**
     * 通用关闭连接方法
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void closeAll(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        try{
            if (resultSet!=null){
                resultSet.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
