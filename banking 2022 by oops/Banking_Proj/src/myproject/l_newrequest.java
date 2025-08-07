/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class l_newrequest extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice c8;
    JButton b1,b2;
    l_newrequest()
    {
        super("New Loan Request");
        setSize(180,430);
        setLocation(150,150);
        l1=new JLabel("Loan Id");
        l2=new JLabel("Cusomer Name");
        l3=new JLabel("Loan Amount");
        l4=new JLabel("Start Date");
        l5=new JLabel("No Of Months");
        l6=new JLabel("Rate Of Interest");
        l7=new JLabel("Emi");
        l8=new JLabel("Loan Type");
        t1=new JTextField(15);
        t2=new JTextField(15);
        t3=new JTextField(15);
        t4=new JTextField(15);
        t5=new JTextField(15);
        t6=new JTextField(15);
        t7=new JTextField(15);
        c8=new Choice();
        c8.add("Home Loan");
        c8.add("Car Loan");
        c8.add("Cash Loan");
        c8.add("Others");
        b1=new JButton("Done");
        b2=new JButton("Cancel");
        setLayout(new FlowLayout());
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(l8);
        add(c8);
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
            String u3=t3.getText();
            String u4=t4.getText();
            String u5=t5.getText();
            String u6=t6.getText();
            String u7=t7.getText();
            String u8=c8.getSelectedItem();
            if((u1.equals(""))||(u2.equals(""))||(u3.equals(""))||(u4.equals(""))||(u5.equals(""))||(u6.equals(""))||(u7.equals(""))||(u8.equals("")))
            {
                JOptionPane.showMessageDialog(null,"Each Field must be filled");
            }
            else
            {
                try
                {
                    Float f3=Float.parseFloat(u3);
                    Integer i5=Integer.parseInt(u5);
                    Integer i6=Integer.parseInt(u6);
                    Float f7=Float.parseFloat(u7);
                    String q="insert into loan values('"+u1+"','"+u2+"','"+f3+"','"+u4+"','"+i5+"','"+i6+"','"+f7+"','"+u8+"','Pending')";
                    conn c1=new conn();
                    c1.update(q);
                    JOptionPane.showMessageDialog(null,"New Loan Request Submitted and current status is Pending");
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
