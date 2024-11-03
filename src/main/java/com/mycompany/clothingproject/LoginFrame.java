package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        // إعداد خصائص إطار تسجيل الدخول
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // ظهور الإطار في منتصف الشاشة
        setResizable(false); // منع تغيير حجم الإطار

        // إنشاء اللوحة الرئيسية
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245)); // خلفية فاتحة
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // تباعد بين العناصر

        // عنوان الصفحة
        JLabel titleLabel = new JLabel("Welcome to Clothing Store");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(new Color(63, 81, 181)); // لون نص العنوان
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        // حقل اسم المستخدم
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(usernameField, gbc);

        // حقل كلمة المرور
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        // زر تسجيل الدخول
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(63, 81, 181)); // لون أزرق
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        // زر "I do not have an account"
        JButton registerRedirectButton = new JButton("I do not have an account");
        registerRedirectButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        registerRedirectButton.setForeground(new Color(63, 81, 181)); // لون نص الزر
        registerRedirectButton.setBackground(Color.WHITE);
        registerRedirectButton.setBorderPainted(false);
        registerRedirectButton.setFocusPainted(false);
        registerRedirectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy = 4;
        panel.add(registerRedirectButton, gbc);

        // حدث الضغط على زر "I do not have an account"
        registerRedirectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // فتح نافذة التسجيل عند الضغط على الزر
                JFrame registerFrame = new JFrame("Register");
                registerFrame.setSize(500, 400);
                registerFrame.setLocationRelativeTo(null);
                registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // إضافة واجهة التسجيل إلى الإطار الجديد
                registerFrame.add(new RegisterUserWindow().getPanel());
                registerFrame.setVisible(true);

                // إغلاق نافذة تسجيل الدخول
                dispose();
            }
        });

        // إضافة اللوحة إلى الإطار
        add(panel, BorderLayout.CENTER);
        setVisible(true); // عرض الإطار
    }
}
