/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class viewaccount extends JFrame implements ActionListener
{
    JTable j1;
    JButton b1;
    String h[]={"Username","Password","Type"};
    String d[][]=new String[15][3];
    int i=0,j=0;
    viewaccount()
    {
        super("View Account");
        setSize(300,300);
        setLocation(150,150);
       
        try
                {
                    String q="select * from login";
                    conn c1=new conn();
                    ResultSet rs=c1.execute(q);
                     while(rs.next())
                    {
                        d[i][j++]=rs.getString("username");
                        d[i][j++]=rs.getString("password");
                        d[i][j]=rs.getString("type");
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
