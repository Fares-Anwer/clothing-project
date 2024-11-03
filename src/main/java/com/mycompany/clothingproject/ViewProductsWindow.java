package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

public class ViewProductsWindow {
    public ViewProductsWindow() {
        // إعداد الإطار الرئيسي
        JFrame frame = new JFrame("View Products");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // إعداد لوحة المنتجات
        JPanel productsPanel = new JPanel();
        productsPanel.setLayout(new GridLayout(0, 3, 10, 10));
        productsPanel.setBackground(new Color(240, 240, 240));

        // مثال على المنتجات
        for (int i = 1; i <= 6; i++) {
            JPanel productCard = createProductCard("Product " + i, "$" + (i * 10));
            productsPanel.add(productCard);
        }

        JScrollPane scrollPane = new JScrollPane(productsPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createProductCard(String productName, String price) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        card.setBackground(Color.WHITE);
        card.setPreferredSize(new Dimension(180, 220));

        JLabel nameLabel = new JLabel(productName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        card.add(nameLabel);

        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        card.add(priceLabel);

        JButton addToCartButton = new JButton("Add to Cart");
        card.add(addToCartButton);

        return card;
    }
}
