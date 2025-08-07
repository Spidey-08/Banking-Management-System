package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class l_updateaccount extends JFrame implements ActionListener,ItemListener
{
    Choice ch,ch8;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t2,t3,t4,t5,t6,t7;
    JButton b1;
    l_updateaccount()
    {
        super("Update Loan Account");
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
        l1=new JLabel("Choose Loan Id");
        l2=new JLabel("Edit CName");
        l3=new JLabel("Edit Loan Amount");
        l4=new JLabel("Edit Start Date");
        l5=new JLabel("Edit No Of Months");
        l6=new JLabel("Edit Rate Of Interest");
        l7=new JLabel("Edit Emi");
        l8=new JLabel("Edit Loan Type");
        t2=new JTextField(15);
        t3=new JTextField(15);
        t4=new JTextField(15);
        t5=new JTextField(15);
        t6=new JTextField(15);
        t7=new JTextField(15);
        ch8=new Choice();
        ch8.add("Home Loan");
        ch8.add("Car Loan");
        ch8.add("Cash Loan");
        ch8.add("Others");
        b1=new JButton("Update");
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
        add(b1);
        ch.addItemListener(this);
        b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae)
    {
        String u1=ch.getSelectedItem();
        String u2=t2.getText();
        String u3=t3.getText();
        String u4=t4.getText();
        String u5=t5.getText();
        String u6=t6.getText();
        String u7=t7.getText();
        String u8=ch8.getSelectedItem();
        if((u2.equals(""))||(u3.equals(""))||(u4.equals(""))||(u5.equals(""))||(u6.equals(""))||(u7.equals(""))||(u8.equals("")))
        {
            JOptionPane.showMessageDialog(null, "Each Field must not be empty");
        }
        else
        {
            Float f3=Float.parseFloat(t3.getText());
            Integer i5=Integer.parseInt(t5.getText());
            Integer i6=Integer.parseInt(t6.getText());
            Float f7=Float.parseFloat(t7.getText());
         try
                {
                    String q="update loan set cname='"+u2+"',loan_amount='"+f3+"',start_date='"+u4+"',no_of_month='"+i5+"',rate_of_interest='"+i6+"',emi='"+f7+"',loan_type='"+u8+"' where id='"+u1+"'";
                    conn c1=new conn();
                    c1.update(q);
                    JOptionPane.showMessageDialog(null, "Account Updated");
                    dispose();
                }
                catch(Exception e){}
        }
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
                    }

                }
                catch(Exception e){}
    }
}
