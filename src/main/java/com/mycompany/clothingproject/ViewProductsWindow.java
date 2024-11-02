package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;

public class ViewProductsWindow {
    private JPanel panel;

    public ViewProductsWindow() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3, 10, 10));
        panel.setBackground(new Color(240, 240, 240));

        // إضافة مثال للمنتجات
        for (int i = 1; i <= 6; i++) {
            JPanel productCard = createProductCard("Product " + i, "$" + (i * 10));
            panel.add(productCard);
        }
    }

    public JPanel getPanel() {
        return panel; // إرجاع اللوحة
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
