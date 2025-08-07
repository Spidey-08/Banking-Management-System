/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class c_viewaccount extends JFrame implements ActionListener
{
    JTable j1;
    JButton b1;
    String h[]={"Account No","Name","Gender","Address","City","Phone","Email","Balance"};
    String d[][]=new String[15][8];
    int i=0,j=0;
    c_viewaccount(String u)
    {
        super("View Customer Accounts");
        setSize(600,300);
        setLocation(150,150);

        try
                {
                 String q="";
                 if(u.equals("admin"))
                    q="select * from account;";
                 else
                    q="select * from account where name='"+u+"'";
                    conn c1=new conn();
                    ResultSet rs=c1.execute(q);
                     while(rs.next())
                    {
                        d[i][j++]=rs.getString("accno");
                        d[i][j++]=rs.getString("name");
                        d[i][j++]=rs.getString("gender");
                        d[i][j++]=rs.getString("address");
                        d[i][j++]=rs.getString("city");
                        d[i][j++]=rs.getString("phone");
                        d[i][j++]=rs.getString("email");
                        d[i][j]=rs.getString("balance");
                        i++;
                        j=0;
                    }
                    j1=new JTable(d,h);

                }
                catch(Exception e){}
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
           j1.print();
        }catch(Exception e){}
    }

}
