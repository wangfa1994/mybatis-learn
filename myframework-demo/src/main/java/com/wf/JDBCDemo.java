package com.wf;

import java.sql.*;

/**
 * @Desc :
 * @Author : Mr.WangF
 * @Date: 2021/3/7 14:09
 */
public class JDBCDemo {


    /**
     * 1、建立驱动，三种方式，最常用的只有一种 Class.forName(“”oracle.jdbc.driver.OracleDriver);
     * 2、建立连接 Connction conn = DriverManage.getConnection(“url” , “name” ,”password” );
     * 3、创建语句 Statement stmt = conn.createStatement();
     * 4、执行语句 ResultSet rs =stmt.executeQuery(“sql”);
     * 5、循环输出whlie(rs.next){ // … }
     * 6、关闭连接 利用close关闭上述连接
     * @param args
     */
    public static void main(String[] args) {
        Connection conn =null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.jdbc.Driver"); //建立驱动
            // oracle为oracle.jdbc.driver.OracleDriver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","123456");//建立连接
            //oracle为jdbc:oracle:thin:@192.168.2.101:1521:studemo
            stmt = conn.createStatement();//创建语句

            String sql="select * from demo";
            rs = stmt.executeQuery(sql);//执行语句
            while(rs.next()){ //循环输出
                String s= rs.getString("name");
                System.out.println(s);
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{      //关闭连接
                if(rs!=null){rs.close();rs=null;}
                if(stmt!=null){stmt.close();stmt=null;}
                if(conn!=null){conn.close();conn=null;}
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

    }
}
