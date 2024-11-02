package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        // إعداد خصائص إطار تسجيل الدخول
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));
        setLocationRelativeTo(null); // ظهور الإطار في منتصف الشاشة

        // إنشاء الحقول وعناصر الواجهة
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");

        // إضافة المكونات إلى الإطار
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // مساحة فارغة لضبط التباعد
        add(loginButton);

        setVisible(true);
    }
}
