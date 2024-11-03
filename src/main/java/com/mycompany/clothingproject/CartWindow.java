package com.mycompany.clothingproject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CartWindow {
    private JPanel cartPanel;
    private List<String[]> cartItems;

    public CartWindow(List<String[]> cartItems) {
        this.cartItems = cartItems;
        createCartUI();
    }

    private void createCartUI() {
        cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
        cartPanel.setBackground(new Color(250, 250, 250));

        JLabel titleLabel = new JLabel("Your Shopping Cart");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cartPanel.add(titleLabel);
        cartPanel.add(Box.createRigidArea(new Dimension(0, 20))); // مساحة صغيرة بين العنوان والعناصر

        if (cartItems.isEmpty()) {
            JLabel emptyLabel = new JLabel("Your cart is empty.");
            emptyLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            cartPanel.add(emptyLabel);
        } else {
            for (String[] item : cartItems) {
                JPanel itemPanel = new JPanel();
                itemPanel.setLayout(new BorderLayout());
                itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                itemPanel.setBackground(Color.WHITE);

                JLabel nameLabel = new JLabel(item[1] + " - " + item[2]);
                nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
                itemPanel.add(nameLabel, BorderLayout.CENTER);

                cartPanel.add(itemPanel);
                cartPanel.add(Box.createRigidArea(new Dimension(0, 10))); // مسافة صغيرة بين العناصر
            }
        }
    }

    public JPanel getPanel() {
        return cartPanel;
    }
}
