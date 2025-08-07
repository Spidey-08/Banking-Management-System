package myproject;

import java.sql.*;
public class conn
{
    Connection c;
    Statement s;
    public conn()
    {
        try
        {
        //    Class.forName("com.mysql.jdbc.Driver");
           Class.forName("com.mysql.cj.jdbc.Driver");
           c=DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "0708");
           s=c.createStatement();
        }catch(Exception e){e.printStackTrace();}
    }
    public ResultSet execute(String r) throws Exception
    {
        return(s.executeQuery(r));
    }
    public void update(String t) throws Exception
    {
        s.executeUpdate(t);
    }

}

