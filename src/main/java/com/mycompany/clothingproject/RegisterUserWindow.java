package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUserWindow {
    private JPanel panel; // اللوحة الرئيسية لواجهة تسجيل المستخدم

    public RegisterUserWindow() {
        panel = new JPanel(); // تهيئة اللوحة
        panel.setLayout(new BorderLayout()); // تعيين تخطيط الحدود
        panel.setBackground(new Color(245, 245, 245)); // تعيين لون خلفية اللوحة

        // إعداد عنوان النافذة
        JLabel titleLabel = new JLabel("Register New User", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22)); // تعيين حجم الخط ونوعه
        titleLabel.setForeground(new Color(63, 81, 181)); // تعيين لون النص
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // إضافة هوامش

        // إعداد لوحة الإدخال
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); // استخدام تخطيط عمودي
        inputPanel.setBackground(Color.WHITE); // تعيين لون خلفية لوحة الإدخال
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1), // إضافة حدود للوحة
                BorderFactory.createEmptyBorder(10, 20, 10, 20))); // إضافة هوامش داخلية

        // إعداد الحقول لتسجيل المستخدم
        inputPanel.add(createInputLabel("Username:", 16)); // إضافة حقل اسم المستخدم
        JTextField usernameField = new JTextField(15); // إنشاء حقل نص لاسم المستخدم
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين حجم الخط
        usernameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, usernameField.getPreferredSize().height)); // تعيين
                                                                                                                 // الحجم
                                                                                                                 // الأقصى
        inputPanel.add(usernameField); // إضافة حقل اسم المستخدم إلى اللوحة

        inputPanel.add(Box.createVerticalStrut(10)); // إضافة مسافة عمودية

        inputPanel.add(createInputLabel("Email:", 16)); // إضافة حقل البريد الإلكتروني
        JTextField emailField = new JTextField(15); // إنشاء حقل نص للبريد الإلكتروني
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين حجم الخط
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, emailField.getPreferredSize().height)); // تعيين
                                                                                                           // الحجم
                                                                                                           // الأقصى
        inputPanel.add(emailField); // إضافة حقل البريد الإلكتروني إلى اللوحة

        inputPanel.add(Box.createVerticalStrut(10)); // إضافة مسافة عمودية

        inputPanel.add(createInputLabel("Password:", 16)); // إضافة حقل كلمة المرور
        JPasswordField passwordField = new JPasswordField(15); // إنشاء حقل لكلمة المرور
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين حجم الخط
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, passwordField.getPreferredSize().height)); // تعيين
                                                                                                                 // الحجم
                                                                                                                 // الأقصى
        inputPanel.add(passwordField); // إضافة حقل كلمة المرور إلى اللوحة

        inputPanel.add(Box.createVerticalStrut(10)); // إضافة مسافة عمودية

        inputPanel.add(createInputLabel("Confirm Password:", 16)); // إضافة حقل تأكيد كلمة المرور
        JPasswordField confirmPasswordField = new JPasswordField(15); // إنشاء حقل لتأكيد كلمة المرور
        confirmPasswordField.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين حجم الخط
        confirmPasswordField
                .setMaximumSize(new Dimension(Integer.MAX_VALUE, confirmPasswordField.getPreferredSize().height)); // تعيين
                                                                                                                   // الحجم
                                                                                                                   // الأقصى
        inputPanel.add(confirmPasswordField); // إضافة حقل تأكيد كلمة المرور إلى اللوحة

        inputPanel.add(Box.createVerticalStrut(20)); // إضافة مسافة عمودية

        // إعداد زر التسجيل
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("SansSerif", Font.BOLD, 16)); // تعيين حجم الخط
        registerButton.setBackground(new Color(76, 175, 80)); // تعيين لون خلفية الزر
        registerButton.setForeground(Color.WHITE); // تعيين لون النص
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT); // محاذاة الزر في الوسط
        registerButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, registerButton.getPreferredSize().height)); // تعيين
                                                                                                                   // الحجم
                                                                                                                   // الأقصى
        inputPanel.add(registerButton); // إضافة زر التسجيل إلى اللوحة

        inputPanel.add(Box.createVerticalStrut(10)); // إضافة مسافة عمودية

        // إعداد زر التحويل إلى تسجيل الدخول
        JButton loginRedirectButton = new JButton("I have an account");
        loginRedirectButton.setFont(new Font("SansSerif", Font.PLAIN, 14)); // تعيين حجم الخط
        loginRedirectButton.setForeground(new Color(63, 81, 181)); // تعيين لون النص
        loginRedirectButton.setBackground(Color.WHITE); // تعيين لون خلفية الزر
        loginRedirectButton.setBorderPainted(false); // إزالة حدود الزر
        loginRedirectButton.setFocusPainted(false); // إزالة تأثير التركيز
        loginRedirectButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // تغيير المؤشر عند التمرير
        loginRedirectButton.setAlignmentX(Component.CENTER_ALIGNMENT); // محاذاة الزر في الوسط
        loginRedirectButton
                .setMaximumSize(new Dimension(Integer.MAX_VALUE, loginRedirectButton.getPreferredSize().height)); // تعيين
                                                                                                                  // الحجم
                                                                                                                  // الأقصى
        inputPanel.add(loginRedirectButton); // إضافة زر التحويل إلى تسجيل الدخول إلى اللوحة

        // إضافة حدث الضغط على زر التحويل إلى تسجيل الدخول
        loginRedirectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame(); // فتح نافذة تسجيل الدخول عند الضغط على الزر
            }
        });

        // إضافة المكونات إلى اللوحة الرئيسية
        panel.add(titleLabel, BorderLayout.NORTH); // إضافة عنوان النافذة إلى الجزء العلوي
        panel.add(inputPanel, BorderLayout.CENTER); // إضافة لوحة الإدخال إلى الجزء الأوسط
    }

    // دالة لإنشاء تسمية الحقول
    private JLabel createInputLabel(String text, int fontSize) {
        JLabel label = new JLabel(text); // إنشاء تسمية جديدة
        label.setFont(new Font("SansSerif", Font.PLAIN, fontSize)); // تعيين حجم الخط
        label.setAlignmentX(Component.LEFT_ALIGNMENT); // محاذاة التسمية لليسار
        return label; // إرجاع التسمية
    }

    // دالة لإرجاع اللوحة
    public JPanel getPanel() {
        return panel; // إرجاع اللوحة الرئيسية
    }
}
