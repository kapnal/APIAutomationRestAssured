package org.example.misc.JDBC;

import java.sql.*;

public class DBConnect {

    public static void main(String[] args) throws SQLException {

          String sql = "select * from emp where empno=8";
          String url = "jdbc:sqlserver://LAPTOP-5TGTGEIF\\SQLEXPRESS;databaseName=Techsolution;encrypt=true;trustServerCertificate=true";
          String username = "sa";
          String password = "St@tion@123";


        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
       rs.next();
        String name = rs.getString(3);
        System.out.println(name);
        con.close();

        //If we got error go to Services > start SQL Server Browser

//
//        String  connectionURL = "jdbc:sqlserver://LAPTOP-5TGTGEIF\\SQLEXPRESS;databaseName=Techsolution;user=sa;password=St@tion@123;encrypt=true;trustServerCertificate=true";
//        try {
//            System.out.print("Connecting to the server......");
//            try (Connection connection = DriverManager.getConnection(connectionURL))   {
//                System.out.println("Connected to the Server.");
//            }
//        }catch (Exception e){
//            System.out.println("I am not connected to the Server");
//            e.printStackTrace();
//        }

    }
}
