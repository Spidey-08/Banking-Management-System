/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginFormWithIconsAndDB extends JFrame implements ActionListener {
    JTextField userText;
    JPasswordField passText;
    JButton submitBtn, cancelBtn;
    JLabel headingLabel;
    JPanel formPanel, buttonPanel;
    ImageIcon userIcon, passIcon;

    public LoginFormWithIconsAndDB() {
        setTitle("Banking System Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Heading
        headingLabel = new JLabel("Login", SwingConstants.CENTER);
        headingLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        headingLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headingLabel, BorderLayout.NORTH);

        // Load icons (update these paths as needed)
        userIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png")); // Example: 24x24
        if (userIcon == null) {
            System.out.println("User icon not found or failed to load!");
        }
        passIcon = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
        if (passIcon == null) {
            System.out.println("Password icon not found or failed to load!");
        }

        // Text fields
        userText = new JTextField(15);
        passText = new JPasswordField(15);

        // Username field with icon
        JPanel userPanel = new JPanel(new BorderLayout(5, 5));
        userPanel.add(new JLabel(userIcon), BorderLayout.WEST);
        userPanel.add(userText, BorderLayout.CENTER);

        // Password field with icon
        JPanel passPanel = new JPanel(new BorderLayout(5, 5));
        passPanel.add(new JLabel(passIcon), BorderLayout.WEST);
        passPanel.add(passText, BorderLayout.CENTER);

        // Labels
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        // Form panel
        formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        formPanel.add(userLabel);
        formPanel.add(userPanel);
        formPanel.add(passLabel);
        formPanel.add(passPanel);

        // Buttons
        submitBtn = new JButton("Submit", userIcon);
        cancelBtn = new JButton("Cancel", passIcon);
        submitBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        buttonPanel = new JPanel();
        buttonPanel.add(submitBtn);
        buttonPanel.add(cancelBtn);

        // Add to frame
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String username = userText.getText();
            String password = new String(passText.getPassword());
            try {
                conn c1 = new conn();
                String q = "select * from login where username='" + username + "' and password='" + password + "'";
                ResultSet rs = c1.execute(q);
                if (rs.next()) {
                    if (username.equals("admin")) {
                        new project(1, username).setVisible(true);
                    } else {
                        new project(0, username).setVisible(true);
                    }
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancelBtn) {
            userText.setText("");
            passText.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFormWithIconsAndDB().setVisible(true);
        });
    }
}