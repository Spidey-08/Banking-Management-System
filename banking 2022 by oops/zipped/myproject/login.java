/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * springboot , hypernet,microservice
 */

package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    login(String s)
    {
        super(s);
        setLayout(new BorderLayout());
t2 = new JPasswordField(10);
t1 = new JTextField(10);
JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\defaultpic.png")));

b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
 b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));
b1.addActionListener(this);
b2.addActionListener(this);
JPanel p1,p2,p3,p4;
p1=new JPanel();
p2=new JPanel();
// p3=new JPanel();
p4=new JPanel();



ImageIcon c1 = new ImageIcon("login.png");
JLabel m1 = new JLabel(c1);

p1.add(m1);
add(l,BorderLayout.WEST);


p2.add(new JLabel("User Name  "));
p2.add(t1);
p2.add(new JLabel("Password "));
p2.add(t2);
add(p2,BorderLayout.CENTER);

p4.add(b1);
p4.add(b2);

add(p4,BorderLayout.SOUTH);



    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            conn c1=new conn();
            String u=t1.getText();
            String v = t2.getText();
            // String v = new String(t2.getPassword());
           
             String q="select * from login where username='"+u+"' and password='"+v+"'";
             ResultSet rs=c1.execute(q);
           if(rs.next())
            {
                 if(u.equals("admin"))
                     new project(1,u).setVisible(true);
                 else
                     new project(0,u).setVisible(true);
                setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception e){e.printStackTrace();}
    }
   


}
