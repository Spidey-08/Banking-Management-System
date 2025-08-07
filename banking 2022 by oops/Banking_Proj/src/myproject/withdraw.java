package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class withdraw extends JFrame implements ActionListener,ItemListener
{
    Choice ch;
    JLabel l1,l2,l3;
    JTextField t2,t3;
    JButton b1;
    withdraw()
    {
        super("Withdraw Account");
        setSize(210,200);
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
        l2=new JLabel("Previous Balance");
        l3=new JLabel("Enter Amount");
        t2=new JTextField(15);
        t3=new JTextField(15);
        b1=new JButton("Withdraw");
        setLayout(new FlowLayout());
        add(l1);
        add(ch);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        ch.addItemListener(this);
        b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae)
    {
        String u1=ch.getSelectedItem();
        Float u2=Float.parseFloat(t2.getText());
        String u4=t3.getText();
        if(u4.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Amount must not be empty");
        }
        else
        {
            Float u3=Float.parseFloat(t3.getText());
         try
                {
                    String q="update account set balance="+(u2-u3)+" where accno="+u1+"";
                    conn c1=new conn();
                    c1.update(q);
                    String d=new java.util.Date().toString();
                    String r = "insert into transaction values("+u1+","+u3+",0,'"+d+"',"+(u2-u3)+")";
                    c1.update(r);
                    JOptionPane.showMessageDialog(null, "Amount Withdrawn and new balance = "+(u2-u3));
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
                    String q="select * from account where accno='"+u+"'";
                    conn c1=new conn();
                    ResultSet rs=c1.execute(q);
                    while(rs.next())
                    {
                        t2.setText(rs.getString("balance"));
                    }

                }
                catch(Exception e){}
    }
}
