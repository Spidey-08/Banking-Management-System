/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class project extends JFrame implements ActionListener {

    boolean f1;
    String users = "";

    public project(int n, String user) {
        super("Banking System");
        users = user;
        setSize(1000, 700);
        setLocation(50, 50);
        if (n == 0) {
            f1 = false;
        } else {
            f1 = true;
        }
        JMenuBar mb1 = new JMenuBar();
        setJMenuBar(mb1);



        
        JMenu m1 = new JMenu("User Account");
        m1.setForeground(Color.blue);
        mb1.add(m1);
        JMenuItem m1i1 = new JMenuItem("New Account");
        m1i1.setForeground(Color.blue);
        m1i1.setFont(new Font("monospaced", Font.PLAIN, 12));
        m1i1.setMnemonic('e');
        m1i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/New.png")));
        m1i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        JMenuItem m1i2 = new JMenuItem("View Account");
        m1i2.setForeground(Color.blue);
        m1i2.setFont(new Font("monospaced", Font.PLAIN, 12));
        m1i2.setMnemonic('A');
        m1i2.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/View.png")));
        m1i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        JMenuItem m1i3 = new JMenuItem("Delete Account");
        m1i3.setForeground(Color.blue);
        m1i3.setFont(new Font("monospaced", Font.PLAIN, 12));
        m1i3.setMnemonic('c');
        m1i3.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/EditDelete.png")));
        m1i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

        JMenuItem m1i4 = new JMenuItem("Change Password");
        m1i4.setForeground(Color.blue);
        m1i4.setFont(new Font("monospaced", Font.PLAIN, 12));
        m1i4.setMnemonic('P');
        m1i4.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/EditText.png")));
        m1i4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        m1.add(m1i1);
        m1.add(m1i2);
        m1.add(m1i3);
        m1.add(m1i4);




        JMenu m7 = new JMenu("Customer Account");
        m7.setForeground(Color.red);
        mb1.add(m7);

        JMenuItem m7i1 = new JMenuItem("New CAccount");
        m7i1.setForeground(Color.blue);
        m7i1.setFont(new Font("monospaced", Font.PLAIN, 12));
        m7i1.setMnemonic('C');
        m7i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/New.png")));
        m7i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));

        JMenuItem m7i2 = new JMenuItem("View CAccount Details");
        m7i2.setForeground(Color.blue);
        m7i2.setFont(new Font("monospaced", Font.PLAIN, 12));
        m7i2.setMnemonic('w');
        m7i2.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/View.png")));
        m7i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        JMenuItem m7i3 = new JMenuItem("Update CAccount");
        m7i3.setForeground(Color.blue);
        m7i3.setFont(new Font("monospaced", Font.PLAIN, 12));
        m7i3.setMnemonic('U');
        m7i3.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/EditOpen.png")));
        m7i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));

        JMenuItem m7i4 = new JMenuItem("Delete CAccount");
        m7i4.setForeground(Color.blue);
        m7i4.setFont(new Font("monospaced", Font.PLAIN, 12));
        m7i4.setMnemonic('t');
        m7i4.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/EditDelete.png")));
        m7i4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));

        m7.add(m7i1);
        m7.add(m7i2);
        m7.add(m7i3);
        m7.add(m7i4);




        JMenu m2 = new JMenu("Master");
        m2.setForeground(Color.blue);
        mb1.add(m2);
        JMenuItem m2i1 = new JMenuItem("Deposit");

        m2i1.setForeground((Color.blue));
        m2i1.setFont(new Font("monospaced", Font.PLAIN, 14));
        m2i1.setMnemonic('D');
        m2i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/BRANCH.PNG")));
        m2i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem m2i2 = new JMenuItem("Withdraw");
        m2i2.setForeground((Color.blue));
        m2i2.setFont(new Font("monospaced", Font.PLAIN, 14));
        m2i2.setMnemonic('W');
        m2i2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/INVOICE.PNG")));
        m2i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

        JMenuItem m2i3 = new JMenuItem("List Account");

        m2i3.setForeground((Color.blue));
        m2i3.setFont(new Font("monospaced", Font.PLAIN, 14));
        m2i3.setMnemonic('L');
        m2i3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedule.png")));
        m2i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        m2.add(m2i1);
        m2.add(m2i2);
        m2.add(m2i3);




        JMenu m3 = new JMenu("Statement");
        m3.setForeground(Color.red);
        mb1.add(m3);
        JMenuItem m3i1 = new JMenuItem("Mini Statement");
        m3i1.setForeground((Color.blue));
        m3i1.setFont(new Font("monospaced", Font.PLAIN, 14));
        m3i1.setMnemonic('M');
        m3i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/newexpense.png")));
        m3i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));

        m3.add(m3i1);




        JMenu m4 = new JMenu("Loan");
        m4.setForeground(Color.blue);
        mb1.add(m4);

        JMenuItem m4i1 = new JMenuItem("New Request");
        m4i1.setForeground(Color.blue);
        m4i1.setFont(new Font("monospaced", Font.PLAIN, 12));
        m4i1.setMnemonic('R');
        m4i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/New.png")));
        m4i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));

        JMenuItem m4i2 = new JMenuItem("Accept/Reject Loan Request");
        m4i2.setForeground((Color.blue));
        m4i2.setFont(new Font("monospaced", Font.PLAIN, 14));
        m4i2.setMnemonic('A');
        m4i2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/RECIEVE.PNG")));
        m4i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));

        JMenuItem m4i3 = new JMenuItem("Delete LAccount");
        m4i3.setForeground((Color.blue));
        m4i3.setFont(new Font("monospaced", Font.PLAIN, 14));
        m4i3.setMnemonic('c');
        m4i3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/delete.png")));
        m4i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));

        JMenuItem m4i4 = new JMenuItem("Update LAccount");
        m4i4.setForeground((Color.blue));
        m4i4.setFont(new Font("monospaced", Font.PLAIN, 14));
        m4i4.setMnemonic('U');
        m4i4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/update.png")));
        m4i4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));

        m4.add(m4i1);
        m4.add(m4i2);
        m4.add(m4i3);
        m4.add(m4i4);




        JMenu m6 = new JMenu("Utilities");
        m6.setForeground(Color.blue);
        mb1.add(m6);

        JMenuItem m6i1 = new JMenuItem("Notepad");
        m6i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Java_Icons/New.png")));
        m6i1.setForeground(Color.blue);
        m6i1.setFont(new Font("monospaced", Font.PLAIN, 12));
        m6i1.setMnemonic('o');
        m6i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem m6i2 = new JMenuItem("Calculator");
        m6i2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")));
        m6i2.setForeground(Color.blue);
        m6i2.setFont(new Font("monospaced", Font.PLAIN, 12));
        m6i2.setMnemonic('C');
        m6i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        JMenuItem m6i3 = new JMenuItem("Internet Explorer");
        m6i3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/explorer.jpg")));
        m6i3.setForeground(Color.blue);
        m6i3.setFont(new Font("monospaced", Font.PLAIN, 12));
        m6i3.setMnemonic('E');
        m6i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));



        JMenuItem m6i4 = new JMenuItem("Game");
        m6.add(m6i1);
        m6.add(m6i2);
        m6.add(m6i3);



        JMenu m8 = new JMenu("Exit");
        m8.setForeground(Color.red);
        mb1.add(m8);
        JMenuItem m8i1 = new JMenuItem("Exit");
        m8.add(m8i1);
        m8i1.setForeground((Color.blue));
        m8i1.setFont(new Font("monospaced", Font.PLAIN, 14));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        m8i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));



        if (!user.equals("admin")) {
            m1.setEnabled(false);
            // m2.setEnabled(false);
            m4i2.setEnabled(false);
            m4i3.setEnabled(false);
            m4i4.setEnabled(false);
            // m7i3.setEnabled(false);
            // m7i4.setEnabled(false);
            // m7i1.setEnabled(false);

        }



        m1i1.addActionListener(this);
        m1i2.addActionListener(this);
        m1i3.addActionListener(this);
        m1i4.addActionListener(this);
        m2i1.addActionListener(this);
        m2i2.addActionListener(this);
        m2i3.addActionListener(this);
        m3i1.addActionListener(this);
        m4i1.addActionListener(this);
        m4i2.addActionListener(this);
        m4i3.addActionListener(this);
        m4i4.addActionListener(this);
        m7i1.addActionListener(this);
        m7i2.addActionListener(this);
        m7i3.addActionListener(this);
        m7i4.addActionListener(this);
        m6i1.addActionListener(this);
        m8i1.addActionListener(this);
        m6i2.addActionListener(this);
        m6i3.addActionListener(this);
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/bank1.jpg"))));

    }



    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Account")) {
            new newaccount().setVisible(true);
        } else if (msg.equals("View Account")) {
            new viewaccount().setVisible(true);
        } else if (msg.equals("Delete Account")) {
            new deleteaccount().setVisible(true);
        } else if (msg.equals("Change Password")) {
            new changepassword().setVisible(true);
        } else if (msg.equals("Deposit")) {
            new deposit().setVisible(true);
        } else if (msg.equals("Withdraw")) {
            new withdraw().setVisible(true);
        } else if (msg.equals("List Account")) {
            new listaccount().setVisible(true);
        } else if (msg.equals("Mini Statement")) {
            new ministatement().setVisible(true);
        } else if (msg.equals("Date Wise")) {
            new datewise().setVisible(true);
        } else if (msg.equals("New CAccount")) {
            new c_newaccount().setVisible(true);
        } else if (msg.equals("View CAccount Details")) {
            new c_viewaccount(users).setVisible(true);
        } else if (msg.equals("Update CAccount")) {
            new c_updateaccount().setVisible(true);
        } else if (msg.equals("Delete CAccount")) {
            new c_deleteaccount().setVisible(true);
        } else if (msg.equals("New Request")) {
            new l_newrequest().setVisible(true);
        } else if (msg.equals("Accept/Reject Loan Request")) {
            new l_accept_reject().setVisible(true);
        } else if (msg.equals("Update LAccount")) {
            new l_updateaccount().setVisible(true);
        } else if (msg.equals("Delete LAccount")) {
            new l_deleteaccount().setVisible(true);
        } else if (msg.equals("Notepad")) {
            Runtime r = Runtime.getRuntime();
            Process p = null;
            try {
                String s = "notepad.exe";
                p = r.exec(s);
            } catch (Exception e) {
            }
        } else if (msg.equals("Calculator")) {
            Runtime r = Runtime.getRuntime();
            Process p = null;
            try {
                String s = "calc.exe";
                p = r.exec(s);
            } catch (Exception e) {
            }
        } else if (msg.equals("Internet Explorer")) {
            Runtime r = Runtime.getRuntime();
            Process p = null;
            try {
                String s = "C:\\Program Files\\Internet Explorer\\iexplore.exe";
                p = r.exec(s);
            } catch (Exception e) {
            }
        } else if (msg.equals("Exit")) {
            dispose();
        }
    }
}
