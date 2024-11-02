package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

class ManageOrdersWindow {
    public ManageOrdersWindow() {
        // إعداد الإطار الرئيسي للنافذة
        JFrame frame = new JFrame("Manage Orders");
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 240, 240)); // لون خلفية النافذة

        // إعداد اللوحة الداخلية
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // تصميم الشبكة مع تباعد بين العناصر
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // مساحة فارغة حول المكونات
        panel.setBackground(new Color(240, 240, 240));

        // إعداد الخطوط
        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 12);

        // الحقول
        JLabel orderIdLabel = new JLabel("Order ID:");
        orderIdLabel.setFont(labelFont);
        JTextField orderIdField = new JTextField(10);
        orderIdField.setFont(fieldFont);

        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setFont(labelFont);
        JTextField customerNameField = new JTextField(15);
        customerNameField.setFont(fieldFont);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setFont(labelFont);
        JComboBox<String> statusComboBox = new JComboBox<>(new String[] { "Pending", "Shipped", "Delivered" });
        statusComboBox.setFont(fieldFont);

        // إعداد الأزرار
        JButton updateButton = new JButton("Update Order");
        updateButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        updateButton.setBackground(new Color(76, 175, 80)); // لون أخضر للأزرار
        updateButton.setForeground(Color.WHITE);

        // إضافة المكونات إلى اللوحة
        panel.add(orderIdLabel);
        panel.add(orderIdField);
        panel.add(customerNameLabel);
        panel.add(customerNameField);
        panel.add(statusLabel);
        panel.add(statusComboBox);
        panel.add(new JLabel()); // مساحة فارغة لضبط التباعد
        panel.add(updateButton);

        // إضافة اللوحة إلى النافذة
        frame.add(panel, BorderLayout.CENTER);

        // عرض النافذة
        frame.setLocationRelativeTo(null); // جعل النافذة تظهر في منتصف الشاشة
        frame.setVisible(true);
    }
}
