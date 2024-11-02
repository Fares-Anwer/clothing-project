package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

class AddProductWindow {
    public AddProductWindow() {
        // إعداد النافذة الرئيسية
        JFrame frame = new JFrame("Add New Product");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2, 10, 10));
        frame.getContentPane().setBackground(new Color(245, 245, 245)); // لون خلفية النافذة

        // إعداد الخط الأساسي للمكونات
        Font labelFont = new Font("SansSerif", Font.BOLD, 12);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 12);

        // الحقول مع الألوان والتصميم
        JLabel nameLabel = new JLabel("Product Name:");
        nameLabel.setFont(labelFont);
        JTextField nameField = new JTextField();
        nameField.setFont(fieldFont);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(labelFont);
        JTextField priceField = new JTextField();
        priceField.setFont(fieldFont);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(labelFont);
        JTextField quantityField = new JTextField();
        quantityField.setFont(fieldFont);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(labelFont);
        JTextArea descriptionArea = new JTextArea(3, 20);
        descriptionArea.setFont(fieldFont);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        // تخصيص الأزرار
        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(76, 175, 80)); // لون أخضر للأزرار
        saveButton.setForeground(Color.WHITE);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(244, 67, 54)); // لون أحمر للأزرار
        cancelButton.setForeground(Color.WHITE);

        // إضافة المكونات إلى النافذة
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(descriptionLabel);
        frame.add(new JScrollPane(descriptionArea)); // يتيح التمرير للنصوص الطويلة
        frame.add(saveButton);
        frame.add(cancelButton);

        // إعداد النافذة للعرض
        frame.setLocationRelativeTo(null); // لعرض النافذة في منتصف الشاشة
        frame.setVisible(true);
    }
}
