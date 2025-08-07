/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class c_newaccount extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t4,t5,t6,t7,t8;
    Choice c1;
    JButton b1,b2;
    c_newaccount()
    {
        super("New Customer Account");
        setSize(180,430);
        setLocation(150,150);
        l1=new JLabel("Account No.");
        l2=new JLabel("Name");
        l3=new JLabel("Gender         ");
        l4=new JLabel("Address");
        l5=new JLabel("City");
        l6=new JLabel("Phone");
        l7=new JLabel("Email");
        l8=new JLabel("Balance");
        t1=new JTextField(15);
        t2=new JTextField(15);
        c1=new Choice();
        c1.add("Male");
        c1.add("Female");
        t4=new JTextField(15);
        t5=new JTextField(15);
        t6=new JTextField(15);
        t7=new JTextField(15);
        t8=new JTextField(15);
        b1=new JButton("Done");
        b2=new JButton("Cancel");
        setLayout(new FlowLayout());
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(c1);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(l8);
        add(t8);
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
            String u1=t1.getText();
            String u2=t2.getText();
            String u3=c1.getSelectedItem();
            String u4=t4.getText();
            String u5=t5.getText();
            String u6=t6.getText();
            String u7=t7.getText();
            String u8=t8.getText();
            if((u1.equals(""))||(u2.equals(""))||(u3.equals(""))||(u4.equals(""))||(u5.equals(""))||(u6.equals(""))||(u7.equals(""))||(u8.equals("")))
            {
                JOptionPane.showMessageDialog(null,"Each Field must be filled");
            }
            else
            {
                try
                {
                    String q="insert into account values('"+u1+"','"+u2+"','"+u3+"','"+u4+"','"+u5+"','"+u6+"','"+u7+"','"+u8+"')";
                    conn c1=new conn();
                    c1.update(q);
                    JOptionPane.showMessageDialog(null,"New Customer Account Created");
                    dispose();
                }
                catch(Exception e){}
            }
        }
        else if(s1.equals("Cancel"))
        {
            dispose();
        }
    }

}
