package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUserWindow {
    private JPanel panel;

    public RegisterUserWindow() {
        // إعداد اللوحة الرئيسية
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245)); // لون الخلفية العام

        // عنوان الصفحة
        JLabel titleLabel = new JLabel("Register New User", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(new Color(63, 81, 181));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // لوحة تحتوي على حقول الإدخال باستخدام BoxLayout لجعلها مرنة
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));

        // إعداد الحقول لتسجيل المستخدم
        inputPanel.add(createInputLabel("Username:", 16));
        JTextField usernameField = new JTextField(15);
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        usernameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, usernameField.getPreferredSize().height));
        inputPanel.add(usernameField);

        inputPanel.add(Box.createVerticalStrut(10)); // مسافة عمودية

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

        // زر لتسجيل الحساب
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        registerButton.setBackground(new Color(76, 175, 80));
        registerButton.setForeground(Color.WHITE);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, registerButton.getPreferredSize().height));
        inputPanel.add(registerButton);

        inputPanel.add(Box.createVerticalStrut(10));

        // زر "I have an account" للانتقال إلى تسجيل الدخول
        JButton loginRedirectButton = new JButton("I have an account");
        loginRedirectButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        loginRedirectButton.setForeground(new Color(63, 81, 181));
        loginRedirectButton.setBackground(Color.WHITE);
        loginRedirectButton.setBorderPainted(false);
        loginRedirectButton.setFocusPainted(false);
        loginRedirectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginRedirectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginRedirectButton
                .setMaximumSize(new Dimension(Integer.MAX_VALUE, loginRedirectButton.getPreferredSize().height));
        inputPanel.add(loginRedirectButton);

        // حدث الضغط على زر "I have an account"
        loginRedirectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // فتح نافذة تسجيل الدخول عند الضغط على الزر
                new LoginFrame();
            }
        });

        // إضافة العنوان ولوحة الإدخال إلى اللوحة الرئيسية
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);
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
