package myproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;
    private static JLabel labelLogo; 

    login(String s) {
        super(s);
        setLayout(new BorderLayout(10, 10));
        setSize(400, 250);
        setLocationRelativeTo(null);

        // Heading
        JLabel headingLabel = new JLabel("Login", SwingConstants.CENTER);
        headingLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        headingLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headingLabel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel userIcon = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/users.png")));
        JLabel passIcon = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/search.png")));

        t1 = new JTextField(15);
        t2 = new JPasswordField(15);

        JPanel userPanel = new JPanel(new BorderLayout());
        userPanel.add(userIcon, BorderLayout.CENTER);
        userPanel.add(t1, BorderLayout.EAST);

        JPanel passPanel = new JPanel(new BorderLayout());
        passPanel.add(passIcon, BorderLayout.CENTER);
        passPanel.add(t2, BorderLayout.EAST);

        centerPanel.add(new JLabel("Username:"));
        centerPanel.add(userPanel);
        centerPanel.add(new JLabel("Password:"));
        centerPanel.add(passPanel);

        add(centerPanel, BorderLayout.CENTER);

        // Buttons Panel
        b1 = new JButton("Submit");

        b2 = new JButton("Cancel");

        b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
        b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));

        b1.addActionListener(this);
        b2.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(b1);
        buttonPanel.add(b2);

        add(buttonPanel, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            conn c1 = new conn();
            String u = t1.getText();
            String v = new String(t2.getPassword());
            String q = "select * from login where username='" + u + "' and password='" + v + "'";
            ResultSet rs = c1.execute(q);
            if (rs.next()) {
                if (u.equals("admin")) {
                    new project(1, u).setVisible(true);
                } else {
                    new project(0, u).setVisible(true);
                }
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new login("Banking System Login").setVisible(true);
    }
}
