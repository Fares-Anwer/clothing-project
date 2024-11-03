package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Login"); // تعيين عنوان نافذة تسجيل الدخول
        setSize(400, 300); // تعيين حجم النافذة
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // تحديد سلوك النافذة عند الإغلاق
        setLayout(new BorderLayout()); // استخدام تخطيط الحدود
        setLocationRelativeTo(null); // محاذاة النافذة في وسط الشاشة
        setResizable(false); // منع تغيير حجم النافذة

        JPanel panel = new JPanel(); // إنشاء لوحة جديدة
        panel.setBackground(new Color(245, 245, 245)); // تعيين لون خلفية اللوحة
        panel.setLayout(new GridBagLayout()); // استخدام GridBagLayout لتخطيط العناصر
        GridBagConstraints gbc = new GridBagConstraints(); // إعداد قيود التخطيط
        gbc.insets = new Insets(10, 10, 10, 10); // إضافة هوامش بين العناصر

        // عنوان الصفحة
        JLabel titleLabel = new JLabel("Welcome to Clothing Store"); // إنشاء عنوان
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18)); // تعيين نوع وحجم الخط
        titleLabel.setForeground(new Color(63, 81, 181)); // تعيين لون النص
        gbc.gridx = 0; // تعيين موقع العنصر في الشبكة
        gbc.gridy = 0;
        gbc.gridwidth = 2; // جعل العنصر يمتد عبر عمودين
        gbc.anchor = GridBagConstraints.CENTER; // محاذاة العنصر في الوسط
        panel.add(titleLabel, gbc); // إضافة العنوان إلى اللوحة

        // إعداد حقل اسم المستخدم
        JLabel usernameLabel = new JLabel("Username:"); // إنشاء تسمية لحقل اسم المستخدم
        usernameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين نوع وحجم الخط
        gbc.gridwidth = 1; // تعيين العنصر ليشغل عمود واحد
        gbc.gridx = 0; // تعيين موضع العنصر
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST; // محاذاة العنصر إلى الشرق
        panel.add(usernameLabel, gbc); // إضافة التسمية إلى اللوحة

        JTextField usernameField = new JTextField(15); // إنشاء حقل نص لاسم المستخدم
        gbc.gridx = 1; // تغيير موضع العنصر
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST; // محاذاة العنصر إلى الغرب
        panel.add(usernameField, gbc); // إضافة حقل اسم المستخدم إلى اللوحة

        // إعداد حقل كلمة المرور
        JLabel passwordLabel = new JLabel("Password:"); // إنشاء تسمية لحقل كلمة المرور
        passwordLabel.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين نوع وحجم الخط
        gbc.gridx = 0; // تغيير موضع العنصر
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST; // محاذاة العنصر إلى الشرق
        panel.add(passwordLabel, gbc); // إضافة التسمية إلى اللوحة

        JPasswordField passwordField = new JPasswordField(15); // إنشاء حقل لكلمة المرور
        gbc.gridx = 1; // تغيير موضع العنصر
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST; // محاذاة العنصر إلى الغرب
        panel.add(passwordField, gbc); // إضافة حقل كلمة المرور إلى اللوحة

        // إعداد زر تسجيل الدخول
        JButton loginButton = new JButton("Login"); // إنشاء زر تسجيل الدخول
        loginButton.setBackground(new Color(63, 81, 181)); // تعيين لون خلفية الزر
        loginButton.setForeground(Color.WHITE); // تعيين لون النص
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14)); // تعيين نوع وحجم الخط
        gbc.gridwidth = 2; // جعل العنصر يمتد عبر عمودين
        gbc.gridx = 0; // تعيين موضع العنصر
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER; // محاذاة العنصر في الوسط
        panel.add(loginButton, gbc); // إضافة الزر إلى اللوحة

        // إعداد زر التحويل إلى التسجيل
        JButton registerRedirectButton = new JButton("I do not have an account"); // إنشاء زر التحويل
        registerRedirectButton.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين نوع وحجم الخط
        registerRedirectButton.setForeground(new Color(63, 81, 181)); // تعيين لون النص
        registerRedirectButton.setBackground(Color.WHITE); // تعيين لون خلفية الزر
        registerRedirectButton.setBorderPainted(false); // إزالة الحدود
        registerRedirectButton.setFocusPainted(false); // إزالة تأثير التركيز
        registerRedirectButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // تغيير المؤشر عند التمرير
        gbc.gridy = 4; // تعيين موضع العنصر
        panel.add(registerRedirectButton, gbc); // إضافة زر التحويل إلى اللوحة

        // إضافة حدث الضغط على زر التحويل إلى التسجيل
        registerRedirectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registerFrame = new JFrame("Register"); // إنشاء نافذة جديدة للتسجيل
                registerFrame.setSize(500, 400); // تعيين حجم النافذة
                registerFrame.setLocationRelativeTo(null); // محاذاة النافذة في وسط الشاشة
                registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // تحديد سلوك النافذة عند الإغلاق

                registerFrame.add(new RegisterUserWindow().getPanel()); // إضافة لوحة تسجيل المستخدم
                registerFrame.setVisible(true); // عرض نافذة التسجيل

                dispose(); // إغلاق نافذة تسجيل الدخول
            }
        });

        // إضافة اللوحة إلى الإطار الرئيسي
        add(panel, BorderLayout.CENTER); // إضافة اللوحة إلى الجزء الأوسط من الإطار
        setVisible(true); // جعل الإطار مرئيًا
    }
}
