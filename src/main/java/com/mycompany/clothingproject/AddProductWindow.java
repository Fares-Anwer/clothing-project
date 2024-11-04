package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddProductWindow {
    private JPanel panel;
    private JLabel imageLabel;

    public AddProductWindow() {
        // إعداد اللوحة الرئيسية
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245)); // لون الخلفية العام

        // عنوان الصفحة
        JLabel titleLabel = new JLabel("Add New Product", SwingConstants.CENTER);
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
        JLabel nameLabel = new JLabel("Product Name:");
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(15);
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(nameField, gbc);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(priceLabel, gbc);

        JTextField priceField = new JTextField(10);
        priceField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(priceField, gbc);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(quantityLabel, gbc);

        JTextField quantityField = new JTextField(5);
        quantityField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(quantityField, gbc);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(descriptionLabel, gbc);

        JTextArea descriptionArea = new JTextArea(4, 15);
        descriptionArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        gbc.gridx = 1;
        gbc.gridy = 3;
        inputPanel.add(new JScrollPane(descriptionArea), gbc);

        // إعداد حقل الصورة وزر التصفح
        JLabel imageLabel = new JLabel("Product Image:");
        imageLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(imageLabel, gbc);

        JButton browseButton = new JButton("Browse");
        browseButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 4;
        inputPanel.add(browseButton, gbc);

        this.imageLabel = new JLabel(); // لعرض الصورة المختارة
        this.imageLabel.setPreferredSize(new Dimension(150, 150));
        gbc.gridx = 1;
        gbc.gridy = 5;
        inputPanel.add(this.imageLabel, gbc);

        // زر لإضافة المنتج
        JButton addButton = new JButton("Add Product");
        addButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        addButton.setBackground(new Color(76, 175, 80)); // لون أخضر
        addButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        inputPanel.add(addButton, gbc);

        // إضافة العنوان ولوحة الإدخال إلى اللوحة الرئيسية
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(inputPanel, BorderLayout.CENTER);

        // الحدث الخاص بزر "Browse"
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage()
                            .getScaledInstance(150, 150, Image.SCALE_SMOOTH));
                    imageLabel.setIcon(imageIcon); // عرض الصورة المختارة
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
