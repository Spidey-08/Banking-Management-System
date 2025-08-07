/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ministatement extends JFrame implements ActionListener
{
    
    JLabel l1;
    Integer u1;
    JTextArea a1;
    Panel p1;
    JTable j1;
    Choice ch;
    JButton b1,b2;
    String h[]={"Account no","Debit","Credit","Date and Time","Amount"};
    String d[][],a;
    int i=0,j=0,m;
    float l=0,k=0;
    ministatement()
    {
        super("Mini Statement");
        setSize(800,500);
        setLocation(150,150);
        l1=new JLabel("Choose Account No.");
        ch=new Choice();
        p1=new Panel();
        b1=new JButton("Show");
        b2=new JButton("Print");
        p1.add(l1);
        a1=new JTextArea(20,50);
        p1.add(ch);
        p1.add(b1);
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
        add(p1,"North");
        b1.addActionListener(this);
        b2.addActionListener(this);
        
                
        }
    public void actionPerformed(ActionEvent ae)
    {
        String msg=ae.getActionCommand();
        if(msg.equals("Show"))
        {
            setVisible(false);
            u1=Integer.parseInt(ch.getSelectedItem());
            try
                {
                    String r="select * from transaction where accno='"+u1+"';";
                    conn c1=new conn();
                    d=new String[25][5];
                    ResultSet rs=c1.execute(r);
                     while(rs.next())
                    {
                         d[i][j++]=rs.getString("accno");
                         d[i][j++]=rs.getString("debit");
                         d[i][j++]=rs.getString("credit");
                         d[i][j++]=rs.getString("date_t");
                         d[i][j++]=rs.getString("amount");
                         i++;
                         j=0;
                     }
                    for(m=0;m<i;m++)
                    {
                        l+=Float.parseFloat(d[m][1]);
                        k+=Float.parseFloat(d[m][2]);
                        a=d[m][4];
                    }
                    d[i+1][j++]="Total";
                    d[i+1][j++]=l+"";
                    d[i+1][j++]=k+"";
                    d[i+1][j++]="Balance";
                    d[i+1][j]=a;
                    j=0;
                 j1=new JTable(d,h);
                 JScrollPane s1=new JScrollPane(j1);
                 add(s1);
                 add(b2,"South");
                }
                catch(Exception e){}
            setVisible(true);
            i=0;
        }
        else
        {
           try
           {
             j1.print();
            }catch(Exception e){}
        }
    }

}
