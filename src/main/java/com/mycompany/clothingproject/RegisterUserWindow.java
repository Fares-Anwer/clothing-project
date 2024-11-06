package com.mycompany.clothingproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;

public class RegisterUserWindow {
    private JPanel panel;
    private ClothingStoreApp app; // مرجع لتطبيق ClothingStoreApp

    public RegisterUserWindow(ClothingStoreApp app) {
        this.app = app; // تمرير التطبيق للتحكم بحالة تسجيل الدخول

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));

        JLabel titleLabel = new JLabel("Register New User", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(new Color(63, 81, 181));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));

        inputPanel.add(createInputLabel("Username:", 16));
        JTextField usernameField = new JTextField(15);
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        usernameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, usernameField.getPreferredSize().height));
        inputPanel.add(usernameField);

        inputPanel.add(Box.createVerticalStrut(10));

        inputPanel.add(createInputLabel("Email:", 16));
        JTextField emailField = new JTextField(15);
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, emailField.getPreferredSize().height));
        inputPanel.add(emailField);

        inputPanel.add(Box.createVerticalStrut(10));

        inputPanel.add(createInputLabel("Password:", 16));
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, passwordField.getPreferredSize().height));
        inputPanel.add(passwordField);

        inputPanel.add(Box.createVerticalStrut(10));

        inputPanel.add(createInputLabel("Confirm Password:", 16));
        JPasswordField confirmPasswordField = new JPasswordField(15);
        confirmPasswordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        confirmPasswordField
                .setMaximumSize(new Dimension(Integer.MAX_VALUE, confirmPasswordField.getPreferredSize().height));
        inputPanel.add(confirmPasswordField);

        inputPanel.add(Box.createVerticalStrut(20));

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        registerButton.setBackground(new Color(76, 175, 80));
        registerButton.setForeground(Color.WHITE);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, registerButton.getPreferredSize().height));
        inputPanel.add(registerButton);

        inputPanel.add(Box.createVerticalStrut(10));

        registerButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Please fill in all fields.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(panel, "Passwords do not match.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (addUserToDatabase(username, email, password)) {
                JOptionPane.showMessageDialog(panel, "Registration successful!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                app.updateLoginStatus(true); // تحديث حالة تسجيل الدخول وإعادة التوجيه للصفحة المطلوبة
            } else {
                JOptionPane.showMessageDialog(panel, "Username or email already exists.", "Registration Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);
    }

    private boolean addUserToDatabase(String username, String email, String password) {
        String url = "jdbc:sqlite:database.db";
        String selectQuery = "SELECT * FROM users WHERE username = ? OR email = ?";
        String insertQuery = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url)) {
            // التحقق من عدم وجود المستخدم
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setString(1, username);
                selectStmt.setString(2, email);
                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    return false; // المستخدم أو البريد الإلكتروني موجود بالفعل
                }
            }

            // إضافة المستخدم الجديد
            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, username);
                insertStmt.setString(2, email);
                insertStmt.setString(3, password); // تأكد من تشفير كلمة المرور قبل تخزينها
                insertStmt.executeUpdate();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private JLabel createInputLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, fontSize));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    public JPanel getPanel() {
        return panel;
    }
}
