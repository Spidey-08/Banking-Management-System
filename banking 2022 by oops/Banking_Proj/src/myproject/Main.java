/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;

import java.sql.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/myproject", "root", "0708");
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from login");
           while(rs.next())
           {
             System.out.println(rs.getString("type"));
           }
        }catch(Exception e){}
    }

}
