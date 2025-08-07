package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class c_deleteaccount extends JFrame implements ActionListener,ItemListener
{
    Choice ch,ch1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t2,t4,t5,t6,t7,t8;
    JButton b1;
    c_deleteaccount()
    {
        super("Delete Customer Account");
        setSize(180,420);
        setLocation(150,150);
        ch=new Choice();
        try
                {
                    String q="select * from account";
                    conn c1=new conn();
                    ResultSet rs=c1.execute(q);
                    while(rs.next())
                    {
                        ch.add(rs.getString("accno"));
                    }

                }
                catch(Exception e){}
        l1=new JLabel("Choose Account No");
        l2=new JLabel("Name");
        l3=new JLabel("Gender        ");
        l4=new JLabel("Address");
        l5=new JLabel("City");
        l6=new JLabel("Phone");
        l7=new JLabel("Email");
        l8=new JLabel("Balance");
        t2=new JTextField(15);
        ch1=new Choice();
        ch1.add("Male");
        ch1.add("Female");
        t4=new JTextField(15);
        t5=new JTextField(15);
        t6=new JTextField(15);
        t7=new JTextField(15);
        t8=new JTextField(15);
        b1=new JButton("Delete");
        setLayout(new FlowLayout());
        add(l1);
        add(ch);
        add(l2);
        add(t2);
        add(l3);
        add(ch1);
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
        ch.addItemListener(this);
        b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae)
    {
        String u1=ch.getSelectedItem();
        
         try
                {
                    String q="delete from account where accno='"+u1+"'";
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
                    String q="select * from account where accno='"+u+"'";
                    conn c1=new conn();
                    ResultSet rs=c1.execute(q);
                    while(rs.next())
                    {
                        t2.setText(rs.getString("name"));
                        ch1.select(rs.getString("gender"));
                        t4.setText(rs.getString("address"));
                        t5.setText(rs.getString("city"));
                        t6.setText(rs.getString("phone"));
                        t7.setText(rs.getString("email"));
                        t8.setText(rs.getString("balance"));
                    }

                }
                catch(Exception e){}
    }
}
