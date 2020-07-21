package edu.hbuas.demo2;

import edu.hbuas.demo1.User;

import java.util.List;

public class test {
    public static void main(String[] args) {
        String sql="select * from user";
        Object[] params=null;
        List<User> users=DBUtil.Querybyuser(sql,params);
        for (User u:users) {
            System.out.println(u.toString());
        }
    }
}
