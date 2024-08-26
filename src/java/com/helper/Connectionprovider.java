
package com.helper;
import java.sql.*;
public class Connectionprovider {
    private static Connection con;
  
    public static Connection getConnection()
    {
        
        try{
           
               Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog","root","ankitasoni@");
           
           if(con!=null)
           {
               System.out.print("connect");
           }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.print("not coonect");
        }
        return con;
    }
    
}
