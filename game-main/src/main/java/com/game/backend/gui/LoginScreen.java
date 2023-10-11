package com.game.backend.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class LoginScreen extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final ImageIcon backgroundImage;

    public LoginScreen() {
        setTitle("Login Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Set the size of the frame

        // Load the background image using the class loader
        backgroundImage = new ImageIcon(getClass().getClassLoader().getResource("login_pic.jpg"));

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Set content pane layout to GridBagLayout for more precise component positioning
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components

        // Set text color for labels and text fields
        Color labelTextColor = Color.decode("#F1E9D2");
        Color borderColor = Color.decode("#F1E9D2");
        Color buttonBackgroundColor = Color.decode("#3E2723"); // Dark Brown

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(labelTextColor); // Set text color
        usernameField = new JTextField(15); // Set the preferred width of the text field
        usernameField.setOpaque(false); // Make the text field transparent
        usernameField.setForeground(labelTextColor); // Set text color
        usernameField.setBorder(new LineBorder(borderColor, 1)); // Set border color
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(labelTextColor); // Set text color
        passwordField = new JPasswordField(15); // Set the preferred width of the password field
        passwordField.setOpaque(false); // Make the password field transparent
        passwordField.setForeground(labelTextColor); // Set text color
        passwordField.setBorder(new LineBorder(borderColor, 1)); // Set border color
        JButton loginButton = new JButton("Login");
        loginButton.setOpaque(true); // Ensure the button is opaque to show the background color
        loginButton.setBackground(buttonBackgroundColor); // Set background color
        loginButton.setForeground(labelTextColor); // Set text color

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle login button click event here
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                // Perform login authentication logic
            }
        });

        // Center components horizontally
        gbc.anchor = GridBagConstraints.CENTER;

        // Add components to the content pane
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPane.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Make the button span across two columns
        contentPane.add(loginButton, gbc);

        setContentPane(contentPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen();
            }
        });
    }
}
