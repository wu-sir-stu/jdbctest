package edu.hbuas.demo1;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Demo1 {
    public static void main(String[] args) {
        DataSource ds=null;
        Connection con=null;
        try{
            ds=new ComboPooledDataSource("mysql");
            con=ds.getConnection();
            System.out.println("连接状态"+con);

        }catch (Exception e){
            System.out.println("连接失败");
        }
    }
}
