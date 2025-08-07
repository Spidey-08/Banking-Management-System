/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class newaccount extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JPasswordField p1,p2;
    JTextField t1;
    Choice c1;
    JButton b1,b2;
    newaccount()
    {
        super("New Account");
        setSize(210,300);
        setLocation(150,150);
        l1=new JLabel("Username");
        l2=new JLabel("Password");
        l3=new JLabel("Confirm Password");
        l4=new JLabel("Type");
        p1=new JPasswordField(15);
        p2=new JPasswordField(15);
        t1=new JTextField(15);
        c1=new Choice();
        c1.add("administrator");
        c1.add("customer");
        c1.add("guest");
        b1=new JButton("Done");
        b2=new JButton("Cancel");
        setLayout(new FlowLayout());
        add(l1);
        add(t1);
        add(l4);
        add(c1);
        add(l2);
        add(p1);
        add(l3);
        add(p2);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s1=ae.getActionCommand();
        if(s1.equals("Done"))
        {
            String u=t1.getText();
            String v=c1.getSelectedItem();
            String u1=p1.getText();
            String v1=p2.getText();
            if((u1.equals(v1))&&(u1.length()>1)&&(u.length()>1))
            {
                try
                {
                    String q="insert into login values('"+u+"','"+u1+"','"+v+"')";
                    conn c1=new conn();
                    c1.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"New Account Created");
                    dispose();
                }
                catch(Exception e){}
            }
            else if((u1.length()>1)&&(u.length()>1))
            {
                JOptionPane.showMessageDialog(null,"Passwords does not match");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Password or Username must not be empty");
            }
        }
        else if(s1.equals("Cancel"))
        {
            setVisible(false);
        }
    }
    
}
