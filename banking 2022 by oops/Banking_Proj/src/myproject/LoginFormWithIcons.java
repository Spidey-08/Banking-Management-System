package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFormWithIcons extends JFrame implements ActionListener {

    JTextField userText;
    JPasswordField passText;
    JButton submitBtn, cancelBtn;

    public LoginFormWithIcons() {
        setTitle("Banking System Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Heading
        JLabel headingLabel = new JLabel("Login", SwingConstants.CENTER);
        headingLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        headingLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headingLabel, BorderLayout.NORTH);

        // Load icons (update these paths as needed)
        ImageIcon userIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png")); // Example: 24x24
        if (userIcon == null) {
            System.out.println("User icon not found or failed to load!");
        }
        ImageIcon passIcon = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
        if (passIcon == null) {
            System.out.println("Password icon not found or failed to load!");
        }

        // Text fields
        userText = new JTextField(15);
        passText = new JPasswordField(15);

        submitBtn = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
        cancelBtn = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));
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
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        formPanel.add(userLabel);
        formPanel.add(userPanel);
        formPanel.add(passLabel);
        formPanel.add(passPanel);

        // Buttons
        submitBtn = new JButton("Submit");
        cancelBtn = new JButton("Cancel");
        submitBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        JPanel buttonPanel = new JPanel();
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
            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials.");
            }
        } else if (e.getSource() == cancelBtn) {
            userText.setText("");
            passText.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFormWithIcons().setVisible(true);
        });
    }
}
