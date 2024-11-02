package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

public class ManageOrdersWindow {
    private JPanel panel;

    public ManageOrdersWindow() {
        // إعداد اللوحة الرئيسية
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245)); // لون الخلفية العام

        // عنوان الصفحة
        JLabel titleLabel = new JLabel("Manage Orders", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(63, 81, 181));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // لوحة تحتوي على حقول الإدخال
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // إعداد الحقول
        JLabel orderIdLabel = new JLabel("Order ID:");
        orderIdLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(orderIdLabel, gbc);

        JTextField orderIdField = new JTextField(10);
        orderIdField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(orderIdField, gbc);

        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(customerNameLabel, gbc);

        JTextField customerNameField = new JTextField(15);
        customerNameField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(customerNameField, gbc);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(statusLabel, gbc);

        JComboBox<String> statusComboBox = new JComboBox<>(new String[] { "Pending", "Shipped", "Delivered" });
        statusComboBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(statusComboBox, gbc);

        // زر لتحديث حالة الطلب
        JButton updateButton = new JButton("Update Order");
        updateButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        updateButton.setBackground(new Color(76, 175, 80)); // لون أخضر
        updateButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        inputPanel.add(updateButton, gbc);

        // إضافة العنوان ولوحة الإدخال إلى اللوحة الرئيسية
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }
}
