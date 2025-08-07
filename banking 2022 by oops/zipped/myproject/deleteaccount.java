package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class deleteaccount extends JFrame implements ActionListener,ItemListener
{
    Choice ch;
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1;
    deleteaccount()
    {
        super("Delete Account");
        setSize(500,200);
        setLocation(150,150);
        ch=new Choice();
        try
                {
                    String q="select * from login";
                    conn c1=new conn();
                    ResultSet rs=c1.execute(q);
                    while(rs.next())
                    {
                        ch.add(rs.getString("username"));
                    }

                }
                catch(Exception e){}
        l1=new JLabel("Choose Username");
        l2=new JLabel("Password");
        l3=new JLabel("Type");
        t1=new JTextField(15);
        t2=new JTextField(15);
        b1=new JButton("Delete");
        setLayout(new FlowLayout());
        add(l1);
        add(ch);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(b1);
        ch.addItemListener(this);
        b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae)
    {
        String u=ch.getSelectedItem();
         try
                {
                    String q="delete from login where username='"+u+"'";
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
                    String q="select * from login where username='"+u+"'";
                    conn c1=new conn();
                    ResultSet rs=c1.execute(q);
                    while(rs.next())
                    {
                        t1.setText(rs.getString("password"));
                        t2.setText(rs.getString("type"));
                    }

                }
                catch(Exception e){}
    }
}
