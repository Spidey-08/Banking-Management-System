package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class l_deleteaccount extends JFrame implements ActionListener,ItemListener
{
    Choice ch,ch8;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t2,t3,t4,t5,t6,t7,t9;
    JButton b1;
    l_deleteaccount()
    {
        super("Delete Loan Account");
        setSize(210,500);
        setLocation(150,150);
        ch=new Choice();
        try
                {
                    String q="select * from loan";
                    conn c1=new conn();
                    ResultSet rs=c1.execute(q);
                    while(rs.next())
                    {
                        ch.add(rs.getString("id"));
                    }

                }
                catch(Exception e){}
        l1=new JLabel("Choose Loan Id   ");
        l2=new JLabel("CName");
        l3=new JLabel("Loan Amount");
        l4=new JLabel("Start Date");
        l5=new JLabel("No Of Months");
        l6=new JLabel("Rate Of Interest");
        l7=new JLabel("Emi");
        l8=new JLabel("Loan Type");
        l9=new JLabel("Current Status");
        t2=new JTextField(15);
        t3=new JTextField(15);
        t4=new JTextField(15);
        t5=new JTextField(15);
        t6=new JTextField(15);
        t7=new JTextField(15);
        t9=new JTextField(15);
        ch8=new Choice();
        ch8.add("Home Loan");
        ch8.add("Car Loan");
        ch8.add("Cash Loan");
        ch8.add("Others");
        b1=new JButton("Delete");
        setLayout(new FlowLayout());
        add(l1);
        add(ch);
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
        add(ch8);
        add(l9);
        add(t9);
        add(b1);
        ch.addItemListener(this);
        b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae)
    {
        String u1=ch.getSelectedItem();
         try
                {
                    String q="delete from loan where id='"+u1+"'";
                    conn c1=new conn();
                    c1.update(q);
                    JOptionPane.showMessageDialog(null, "Account Deleted");
                    dispose();
                }
                catch(Exception e){}
    }
    public void itemStateChanged(ItemEvent ie)
    {
         String u=ch.getSelectedItem();
         try
                {
                    String q="select * from loan where id='"+u+"'";
                    conn c1=new conn();
                    ResultSet rs=c1.execute(q);
                    while(rs.next())
                    {
                        t2.setText(rs.getString("cname"));
                        t3.setText(rs.getString("loan_amount"));
                        t4.setText(rs.getString("start_date"));
                        t5.setText(rs.getString("no_of_month"));
                        t6.setText(rs.getString("rate_of_interest"));
                        t7.setText(rs.getString("emi"));
                        ch8.select(rs.getString("loan_type"));
                        t9.setText(rs.getString("status"));
                    }

                }
                catch(Exception e){}
    }
}
